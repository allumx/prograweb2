package ar.edu.uces.pw2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.uces.pw2.business.model.FunctionalityDto;
import ar.edu.uces.pw2.business.service.FunctionalityService;

@Controller
public class WelcomeController {

	FunctionalityService service;

	public WelcomeController() {
		super();
	}

	@RequestMapping(value="/welcome")
	public String sayWelcome(Model model){

		model.addAttribute("funcionalidades",service.findFunctionalities());

		return "welcome";
	}

	@RequestMapping(value="/welcomeForm")
	public String sayWelcomeForm(Model model){

		model.addAttribute("functionalityDto", new FunctionalityDto());
		return "welcomeForm";
	}

	@RequestMapping(value="/welcomeProcessForm")
	public String actionWelcomeForm(@ModelAttribute("functionalityDto")FunctionalityDto functionalityDto){

		service.save(functionalityDto);

		return "redirect:/functionality";
	}


	@Autowired
	public void setFunctionalityService(FunctionalityService service) {
		this.service = service;
	}
}
