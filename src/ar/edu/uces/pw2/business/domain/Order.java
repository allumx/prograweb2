package ar.edu.uces.pw2.business.domain;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;



@Entity 
@Table(name = "Orden")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Order {
	
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private User user;
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <Item> itemsList;
	private String qr;
	private String orderType;
	private Date date;
	private int total;
	private String orderState;
	
	

	public Order (){
		
	}
	
	
	public Order (User prmUser, List <Item> itemsList,String prmOrderType, Date prmDate, int total){
		this.user= prmUser;
		this.itemsList = itemsList;
		this.orderType = prmOrderType;
		this.date = prmDate;
		this.total = total;
		this.orderState="Pending";
	}
	
	public void isDelivered(){
		this.orderState="delivered";
	}
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
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
	public String getOrderState() {
		return orderState;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (this.id != other.id)
			return false;
		return true;
	}


}
