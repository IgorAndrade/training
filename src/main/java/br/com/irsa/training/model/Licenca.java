package br.com.irsa.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Licenca implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue
	private Long id;
	private String nome;
	@Embedded 
	private Duracao duracao;
	@ElementCollection
	@Enumerated(EnumType.STRING)
	private List<Permissoes> permissoes;
	private boolean ativo;
	
	public Licenca() {
		this.permissoes =  new ArrayList<Permissoes>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public Duracao getDuracao() {
		return duracao;
	}
	public List<Permissoes> getPermissoes() {
		return permissoes;
	}
	public void setDuracao(Duracao duracao) {
		this.duracao = duracao;
	}
	public void setPermissoes(List<Permissoes> permissoes) {
		this.permissoes = permissoes;
	} 
	
	public void addPermissao(Permissoes permissao){
		this.permissoes.add(permissao);
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean getAtivo(){
		return this.ativo;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.id.equals(((Licenca) obj).getId());
	}
}
