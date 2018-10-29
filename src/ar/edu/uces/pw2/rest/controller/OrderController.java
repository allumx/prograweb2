package ar.edu.uces.pw2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.pw2.business.dao.FlavourDao;
import ar.edu.uces.pw2.business.dao.OrderDao;
import ar.edu.uces.pw2.business.domain.*;

@Controller
public class OrderController {
	
	private OrderDao orderDao;
	@RequestMapping(value="/getOrders", method=RequestMethod.GET)
	@ResponseBody
	public List<Order> getOrders() {
		System.out.println("orderController:getOrders");
	    return orderDao.getAllOrders();
	}
	
	@RequestMapping(value="/createOrder", method=RequestMethod.POST)
	@ResponseBody
	public Order createOrder(@RequestBody Order newOrder) {
		System.out.println("OrderController:createOrder");
		List<Order> listaOrd=orderDao.getAllOrders();
		int id = listaOrd.size();
		newOrder.setId(id);
		Order order = orderDao.createOrder(newOrder);		
	    return order;
	}
	
	@RequestMapping(value="/getOrder", method=RequestMethod.POST)
	@ResponseBody
	public Order getOrder(@RequestBody int id) {
		System.out.println("OrderController:getOrderById");
		Order order = orderDao.findById(id);
		return order;
	}
	
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	@ResponseBody
	public void createFlavour(@RequestBody int id, Item newItem) {
		System.out.println("OrderController:addItem");
		orderDao.addItem(id, newItem);		 
	}
	
	@RequestMapping(value="/deleteItem/{id,item}", method=RequestMethod.DELETE)//averiguar pasar dos parametros
	@ResponseBody
	public void deleteFunctionality(@PathVariable int id, Item item) {
		System.out.println("OrderController:deleteItem");
		this.orderDao.deleteItem(id, item);
	}
	
	
	@RequestMapping(value="/deleteOrder/{id}", method=RequestMethod.DELETE)//averiguar pasar dos parametros
	@ResponseBody
	public List<Order>  deleteFunctionality(@PathVariable int id) {
		System.out.println("OrderController:deleteOrder");
		this.orderDao.deleteOrder(id);
		return orderDao.getAllOrders(); 
	}
	
	@Autowired
	public void setFunctionalityDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
}
