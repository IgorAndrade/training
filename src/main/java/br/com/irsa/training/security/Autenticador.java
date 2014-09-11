package br.com.irsa.training.security;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.service.IUsuarioService;

@Component("Autenticador") @Profile("producao")
public class Autenticador implements AuthenticationProvider {

	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private ApplicationContext context;
//	@Autowired
//	private HttpSession session;
	
	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		
		 String login = (String) authentication.getPrincipal();
		 String senha = (String) authentication.getCredentials();
		 
		 Usuario usuario = userService.getUserbyLogin(login,senha);
		 
		 if(usuario == null){
			 throw new AuthenticationCredentialsNotFoundException("Usuario ou Senha invalido!");
		 }
		 
		 Map<Object, Set<Permissao>> map = userService.getPermissoes(usuario);
		 Set<Permissao> allPermissoes = map.get(usuario);
		 
		 UsuarioLogado userLogado = (UsuarioLogado) context.getBean("userLogado");
		// UsuarioLogado userLogado = new UsuarioLogado();
		 userLogado.setUser(usuario);
		 userLogado.setAllPermissoes(map);
//		 session.setAttribute("userLogado", userLogado);
		 
		 UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(login,senha, GeradorAuthority.gerar(allPermissoes));
		 
		return token;
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		 return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication)
	                && authentication.equals(UsernamePasswordAuthenticationToken.class);
	    
	}
	
	

}
