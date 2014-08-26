package br.com.irsa.training.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.irsa.training.model.StatusUser;
import br.com.irsa.training.model.Usuario;

@Component("userLogado")
@Scope("session")
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario user;
	List<String> allPermissoes;
	
	public UsuarioLogado() {
		this.allPermissoes = new ArrayList<String>();
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getNome() {
		if(user==null)
			return "Anonymous";
		return user.getNome();
	}

	public String getEmail() {
		if(user==null)
			return "Anonymous";
		return user.getEmail();
	}

	public StatusUser getStatus() {
		if(user==null)
			return StatusUser.INATIVO;
		return user.getStatus();
	}
	
	public void setAllPermissoes(List<String> allPermissoes) {
		this.allPermissoes = allPermissoes;
	}
	
	public List<String> getAllPermissoes() {
		return allPermissoes;
	}
	
	public boolean hasPermissao(String permissao){
		return this.allPermissoes.contains(permissao);
	}
	
	public void logOut(){
		this.user = null;
		this.allPermissoes.clear();
	}
	
}
