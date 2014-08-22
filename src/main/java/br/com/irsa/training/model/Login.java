package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private final Long id;
	private String login;
	private String senha;
	public Login(Long id,String login, String senha) {
		this.id = id;
		this.login = login;
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	
	
}
