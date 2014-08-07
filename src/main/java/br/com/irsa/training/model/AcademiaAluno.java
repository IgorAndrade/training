package br.com.irsa.training.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AcademiaAluno implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario aluno;
	@Id @ManyToOne(fetch=FetchType.EAGER)
	private Academia academia;
	
	public AcademiaAluno() {
		// TODO Auto-generated constructor stub
	}
	public AcademiaAluno(Academia academia,Usuario aluno ) {
		this.academia = academia;
		this.aluno = aluno;
	}
	public Usuario getAluno() {
		return aluno;
	}
	public Academia getAcademia() {
		return academia;
	}
	public void setAluno(Usuario aluno) {
		this.aluno = aluno;
	}
	public void setAcademia(Academia academia) {
		this.academia = academia;
	}
	
	
	
}
