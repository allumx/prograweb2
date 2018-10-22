package ar.edu.uces.pw2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.pw2.business.dao.FlavourDao;
import ar.edu.uces.pw2.business.dao.OrderDao;
import ar.edu.uces.pw2.business.domain.*;

public class OrderController {
	
	private OrderDao orderDao;

	@RequestMapping(value="/getOrders", method=RequestMethod.GET)
	@ResponseBody
	public List<Order> getOrders() {
		System.out.println("FlavourController:getFlavourList");
	    return orderDao.getAllOrders();
	    
	}
	@RequestMapping(value="/createOrder", method=RequestMethod.POST)
	@ResponseBody
	public Order createOrder(@RequestBody Order newOrder) {
		System.out.println("OrderController:createOrder");
		Order order = orderDao.save(newOrder);		
	    return order;
	}
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	@ResponseBody
	public void createFlavour(@RequestBody int id, Item newItem) {
		System.out.println("OrderController:addItem");
		orderDao.addItem(id, newItem);		 
	}
	@RequestMapping(value="/deleteItem/{id,item}", method=RequestMethod.DELETE)//se pasan asi dos parametros?
	@ResponseBody
	public void deleteFunctionality(@PathVariable int id, Item item) {
		System.out.println("OrderController:deleteItem");
		this.orderDao.deleteItem(id, item);

	}
	
	@Autowired
	public void setFunctionalityDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
