package br.com.irsa.training.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.irsa.training.model.Permissoes;
import br.com.irsa.training.model.StatusUser;
import br.com.irsa.training.model.Usuario;

//@Component("userLogado")
//@Scope("session")
public class UsuarioLogado implements Serializable {
	private static final long serialVersionUID = 1L;
	private Usuario user;
	List<Permissoes> allPermissoes;

	public UsuarioLogado() {
		this.allPermissoes = new ArrayList<Permissoes>();
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

	public void setAllPermissoes(List<Permissoes> allPermissoes) {
		this.allPermissoes = allPermissoes;
	}

	public List<Permissoes> getAllPermissoes() {
		return allPermissoes;
	}

	public boolean hasPermissao(String permissao) {
		return this.allPermissoes.contains(permissao);
	}

	public void logOut() {
		this.user = null;
		this.allPermissoes.clear();
	}

}
