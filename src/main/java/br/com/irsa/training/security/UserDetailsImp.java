package br.com.irsa.training.security;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.irsa.training.model.Login;
import br.com.irsa.training.model.StatusUser;
import br.com.irsa.training.model.Usuario;

public class UserDetailsImp implements UserDetails, Serializable	 {
	private static final long serialVersionUID = 1L;
	private Usuario user;
	private Login login;
	private List<GrantedAuthority> roles;
	

	public UserDetailsImp(Usuario user, Login login,
			List<GrantedAuthority> roles) {
		super();
		this.user = user;
		this.login = login;
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		
		return login.getSenha();
	}

	@Override
	public String getUsername() {
		
		return login.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return user.getStatus().equals(StatusUser.ATIVO);
	}


}
