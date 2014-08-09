package br.com.irsa.training.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario_Licensa  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
	private Calendar dtInicio;
	private Calendar dtFim;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Licensa licensa;
	
	public Usuario_Licensa(Usuario usuario, Licensa licensa) {
		this.usuario = usuario;
		this.licensa = licensa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Licensa getLicensa() {
		return licensa;
	}

	public void setLicensa(Licensa licensa) {
		this.licensa = licensa;
	}

	public Calendar getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Calendar dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Calendar getDtFim() {
		return dtFim;
	}

	public void setDtFim(Calendar dtFim) {
		this.dtFim = dtFim;
	}
	
	
}
