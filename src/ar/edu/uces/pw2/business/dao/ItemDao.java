package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class ItemDao {
	private FlavourDao flavourDao;
	private Item item;
	//private Product prod = new Product (0,"vasito",2);
	
		
	public ItemDao (Item prmItem ){
		this.item=prmItem;
	}
	
	public ItemDao (){
		super();
	}
	
	
	public Item addItem (List <Flavour> flavours, Product product){
		
		if (flavours.size()<=product.getQuantity()) {
			this.item.setProduct(product);
			this.item.setFlavourList(flavours);	
		}
		return item;
	} 
	
	
}
