package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;



@Entity
@XmlRootElement(name="Telefone")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private TelefoneTipos tipo;
	private String telefone;
	@ManyToOne
	@XmlTransient
	private Usuario user;
 
	public TelefoneTipos getTipo() {
		return tipo;
	}

	public void setTipo(TelefoneTipos tipo) {
		this.tipo = tipo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public void setUser(Usuario user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}
	@XmlTransient
	public Usuario getUser() {
		return user;
	}
}
