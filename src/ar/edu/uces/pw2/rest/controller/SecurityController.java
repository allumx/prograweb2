package ar.edu.uces.pw2.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jca.context.SpringContextResourceAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
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

	@RequestMapping(value="/register")
	public String showRegistration(Model model){

		model.addAttribute("user", new User());

		return "register";
	}

	@RequestMapping(value="/registerUser")
	public String createUser(@ModelAttribute("user")User user){
		
		
		securityService.saveUser(user);

		return "redirect:login";
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
