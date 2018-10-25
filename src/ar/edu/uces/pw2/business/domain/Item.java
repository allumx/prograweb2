package ar.edu.uces.pw2.business.domain;

import java.util.*;

public class Item {
	private int id;
	private Product product;
	private List <Flavour> flavourList;
	
	public Item() {	
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Item (Product prmProd){
		this.product=prmProd;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Flavour> getFlavourList() {
		return flavourList;
	}
	public void setFlavourList(List<Flavour> flavourList) {
		this.flavourList = flavourList;
	}

	
	

}
