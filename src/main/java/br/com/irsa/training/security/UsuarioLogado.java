package br.com.irsa.training.security;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.enums.StatusUser;
import br.com.irsa.training.model.Usuario;

@Component("userLogado")
@Scope("session")
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario user;
	Map<Object, Set<Permissao>> allPermissoes;

	public UsuarioLogado() {
		this.allPermissoes = new HashMap<Object, Set<Permissao>>();
		this.user = null;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public String getNome() {
		if (user == null || user.getNome() == null)
			return "Anonymous";
		return user.getNome();
	}

	public String getEmail() {
		if (user == null)
			return "Anonymous";
		return user.getEmail();
	}

	public StatusUser getStatus() {
		if (user == null)
			return StatusUser.INATIVO;
		return user.getStatus();
	}

	public void setAllPermissoes(Map<Object, Set<Permissao>> allPermissoes) {
		this.allPermissoes = allPermissoes;
	}

	public Map<Object, Set<Permissao>> getAllPermissoes() {
		return allPermissoes;
	}
	public Set<Permissao> getAllPermissoes(Object obj) {
		return allPermissoes.get(obj);
	}

		
	public boolean hasAllPermissao(Object obj, String... permissoes) {
		for(String permissao : permissoes){
			if(!this.allPermissoes.get(obj).contains(permissao)){
				return false;
			}
		}
		return true;
	}
	
	public boolean hasAnyPermissao(Object obj, String... permissoes) {
		for(String permissao : permissoes){
			if(this.allPermissoes.get(obj).contains(permissao)){
				return true;
			}
		}
		return false;
	}

	public void logOut() {
		this.user = null;
		this.allPermissoes.clear();
	}

}
