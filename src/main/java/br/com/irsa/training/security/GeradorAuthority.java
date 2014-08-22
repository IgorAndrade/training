package br.com.irsa.training.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class GeradorAuthority {

	private static final String ROLEPREFIX = "ROLE_"; 
	public static Collection<GrantedAuthority> gerar(List<String> lista){
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(String role : lista){
			authorities.add(new SimpleGrantedAuthority(ROLEPREFIX+role));
		}
		
		return authorities;
		
		
	}
}
