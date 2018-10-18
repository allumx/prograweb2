package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class ProductDao {
	private List <Product> productsList = new ArrayList<Product>();
	
	Product vasito = new Product(0,"vasito",2);
	Product cucurucho  = new Product(1,"cucurucho ",2);
	Product cuatro  = new Product(2,"cuatro ",2);
	Product medio  = new Product(3,"medio",3);
	Product kilo  = new Product(4,"kilo",4);
		
	public ProductDao() {
		this.productsList.add(vasito);
		this.productsList.add(cucurucho);
		this.productsList.add(cuatro);
		this.productsList.add(medio);
		this.productsList.add(kilo);
	}	
	
	public List<Product> getProducts() {
		return productsList;
	}
}

