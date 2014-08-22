package br.com.irsa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irsa.training.model.Login;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.ILoginRepository;

@Service("LoginService")
public class LoginService implements ILoginService {

	@Autowired
	private ILoginRepository repository;
	
	@Override
	public Login getByLogin(String login) {
		
		return repository.findByLogin(login);
	}

	@Override
	public Login getByLoginSenha(String login, String senha) {
		return repository.findByLoginAndSenha(login, senha);
	}

	@Override
	public Login getById(Long id) {
		return repository.getOne(id);
	}

	@Override
	public void alterarLogin(Usuario usuario, Login login) {
		Login loginExistente = repository.getOne(usuario.getId());
		if(loginExistente == null)
			repository.save(login);
		else{
			loginExistente.setLogin(login.getLogin());
			loginExistente.setSenha(login.getSenha());
			repository.save(loginExistente);
		}
		
		
	}
	
	@Override
	public void alterarLogin(Usuario usuario, String login, String senha) {
		Login loginExistente = repository.getOne(usuario.getId());
		if(loginExistente == null){
		Login novoLogin = new Login(usuario.getId(),login,senha);
		repository.save(novoLogin);
		}else{
			loginExistente.setLogin(login);
			loginExistente.setSenha(senha);
			repository.save(loginExistente);
		}
		
	}
}
