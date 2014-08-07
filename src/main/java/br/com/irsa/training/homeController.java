package br.com.irsa.training;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		
}
