package br.com.irsa.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.irsa.training.enums.StatusUser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	@JsonIgnore
	private StatusUser status;
	private String nome;	
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco endereco;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Telefone> tels;
	
	public Usuario() {
		this.tels = new ArrayList<Telefone>();
		this.endereco = new Endereco();
	}
	public Long getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	@JsonProperty(value="telefones")
	public List<Telefone> getTels() {
		return tels;
	}
	
	public void setTels(ArrayList<Telefone> tels) {
		this.tels = tels;
	}
	
	public void addTel(Telefone tel) {
		tel.setUser(this);
		this.tels.add(tel);
	}

	@Override
	public String toString() {
		return this.nome;
	}
	
	public void setStatus(StatusUser status) {
		this.status = status;
	}
	
	public StatusUser getStatus() {
		return status;
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
