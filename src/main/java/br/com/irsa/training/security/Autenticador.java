package br.com.irsa.training.security;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
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
	private ApplicationContext context;
	
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		 String login = (String) authentication.getPrincipal();
		 String senha = (String) authentication.getCredentials();
		 
		 Usuario usuario = userService.getUserbyLogin(login,senha);
		 
		 if(usuario == null){
			 throw new AuthenticationCredentialsNotFoundException("Usuario ou Senha invalido!");
		 }
		 
		 List<String> allPermissoes = userService.gelAllPermissoes(usuario);
		 
		 UsuarioLogado userLogado = (UsuarioLogado) context.getBean("userLogado");
		 userLogado.setUser(usuario);
		 userLogado.setAllPermissoes(allPermissoes);
		 
		 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login,senha, GeradorAuthority.gerar(allPermissoes));
		 
		return token;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)
	                && authentication.equals(UsernamePasswordAuthenticationToken.class);
	    
	}
	
	

}
