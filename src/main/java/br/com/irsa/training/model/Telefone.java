package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	@Enumerated(EnumType.STRING)
	private TelefoneTipos tipo;
	private String telefone;
	
 public Telefone() {}
	public Telefone(TelefoneTipos tipo,String telefone) {
		this.tipo = tipo;
		this.telefone = telefone;
	}
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

	public Long getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Tipo: "+this.tipo.name()+" - "+this.telefone;
	}
	
}
