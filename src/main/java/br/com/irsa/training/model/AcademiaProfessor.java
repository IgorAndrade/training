package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AcademiaProfessor implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario professor;
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	private Academia academia;
	
	public AcademiaProfessor() {
	}
	
	public AcademiaProfessor(Academia academia,Usuario professor ) {
		this.academia = academia;
		this.professor = professor;
	}
	public Usuario getProfessor() {
		return professor;
	}
	public Academia getAcademia() {
		return academia;
	}
	public void setProfessor(Usuario professor) {
		this.professor = professor;
	}
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	
}
