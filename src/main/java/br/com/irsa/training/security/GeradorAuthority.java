package br.com.irsa.training.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.irsa.training.enums.Permissao;

public class GeradorAuthority {

	private static final String ROLEPREFIX = "ROLE_"; 
	public static Collection<GrantedAuthority> gerar(List<Permissao> lista){
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Permissao role : lista){
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}
		
		return authorities;
		
		
	}
}
