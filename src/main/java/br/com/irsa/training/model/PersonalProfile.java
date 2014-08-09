package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
public class PersonalProfile implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id @OneToOne
	private Usuario professor;
	private String especialidades;
	
	public PersonalProfile() {
		// TODO Auto-generated constructor stub
	}
	public PersonalProfile(Usuario professor) {
		this.professor = professor;
	}
	
	public Usuario getProfessor() {
		return professor;
	}
	
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	
	public String getEspecialidades() {
		return especialidades;
	}
	public void setEspecialidades(String especialidade) {
		this.especialidades = especialidade;
	}
}
 