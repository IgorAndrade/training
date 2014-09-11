package br.com.irsa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irsa.training.model.PersonalProfile;
import br.com.irsa.training.model.Usuario;

public interface IPersonalRepository extends JpaRepository<PersonalProfile, Usuario> {
	
	//public PersonalProfile findByProfessor(Usuario professor);
	
}
