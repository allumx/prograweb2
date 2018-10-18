package ar.edu.uces.pw2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.pw2.business.dao.FlavourDao;
import ar.edu.uces.pw2.business.dao.FunctionalityDao;
import ar.edu.uces.pw2.business.dao.ItemDao;
import ar.edu.uces.pw2.business.domain.Flavour;
import ar.edu.uces.pw2.business.domain.Functionality;

@Controller
public class ItemController {
	/*
	private ItemDao itemDao;

	@RequestMapping(value="/getItemsList", method=RequestMethod.GET)
	@ResponseBody
	public List<Flavour> getAllItems() {
		System.out.println("ItemController:getAllItems");
	   // return itemDao.getAvailableFlavours();
	    
	}
	
	@RequestMapping(value="/addItem", method=RequestMethod.POST)
	@ResponseBody
	public Flavour createFunctionality(@RequestBody Flavour newFlavour) {
		System.out.println("ItemController:addItem");
		//Flavour flavour = itemDao.addFlavour(newFlavour);		
	    return flavour;
	}
	
	@Autowired
	public void setFunctionalityDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
*/
}
