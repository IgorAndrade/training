package br.com.irsa.training.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Usuario_Licenca  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuario;
	
	private Calendar dtInicio;
	private Calendar dtFim;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Licenca licenca;
	
	public Usuario_Licenca() {	}
	
	public Usuario_Licenca(Usuario usuario, Licenca licenca) {
		this.usuario = usuario;
		this.licenca = licenca;
	}

	public Long getId() {
		return id;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Licenca getLicenca() {
		return licenca;
	}

	public void setLicenca(Licenca licenca) {
		this.licenca = licenca;
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
