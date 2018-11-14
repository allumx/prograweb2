package ar.edu.uces.pw2.business.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Flavour {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int salePrice;
	private int costPrice;
	
	public Flavour(){
	}
	
	public Flavour(int id, String prmName, int prmCostPrice, int prmSalePrice){
		this.id = id;
		this.name=prmName;
		this.costPrice=prmCostPrice;
		this.salePrice=prmSalePrice;
	}
	
	public Flavour (String prmName){
		this.name=prmName;
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
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}
}
