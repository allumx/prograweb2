package ar.edu.uces.pw2.business.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.*;

//
@Repository
public class OrderDao {
	private SessionFactory sessionFactory;
	private ItemDao itemDao;
	private FlavourDao flavourDao;
	private ProductDao productDao;
	private UserDao userDao;
	
	private List<Order> ordersList = new ArrayList<Order>();

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

	// TODO: ver el tema del pending por criterio
	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = (List<Order>) session.createQuery("from Order").list();
		return orders;
	}
	
	@Transactional(readOnly = true)
	public Order findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Order order = (Order) session.get(Order.class, id);
		return order;
	}

	
	@Transactional(readOnly = false)
	public Order createOrder(Order newOrder) {
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
		
		return newOrder;
	}

	public void deleteOrder(int id) {
		for (Order order : this.ordersList) {
			if (order.getId() == id) {
				int index = ordersList.indexOf(order);
				ordersList.remove(index);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void changeState(int id) {
		Session session = sessionFactory.getCurrentSession();
		for (Order order : this.ordersList) {
			if (order.getId() == id) {
				session.update(order);
			}
		}
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
