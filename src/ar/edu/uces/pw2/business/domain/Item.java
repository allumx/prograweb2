package ar.edu.uces.pw2.business.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Item {
	
	@Id
	@GeneratedValue
	private int id;
	@OneToOne
	private Product product;
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
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
