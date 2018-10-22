package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;
//
@Repository
public class OrderDao {
	private List<Order> ordersList=new ArrayList<Order>();
	
	
	public OrderDao (){
		super();
	}
	
	
	/**
	 * get orders.
	 * @return 
	 */
	public List<Order> getAllOrders(){
        return this.ordersList;
	}
	private Order findById(int id) {
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
	public Order save(Order newOrder){
		int lastIndex = (ordersList.size() - 1);
		int lastID = ordersList.get(lastIndex).getId();
		newOrder.setId(lastID++);
		ordersList.add(newOrder);
		return newOrder;
	}
	/**
	 * add an item in an order
	 * @param order
	 */
	public void addItem(int id, Item item){
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
