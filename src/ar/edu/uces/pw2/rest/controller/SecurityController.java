package ar.edu.uces.pw2.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.pw2.business.domain.User;
import ar.edu.uces.pw2.business.service.SecurityService;

@Controller
public class SecurityController {

	SecurityService securityService;

	public SecurityController() {
		super();
	}

	@Autowired
	public SecurityController(SecurityService securityService) {
		super();
		this.securityService = securityService;
	}

	@RequestMapping(value="/registration")
	public String showRegistration(Model model){

		model.addAttribute("user", new User());

		return "registration";
	}

	@RequestMapping(value="/registerUser")
	public String createUser(@ModelAttribute("user")User user){

		securityService.saveUser(user);

		return "redirect:welcome";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;
	}
	
}
