package ar.edu.uces.pw2.rest.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.uces.pw2.business.domain.Flavour;
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

	@RequestMapping(value="/register")
	public String showRegistration(Model model){

		model.addAttribute("user", new User());

		return "register";
	}
	@RequestMapping(value="/registerAdmin")
	public String showRegistrationAdmin(Model model){

		model.addAttribute("user", new User());

		return "usersList";
	}
	
	@RequestMapping(value="/getUsers", method=RequestMethod.GET)
	@ResponseBody
	public List<User> getAllUsers() {
		System.out.println("UserController:getallUsers");
		List<User>  allUsers = securityService.findAllUsers();
	    return allUsers;
	}
	
	@RequestMapping(value="/registerUserAdmin")
	public ModelAndView createAdminUser(@ModelAttribute("userd")User user){
		User usuario=new User();
		usuario=securityService.findUserByEmail(user.getEmail());
		ModelAndView model = new ModelAndView();
		if(usuario!=null) {
			model.setViewName("register");
			model.addObject("userMail", user.getEmail());
			model.addObject("testUser", "existente");
		}
		else {	
			user.setEnabled(true);
			securityService.saveUser(user);
			model.setViewName("login");
		}
		return model;
	}
	
	

	@RequestMapping(value="/registerUser")
	public ModelAndView createUser(@ModelAttribute("user")User user){
		User usuario=new User();
		usuario=securityService.findUserByEmail(user.getEmail());
		ModelAndView model = new ModelAndView();
		if(usuario!=null) {
			model.setViewName("register");
			model.addObject("userMail", user.getEmail());
			model.addObject("testUser", "existente");
		}
		else {	
			user.setEnabled(true);
			securityService.saveUser(user);
			model.setViewName("login");
		}
		return model;
	}
	
	
	@RequestMapping(value="/redirectByRole")
	public String redirectByRole(){

		org.springframework.security.core.userdetails.User user =  
				(org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		String pageToRedirect = "";
		
		if (user.getAuthorities().toString().contains("ROLE_ADMIN")){
			pageToRedirect = "orders";
		} else {
			pageToRedirect = "user-order";
		}
		
		return pageToRedirect;
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
