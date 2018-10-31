package ar.edu.uces.pw2.business.dao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;
//
@Repository
public class OrderDao {
	private ItemDao itemDao;
	private List<Order> ordersList=new ArrayList<Order>();
	
	//crea una orden para prueba
	/*List<Item> listItem=new ArrayList<Item>();
	public User anUser = new User("pepe", "pepe@pepe", "alle1", "45637483",
			"pdfg", "admin");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	public Order anOrder = new Order(anUser, "delivery", date);*/
	
	//
	
	public OrderDao (){
		/*this.listItem.add(new Item());
		this.ordersList.add(anOrder);*/
	}
	
	
	/**
	 * get orders.
	 * @return 
	 */
	public List<Order> getAllOrders(){
		List<Order>PendingOrders = new ArrayList ();
		
		for (Order order : ordersList) {
			if (order.getOrderState().equals("Pending")){
				PendingOrders.add(order);
			}
		}
		return PendingOrders;
	}
	
	
	public Order findById(int id) {
		for (Order order : this.ordersList) {
			if (order.getId()==id){
				return order;
			}
		}		
		return null;
	}
	
	/**
	 * save a new order in ordersList
	 * @param newOrder
	 * @return
	 */
	public Order createOrder(Order newOrder){
		//int lastIndex = (ordersList.size() - 1);
		//int lastID = ordersList.get(lastIndex).getId();
		//newOrder.setId(lastID++);
		ordersList.add(newOrder);
		return newOrder;
	}
	
	/**
	 * delete an item from an order
	 * @param id
	 */
	public void deleteOrder(int id){
		for (Order order : this.ordersList) {
			if (order.getId()==id){
				int index = ordersList.indexOf(order);
				ordersList.remove(index);		
			}
		}	
	}
	
	public void changeState(int id){
		for (Order order : this.ordersList) {
			if (order.getId()==id){
				order.isDelivered();
			}
		}
	}
	/**
	 * add an item in an order
	 * @param order
	 */
	public void addItem(int id, Item item){
		
		this.itemDao.addItem(item.getFlavourList(),item.getProduct());
		Order foundOrder = findById(id);
		foundOrder.getItemsList().add(item);
	}
	
	/**
	 * delete an item from an order
	 * @param id
	 */
	public void deleteItem(int id, Item item){
		Order foundOrder = findById(id);
		foundOrder.getItemsList().remove(item);
	}

}
