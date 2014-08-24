package br.com.irsa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.irsa.training.enums.TypeMsg;

@Controller("LoginController")
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private MessageSource msg;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView loginPage(){
		System.out.println("login");
		return new ModelAndView("login/login");
		
	}
	
	@RequestMapping("/erro")
	public  ModelAndView erro(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject("ERROR",msg.getMessage("erro.login.errologin",null,null));
		return modelAndView;
	}
	@RequestMapping("/logar")
	public  String logar(){
		return "home";
	}
	
	@RequestMapping("/invalidSession")
	public  ModelAndView invalidSession(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject(TypeMsg.ERROR.name(),msg.getMessage("erro.login.invalidSession",null,null));
		return modelAndView;
	}
	@RequestMapping("/accessDenied")
	public  ModelAndView accessDenied(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject(TypeMsg.ERROR.name(),msg.getMessage("erro.login.accessDenied",null,null));
		return modelAndView;
	}
	
	
	@RequestMapping("/expired")
	public  ModelAndView expired(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject(TypeMsg.ERROR.name(),msg.getMessage("erro.login.expired",null,null));
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public  ModelAndView logout(){
		ModelAndView modelAndView = new ModelAndView("login/login");
		modelAndView.addObject(TypeMsg.SUCCESS.name(),msg.getMessage("info.login.logoutSuccess",null,null));
		return modelAndView;
	}
	
}
