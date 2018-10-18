package ar.edu.uces.pw2.business.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.edu.uces.pw2.business.domain.*;

@Repository
public class ItemDao {
	private FlavourDao flavourDao;
	private Item item;
	private List <Item> itemsList = new ArrayList<Item>();

	
	public ItemDao (Item prmItem ){
		this.item=prmItem;
	}
	
	public ItemDao (){
		super();
	}
	
	/*
	public Flavour addFlavour(Item newItem){
		int lastIndex = (itemsList.size() - 1 );
		int lastID = itemsList.get(lastIndex).getId();
		newItem.setId(++lastID);
		availableFlavours.add(newItem);
		return newItem;
	}
	
	*/
	/**
	 * Verify if the list of flavours contains the flavour to add the item.
	 * @param prmName
	 * @return
	 */
	public boolean addFlavours (String prmName){
		for(int i=0;i<=this.item.getProduct().getQuantity();i++){
			Flavour flavour = new Flavour(prmName);
			i++;
			if (this.flavourDao.getAvailableFlavours().contains(flavour)){
				this.item.getFlavourList().add(flavour);
			}else{
				flavour = null; /// en buena practica?
				return false;
			}				
		}
		return true;
	} 
	
	
}
