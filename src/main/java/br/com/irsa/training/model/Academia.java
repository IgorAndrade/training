package br.com.irsa.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Academia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@OneToMany(mappedBy = "academia", cascade = CascadeType.ALL)
	private List<AcademiaAluno> alunos;
	@OneToMany(mappedBy = "academia", cascade = CascadeType.ALL)
	private List<AcademiaProfessor> professores;

	private String nome;

	public Academia() {
		this.alunos = new ArrayList<AcademiaAluno>();
		this.professores = new ArrayList<AcademiaProfessor>();
	}

	public Long getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public List<AcademiaAluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AcademiaAluno> alunos) {
		this.alunos = alunos;
	}

	public void setAlunos(AcademiaAluno aluno) {
		this.alunos.add(aluno);
	}

	public List<AcademiaProfessor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<AcademiaProfessor> professores) {
		this.professores = professores;
	}

	public void setProfessores(AcademiaProfessor professor) {
		this.professores.add(professor);
	}
}
