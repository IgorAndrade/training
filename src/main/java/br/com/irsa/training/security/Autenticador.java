package br.com.irsa.training.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.irsa.training.model.Login;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.service.ILoginService;
import br.com.irsa.training.service.IUsuarioService;

@Component("Autenticador")
public class Autenticador implements AuthenticationProvider {

	@Autowired
	private IUsuarioService userService;
	@Autowired
	@Qualifier("LoginService")
	private ILoginService loginService;
	
	
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		 String login = (String) authentication.getPrincipal();
		 Login loginExistente = loginService.getByLogin(login);
		 if(loginExistente == null){
			 throw new AuthenticationCredentialsNotFoundException("Usuario ou Senha invalido!");
		 }
		 Usuario usuario = userService.buscarPorID(loginExistente.getId());
		 List<String> allPermissoes = userService.gelAllPermissoes(usuario);
		
		 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginExistente.getLogin(),loginExistente.getSenha(), GeradorAuthority.gerar(allPermissoes));
		 
		
		return token;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)
	                && authentication.equals(UsernamePasswordAuthenticationToken.class);
	    
	}
	
	

}
