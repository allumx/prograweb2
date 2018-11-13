package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class ProductDao {

	private SessionFactory sessionFactory;
	/*
	Product vasito = new Product(0,"vasito",2);
	Product cucurucho  = new Product(1,"cucurucho ",2);
	Product cuatro  = new Product(2,"cuatro ",2);
	Product medio  = new Product(3,"medio",3);
	Product kilo  = new Product(4,"kilo",4);
		*/
	public ProductDao() {
		super();
		/*
		this.productsList.add(vasito);
		this.productsList.add(cucurucho);
		this.productsList.add(cuarto);
		this.productsList.add(medio);
		this.productsList.add(kilo);
	*/
	}	
	
	@Autowired
	public ProductDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional(readOnly = true)
	public List<Product> getProducts() {
		Session session = sessionFactory.getCurrentSession();
        List<Product> products  = (List<Product>) session.createQuery("from Product").list();
		return products;
	}

	public Product getProductById(int id) {
		Session session = sessionFactory.getCurrentSession();
        return (Product) session.get(Product.class, id);
	}
}

