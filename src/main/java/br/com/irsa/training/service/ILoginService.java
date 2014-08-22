package br.com.irsa.training.service;


import br.com.irsa.training.model.Login;
import br.com.irsa.training.model.Usuario;


public interface ILoginService {

	public Login getByLogin(String login);
	public Login getByLoginSenha(String login, String senha);
	public Login getById(Long id);
	public void alterarLogin(Usuario usuario, String login,String senha);
	public void alterarLogin(Usuario usuario, Login login);
}
