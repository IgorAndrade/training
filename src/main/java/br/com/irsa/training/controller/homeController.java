package br.com.irsa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.irsa.training.enums.TypeMsg;
import br.com.irsa.training.model.Usuario;

@RestController
public class homeController {

	@Autowired
	private MessageSource msg;

	@RequestMapping(value = "/home", produces = { "application/json" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");
		mv.addObject(TypeMsg.SUCCESS.name(),
				msg.getMessage("info.login.logoutSuccess", null, null));
		return mv;
	}

	@RequestMapping(value = "/", produces = { "application/json" }, method = RequestMethod.GET)
	public Usuario ret() {
		Usuario usuario = new Usuario();
		usuario.setNome("igor");
		usuario.setEmail("fsdfsf");
		return usuario;
	}

	@RequestMapping(value = "/tabtest", method = RequestMethod.GET)
	public ModelAndView table() {
		ModelAndView mv = new ModelAndView("tables");
		mv.addObject("msgss","sdfsdfsd");
		System.out.println("msg"+msg.getMessage("info.login.logoutSuccess", null, null));
		return mv;
	}

	@RequestMapping(value = "/forms", method = RequestMethod.GET)
	public ModelAndView forms() {
		return new ModelAndView("forms");
	}

}
