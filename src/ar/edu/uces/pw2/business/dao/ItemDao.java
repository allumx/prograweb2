package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class ItemDao {
	private SessionFactory sessionFactory;

	private FlavourDao flavourDao;
	private ProductDao productDao;

	private Item item;
	//private Product prod = new Product (0,"vasito",2);
	
	
	@Autowired
	public ItemDao(SessionFactory sessionFactory, ProductDao productDao, FlavourDao flavourDao) {
		super();
		this.flavourDao = flavourDao;
		this.productDao = productDao;
		this.sessionFactory = sessionFactory;
	}
	
	public ItemDao (){
		super();
	}
	
	
	@Transactional(readOnly = false)
	public Item addItem (List <Flavour> flavours, Product product){
		Session session = sessionFactory.getCurrentSession();
		if (flavours.size()<=product.getQuantity()) {
			Item itemToSave = new Item();
			itemToSave.setProduct(product);
			itemToSave.setFlavourList(flavours);
			session.save(itemToSave);
			return itemToSave;
		}
		return null;
	} 
	
}
