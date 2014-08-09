package br.com.irsa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irsa.training.model.Licenca;

public interface ILicencaRepository extends JpaRepository<Licenca, Long> {
	
	

}
