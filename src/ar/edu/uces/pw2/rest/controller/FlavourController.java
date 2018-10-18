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
import ar.edu.uces.pw2.business.domain.Flavour;
import ar.edu.uces.pw2.business.domain.Functionality;

@Controller
public class FlavourController {
	
	private FlavourDao flavorDao;

	@RequestMapping(value="/getFlavourList", method=RequestMethod.GET)
	@ResponseBody
	public List<Flavour> getAllFlavour() {
		System.out.println("FlavourController:getFlavourList");
	    return flavorDao.getAvailableFlavours();
	    
	}
	
	@RequestMapping(value="/addFlavour", method=RequestMethod.POST)
	@ResponseBody
	public Flavour createFlavour(@RequestBody Flavour newFlavour) {
		System.out.println("FlavourController:addFlavour");
		Flavour flavour = flavorDao.addFlavour(newFlavour);		
	    return flavour;
	}
	
	@Autowired
	public void setFunctionalityDao(FlavourDao flavourDao) {
		this.flavorDao = flavourDao;
	}

}
