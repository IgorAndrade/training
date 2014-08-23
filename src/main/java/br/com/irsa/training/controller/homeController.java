package br.com.irsa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.irsa.training.model.Usuario;

@RestController
public class homeController {

		@RequestMapping(value="/home",produces={"application/json"},method=RequestMethod.GET)
		public Usuario home(){
			Usuario usuario = new Usuario();
			usuario.setNome("igor");
			usuario.setEmail("fsdfsf");
			return usuario;
		}
		
		@RequestMapping(value="/",produces={"application/json"},method=RequestMethod.GET)
		public Usuario ret(){
			Usuario usuario = new Usuario();
			usuario.setNome("igor");
			usuario.setEmail("fsdfsf");
			return usuario;
		}
		
		
		@RequestMapping(value="/tables",method=RequestMethod.GET)
		public ModelAndView table(){
			return new ModelAndView("tables");
		}
		@RequestMapping(value="/forms",method=RequestMethod.GET)
		public ModelAndView forms(){
			return new ModelAndView("forms");
		}
		
		
}
