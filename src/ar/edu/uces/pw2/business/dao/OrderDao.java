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
	private List<Order> ordersList = new ArrayList<Order>();

	@Autowired
	public OrderDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// TODO: ver el tema del pending por criterio
	@Transactional(readOnly = true)
	public List<Order> getAllOrders() {
		Session session = sessionFactory.getCurrentSession();
		List<Order> orders = (List<Order>) session.createQuery("from Functionality").list();
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
		session.save(newOrder);		
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
