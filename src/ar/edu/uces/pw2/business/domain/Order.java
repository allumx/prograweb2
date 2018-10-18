package ar.edu.uces.pw2.business.domain;

import java.util.*;

public class Order {
	private User user;
	private List <Item> itemsList;
	private String qr;
	private String orderType;
	private Date date;
	private OrderState orderState;
	
	public Order (User prmUser, List <Item> itemsList, String prmOrderType, Date prmDate){
		this.user=prmUser;
		this.itemsList = new ArrayList<Item>();
		this.orderType=prmOrderType;
		this.date=prmDate;		 
	}
	
	public List<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Item> itemsList) {
		this.itemsList = itemsList;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public String getQr() {
		return qr;
	}
	public void setQr(String qr) {
		this.qr = qr;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public OrderState getOrderState() {
		return orderState;
	}
	//NO LO VEO IMPLEMENTABLE=>
	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

}
