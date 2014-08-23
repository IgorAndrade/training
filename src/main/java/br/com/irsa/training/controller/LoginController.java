package br.com.irsa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("LoginController")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private MessageSource msg;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loginPage(){
		return new ModelAndView("login/login");
	}
	
	@RequestMapping("/invalidSession")
	public  ModelAndView invalidSession(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject("error",msg.getMessage("erro.login.invalidSession",null,null));
		return modelAndView;
	}
	
	
	@RequestMapping("/expired")
	public  ModelAndView expired(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject("error",msg.getMessage("erro.login.expired",null,null));
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public  ModelAndView logout(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject("info",msg.getMessage("info.login.logoutSucess",null,null));
		return modelAndView;
	}
	
}
