package br.com.irsa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irsa.training.model.Licensa;

public interface ILicensaRepository extends JpaRepository<Licensa, Long> {
	
	

}
