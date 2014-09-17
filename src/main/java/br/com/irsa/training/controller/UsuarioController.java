package br.com.irsa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.irsa.training.model.TelefoneTipos;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.repository.ILicencaRepository;
import br.com.irsa.training.service.IUsuarioService;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/user")
public class UsuarioController {
	private final String userSalvo = "UserSalvo";
	@Autowired
	ILicencaRepository r;
	@Autowired
	private MessageSource msg;
	@Autowired @Qualifier("ObjectMapperCustom")
	ObjectMapper mapper;
	@Autowired
	private IUsuarioService service;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("user/editUser");
		Usuario usuario = new Usuario();
		usuario.setNome("novo");
		mv.addObject("user", usuario);
		return mv;
	}

	@RequestMapping(value = "/novo", method = RequestMethod.GET, produces = "application/json")
	public Usuario novoUser() {
		Usuario usuario = new Usuario();
		usuario.setNome("novo");
		return usuario;
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST, produces = "application/json;charset=UTF-8",consumes={"application/json;charset=UTF-8" ,"application/x-www-form-urlencoded;charset=UTF-8"})
	public JsonResponse salvar(@RequestBody String jsonUser) {
		JsonResponse response = new JsonResponse();
		try {
			Usuario user = mapper.readValue(jsonUser, Usuario.class);
			service.salvar(user);
			response.setStatus(JsonResponse.SUCCESS);
			String[] nomes = { user.getNome() };
			response.setMessage(msg
					.getMessage("info.user.salvoOk", nomes, null));
			
		} catch (RegraNegocioException rn) {
			response.setStatus(JsonResponse.FAIL);
			response.setMessage(rn.getMessage());
		}catch ( JsonParseException jerro) {
			response.setStatus(JsonResponse.FAIL);
			response.setMessage(jerro.getMessage());
		} catch (Exception e) {
			response.setStatus(JsonResponse.FAIL);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Usuario getUser(@PathVariable("id") Long id) {
		Usuario usuario = service.buscarPorID(id);
		return usuario;
	}

	@RequestMapping(value = "/editar/{id}", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView editarUser(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("user");
		mv.addObject("user", service.buscarPorID(id));
		return mv;
	}
	
	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deletar(@PathVariable("id") Long id) throws Exception {
		service.apagarUsuario(id);
		return "ok";
	}

	@RequestMapping(value = "/UserByEmail", method = RequestMethod.GET, produces = "application/json")
	public JsonResponse getUserByEmail(@RequestParam("email") String email) {
		JsonResponse resposta = new JsonResponse();
		Usuario usuario = service.buscarPorEmail(email);
		if (usuario == null) {
			resposta.setStatus(JsonResponse.FAIL);
			resposta.setMessage(msg.getMessage(
					"erro.regranegocio.usuarioNaoEncontrado", null, null));
		} else {
			resposta.setStatus(JsonResponse.SUCCESS);
			resposta.setResult(usuario);
		}
		return resposta;
	}

	@RequestMapping(value = "/telefoneTipos", method = RequestMethod.GET, produces = "application/json")
	public TelefoneTipos[] getTelefoneTipos(){
		return TelefoneTipos.values();
	}

}
