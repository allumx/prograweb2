package ar.edu.uces.pw2.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ar.edu.uces.pw2.business.dao.FlavourDao;
import ar.edu.uces.pw2.business.dao.ProductDao;
import ar.edu.uces.pw2.business.domain.Flavour;
import ar.edu.uces.pw2.business.domain.Product;

@Controller
public class ProductController {
	
	private ProductDao productDao;

	@RequestMapping(value="/getProducts", method=RequestMethod.GET)
	@ResponseBody
	public List<Product> getProductsList() {
		System.out.println("ProductController: getProductsList");
	    return productDao.getProducts();
	}
	
	@Autowired
	public void setFunctionalityDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
