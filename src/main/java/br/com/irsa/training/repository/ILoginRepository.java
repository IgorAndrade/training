package br.com.irsa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irsa.training.model.Login;


public interface ILoginRepository extends JpaRepository<Login, Long>  {

	public Login findByLogin(String login);
	public Login findByLoginAndSenha(String login, String senha);
}
