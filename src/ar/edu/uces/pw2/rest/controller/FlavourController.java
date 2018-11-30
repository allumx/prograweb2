package ar.edu.uces.pw2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.pw2.business.dao.FlavourDao;
import ar.edu.uces.pw2.business.domain.Flavour;

@Controller
public class FlavourController {
	
	private FlavourDao flavorDao;

	@RequestMapping(value="/getFlavours", method=RequestMethod.GET)
	@ResponseBody
	public List<Flavour> getAllFlavour() {
		System.out.println("FlavourController:getFlavourList");
	    return flavorDao.getFlavours();
	    
	}
	
	@RequestMapping(value="/addFlavour", method=RequestMethod.POST)
	@ResponseBody
	public Flavour createFlavour(@RequestBody Flavour newFlavour) {
		System.out.println("FlavourController:addFlavour");
		Flavour flavour = flavorDao.addFlavour(newFlavour);		
	    return flavour;
	}
	
	@RequestMapping(value="/getFlavour", method=RequestMethod.POST)
	@ResponseBody
	public Flavour getFlavour(@RequestBody int id) {
		System.out.println("FlavourController:getFlavour");
		Flavour flavor = flavorDao.getFlavour(id);
		return flavor;
	}
	
	@RequestMapping(value="/editFlavour", method=RequestMethod.POST)
	@ResponseBody
	public Flavour getFlavour(@RequestBody Flavour flavourToEdit) {
		System.out.println("FlavourController:editFlavour");
		Flavour flavor = flavorDao.editFlavour(flavourToEdit);
		return flavor;
	}
	
	@RequestMapping(value="/deleteFlavour/{id}", method=RequestMethod.DELETE)
	@ResponseBody
	public List<Flavour> deleteFlavour(@PathVariable int id) {
		System.out.println("FlavourController:deleteFlavour");
		this.flavorDao.deleteFlavour(id);
		return flavorDao.getFlavours();
	}
	
	
	
	@Autowired
	public void setFlavourDao(FlavourDao flavourDao) {
		this.flavorDao = flavourDao;
	}

}
