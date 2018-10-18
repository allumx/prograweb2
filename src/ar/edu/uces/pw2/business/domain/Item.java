package ar.edu.uces.pw2.business.domain;

import java.util.*;

public class Item {
	private Product product;
	//private List <Flavour> availableFlavours;///esto no va aca
	private List <Flavour> flavourList;
	
	
	public Item (Product prmProd){
		this.product=prmProd;
	}
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	/*
	public List<Flavour> getAvailableFlavours() {
		return availableFlavours;
	}

	public void setAvailableFlavours(List<Flavour> availableFlavours) {
		this.availableFlavours = availableFlavours;
	}
*/
	public List<Flavour> getFlavourList() {
		return flavourList;
	}

	public void setFlavourList(List<Flavour> flavourList) {
		this.flavourList = flavourList;
	}

	
	

}
