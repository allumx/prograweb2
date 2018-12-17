package ar.edu.uces.pw2.business.dao;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.zxing.WriterException;

import ar.edu.uces.pw2.business.domain.*;

//
@Repository
public class OrderDao {
	private SessionFactory sessionFactory;
	private ItemDao itemDao;
	private FlavourDao flavourDao;
	private ProductDao productDao;
	private UserDao userDao;
	

	public OrderDao() {
		super();
	}

	@Autowired
	public OrderDao(SessionFactory sessionFactory,FlavourDao flavourDao, ProductDao productDao, UserDao userDao  ) {
		this.sessionFactory = sessionFactory;
		this.flavourDao = flavourDao;
		this.productDao= productDao;
		this.userDao = userDao;
	}

	
	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = (List<Order>) session.createQuery("from Order").list();
		List<Order> ordersToreturn=new ArrayList<>();
		for(Order order : orders) {
			if(order.getOrderState().equals("Pendiente"))
				ordersToreturn.add(order);
		}
		return ordersToreturn;
	}
	
	@Transactional(readOnly = true)
	public Order findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, id);
		return order;
	}

	
	@Transactional(readOnly = false)
	public Order createOrder(Order newOrder) throws JsonGenerationException, JsonMappingException, IOException {
		String jsonOrder;
		QRCodeGenerator newQr=new QRCodeGenerator();
		SendMail mail = new SendMail();
		
		Session session = sessionFactory.getCurrentSession();	
		for (Item item : newOrder.getItemsList()) {
			List<Flavour> persistentFlavours = new ArrayList<Flavour>();
			for (Flavour flavour : item.getFlavourList()) {
				persistentFlavours.add(flavourDao.getFlavour(flavour.getId()));
			}
			item.setFlavourList(persistentFlavours);
			
			item.setProduct(productDao.getProductById(item.getProduct().getId()));
		}
		
		newOrder.setUser(userDao.getUserByID(newOrder.getUser().getId()));
		session.merge(newOrder);
		System.out.println(System.getProperty("user.dir"));
		////////Max Qr Test/////
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		jsonOrder = ow.writeValueAsString(newOrder);
		try {
			newQr.generateQRCodeImage(jsonOrder, 350, 350, 
					System.getProperty("user.dir")+"/prograweb2/order.qr");
			System.out.println();
			mail.sendEmail("web2alumax@gmail.com", "web2alumax@gmail.com", "QR para pedido", "Por favor acerquese al local para recoger su pedido");
			System.out.println("Mail mandado");
        } catch (WriterException e) {
            System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
        }
		/////////////////
		
		return newOrder;
	}
	@Transactional(readOnly = false)
	public void deleteOrder(int id) {
		
		Session session=sessionFactory.getCurrentSession();
		Order anOrder;	
		Item anItem;
		
		anOrder=(Order)session.get(Order.class, id);
		
		for (Item item : anOrder.getItemsList()) {
			anItem=(Item)session.get(Item.class, item.getId());
			anItem.getFlavourList().clear();
			session.update(anItem);
		}
		anOrder.getItemsList().clear();
		session.update(anOrder);
		session.delete(anOrder);
	
		session.flush();
		
	}
	
	@Transactional(readOnly = false)
	public void changeState(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order=(Order)session.get(Order.class, id);
		order.setOrderState("C");
		session.update(order);
	}
	@Transactional(readOnly = false)
	public List<Order> filterProfitByDate(FilterDate filterDate) {
		Session session = sessionFactory.getCurrentSession();	
		Criteria crit = session.createCriteria(Order.class)
				.add(Restrictions.ge("date", filterDate.getFrom() ))
				.add(Restrictions.lt("date",filterDate.getTo()))
				.add(Restrictions.eq("orderState","C"));
		List<Order> orderList = crit.list();
		return orderList;
	}


	/**
	 * delete an item from an order
	 * 
	 * @param id
	 */
	public void deleteItem(int id, Item item) {
		Order foundOrder = findById(id);
		foundOrder.getItemsList().remove(item);
	}

}
