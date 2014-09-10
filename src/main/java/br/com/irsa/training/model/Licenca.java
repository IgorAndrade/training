package br.com.irsa.training.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyEnumerated;
import javax.persistence.OneToMany;

import br.com.irsa.training.enums.Perfil;
import br.com.irsa.training.enums.Permissao;

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
	private Set<Permissao> permissoes;
	
	private boolean ativo;
	
	public Licenca() {
		this.permissoes =  new HashSet<Permissao>();
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
	public void setDuracao(Duracao duracao) {
		this.duracao = duracao;
	}
	
	public Set<Permissao> getPermissoes() {
		return permissoes;
	}
	
	public void setPermissoes(Set<Permissao> permissoes) {
		this.permissoes = permissoes;
	}
	
	public void addPermissao(Permissao permissao){
		this.permissoes.add(permissao);
	}
	
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean getAtivo(){
		return this.ativo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Licenca other = (Licenca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
