package ar.edu.uces.pw2.business.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Product {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int quantity;
	private double price;
	private String imagePath;
	
	
	

	public Product (){
	}
		
	public Product(int id, String name, int quantity, double price, String imagePath) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.imagePath = imagePath; 
	}


	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
}
