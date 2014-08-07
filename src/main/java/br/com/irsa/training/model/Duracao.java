package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Duracao implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer dias;
	private Integer mes;
	private Integer anos;
	
	public Duracao() { 
		this.dias = 0;
		this.mes = 0;
		this.anos = 0; 
	}
	
	public Duracao(Integer dias, Integer mes, Integer anos) {
		this.dias = dias;
		this.mes = mes;
		this.anos = anos;
	}
	public Integer getDias() {
		return dias;
	}
	public Integer getMes() {
		return mes;
	}
	public Integer getAnos() {
		return anos;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public void setMes(Integer mes) {
		this.mes = mes;
	}
	public void setAnos(Integer anos) {
		this.anos = anos;
	}
	
	
}
