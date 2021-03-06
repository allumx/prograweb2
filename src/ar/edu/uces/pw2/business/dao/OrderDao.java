package ar.edu.uces.pw2.business.dao;

import java.io.IOException;
import java.util.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.context.SecurityContextHolder;

import com.google.zxing.WriterException;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class OrderDao {
	private SessionFactory sessionFactory;
	private FlavourDao flavourDao;
	private ProductDao productDao;
	private UserDao userDao;


	public OrderDao() {
		super();
	}

	@Autowired
	public OrderDao(SessionFactory sessionFactory, FlavourDao flavourDao,
			ProductDao productDao, UserDao userDao) {
		this.sessionFactory = sessionFactory;
		this.flavourDao = flavourDao;
		this.productDao = productDao;
		this.userDao = userDao;
	}

	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = (List<Order>) session.createQuery("from Order").list();
		List<Order> ordersToreturn = new ArrayList<>();
		for (Order order : orders) {
			if (order.getOrderState().equals("Pendiente"))
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
	public Order createOrder(Order newOrder) {
		String jsonOrder;
		QRCodeGenerator newQr = new QRCodeGenerator();
		SendMail mail = new SendMail();
		
		Session session = sessionFactory.getCurrentSession();
		org.springframework.security.core.userdetails.User logedUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		User user = userDao.findByEmail(logedUser.getUsername());
		newOrder.setUser(user);
		
		for (Item item : newOrder.getItemsList()) {
			List<Flavour> persistentFlavours = new ArrayList<Flavour>();
			for (Flavour flavour : item.getFlavourList()) {
				persistentFlavours.add(flavourDao.getFlavour(flavour.getId()));
			}
			item.setFlavourList(persistentFlavours);

			item.setProduct(productDao
					.getProductById(item.getProduct().getId()));
		}
		
		session.merge(newOrder);
		
		generateEMail(newOrder, newQr, mail, user);
		return newOrder;
	}

	private void generateEMail(Order newOrder, QRCodeGenerator newQr, SendMail mail, User user) {
		System.out.println(System.getProperty("user.dir"));
		
		String jsonOrder;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		try {
			jsonOrder = ow.writeValueAsString(newOrder);
			newQr.generateQRCodeImage(jsonOrder, 350, 350,
					System.getProperty("user.dir") + "/prograweb2/order.qr");
			
			mail.sendEmail("web2alumax@gmail.com", user.getEmail(),
					"QR para pedido","<section class='masthead bg-primary text-white text-center'>"
		+"<center><h1>Heladeria el gordoFreddy</h1></center>"
							+"<h1>"+user.getUserName()+ generateBodyMail(newOrder), newOrder.getQr());
			
		} catch (WriterException e) {
			System.out
					.println("Could not generate QR Code, WriterException :: "
							+ e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not generate QR Code, IOException :: "
					+ e.getMessage());
		}
	}

	@Transactional(readOnly = false)
	public void deleteOrder(int id) {

		Session session = sessionFactory.getCurrentSession();
		Order anOrder;
		Item anItem;

		anOrder = (Order) session.get(Order.class, id);

		for (Item item : anOrder.getItemsList()) {
			anItem = (Item) session.get(Item.class, item.getId());
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
		Order order = (Order) session.get(Order.class, id);
		order.setOrderState("Completada");
		session.update(order);
	}

	@Transactional(readOnly = false)
	public List<Order> filterProfitByDate(FilterDate filterDate) {
		Session session = sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(Order.class)
				.add(Restrictions.ge("date", filterDate.getFrom()))
				.add(Restrictions.le("date", filterDate.getTo()))
				.add(Restrictions.eq("orderState", "Completada"));
		List<Order> orderList = crit.list();
		return orderList;
	}
	
	public String generateBodyMail(Order newOrder) {
		if(newOrder.getQr().toString().equals("false")) {
			return " su pedido ha sido registrado por favor acerquese al local para retirar su helado</h1>"
							+ genHtmlCode(newOrder);
		}
		else
			return " su pedido ha sido registrado pronto lo estara recibiendo</h1>"
						+genHtmlCode(newOrder);
	}
	
	private String genHtmlCode(Order newOrder) {
		String html="";
		for(Item item : newOrder.getItemsList()) {
			html=html+"<h2>"+item.getProduct().getName()+"</h2>\n\n<ul>\n";
			for(Flavour flavour : item.getFlavourList()) {
				html=html+"<li>"+flavour.getName()+"</li>";
			}
			html=html+"</ul>\n";
		}
		html=html+"\n"+"<h2>Total a abonar: $" +newOrder.getTotal()+".-</h2></section>";
		return html;
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
