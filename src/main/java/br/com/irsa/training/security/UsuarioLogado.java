package br.com.irsa.training.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.enums.StatusUser;
import br.com.irsa.training.model.Usuario;

//@Component("userLogado")
//@Scope("session")
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

	public boolean hasPermissao(String permissao) {
		return this.allPermissoes.get(getUser()).contains(permissao);
	}
	
	public boolean hasPermissao(Object obj, String permissao) {
		return this.allPermissoes.get(obj).contains(permissao);
	}

	public void logOut() {
		this.user = null;
		this.allPermissoes.clear();
	}

}
