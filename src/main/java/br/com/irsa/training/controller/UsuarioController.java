package br.com.irsa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.ILicencaRepository;
import br.com.irsa.training.service.IUsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	ILicencaRepository r;
	
	@Autowired
	private IUsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView novo(){
		ModelAndView mv = new ModelAndView("user");
		Usuario usuario = new Usuario();
		usuario.setNome("novo");
		mv.addObject("user", usuario);
		return mv;
	}
	@RequestMapping(value="novo",method = RequestMethod.GET, produces = "application/json")
	public Usuario novoUser(){
		Usuario usuario = new Usuario();
		usuario.setNome("novo");
		return usuario;
	}
	
	@RequestMapping(value="/salvar",method = RequestMethod.POST)
	public void salvar(Usuario user){
		
	}
	
	  @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Usuario getUser(@PathVariable("id") Long id){
		  Usuario usuario = service.buscarPorID(id);
		  
		  return  usuario;
	}
	  @RequestMapping(value = "/editar/{id}", method = RequestMethod.GET, produces = "application/json")
	  public ModelAndView editarUser(@PathVariable("id") Long id){
		  ModelAndView mv = new ModelAndView("user");
		  mv.addObject("user",service.buscarPorID(id));
		  return mv ;
	  }
	  
	  @RequestMapping(value = "/l/{id}", method = RequestMethod.GET, produces = "application/json")
		public Licenca teste(@PathVariable("id") Long id){
		  
		  return r.findOne(id);
	  }

}
