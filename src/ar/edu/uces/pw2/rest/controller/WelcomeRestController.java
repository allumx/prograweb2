package ar.edu.uces.pw2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.pw2.business.dao.FunctionalityDao;
import ar.edu.uces.pw2.business.domain.Functionality;

@Controller
public class WelcomeRestController {

	private FunctionalityDao functionalityDao;

	@RequestMapping(value="/functionality", method=RequestMethod.GET)
	@ResponseBody
	public List<Functionality> getAllFunctionality() {

	    return functionalityDao.findAll();
	}

	@RequestMapping(value="/functionality/{functionalityId}", method=RequestMethod.GET)
	@ResponseBody
	public List<Functionality> getFunctionality(@PathVariable String functionalityId) {

		List<Functionality> listFunctionality = functionalityDao.findAll();

	    return listFunctionality;
	}

	@RequestMapping(value="/functionality", method=RequestMethod.POST)
	@ResponseBody
	public Functionality createFunctionality(@RequestBody Functionality newFunctionality) {

		Functionality functionality = functionalityDao.save(newFunctionality);

	    return functionality;
	}

	@RequestMapping(value="/functionality", method=RequestMethod.PUT)
	@ResponseBody
	public Functionality updateFunctionality(@RequestBody Functionality toUpdateFunctionality) {

		Functionality functionality = functionalityDao.update(toUpdateFunctionality);

	    return functionality;
	}

	@RequestMapping(value="/functionality/{functionalityId}", method=RequestMethod.DELETE)
	@ResponseBody
	public List<Functionality> deleteFunctionality(@PathVariable String functionalityId) {

		functionalityDao.delete(Integer.valueOf(functionalityId));

	    return functionalityDao.findAll();
	}

	@Autowired
	public void setFunctionalityDao(FunctionalityDao functionalityDao) {
		this.functionalityDao = functionalityDao;
	}
}
