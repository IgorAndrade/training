package br.com.irsa.training.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.model.Login;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.ILoginRepository;
import br.com.irsa.training.repository.IUsuarioRepository;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository userRepository;
	@Autowired
	private IUsuario_LicencaRepository ULrepository;
	@Autowired
	private ILoginRepository loginRepository;
	

	@Override
	public void salvar(Usuario user) throws Exception {
		if (user == null)
			throw new Exception("sem usuario");
		if (user.getNome() != null && user.getEmail() != null)
			userRepository.save(user);

	}

	public void setRepository(IUsuarioRepository repository) {
		this.userRepository = repository;
	}

	@Override
	public Usuario buscarPorID(Long id) {
		Usuario usuario = userRepository.getOne(id);
		return usuario;
	}

	@Override
	public Usuario buscarPorEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<String> gelAllPermissoes(Usuario usuario) {
		return ULrepository.getAllPermissoes(usuario, Calendar.getInstance());
	}

	
	@Override
	public Usuario getUserbyLogin(String login, String senha) {
		Login loginexistente = loginRepository.findByLoginAndSenha(login, senha);
		
		if(loginexistente == null) return null;
		
		return userRepository.getOne(loginexistente.getId());
	}
}
