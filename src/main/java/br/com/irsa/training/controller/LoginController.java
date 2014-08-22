package br.com.irsa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("LoginController")
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView loginPage(){
		
		return new ModelAndView("login/login");
		
	}
}
