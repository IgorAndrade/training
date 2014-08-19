package br.com.irsa.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuarioRepository;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repository;
	
	@Override
	public void salvar(Usuario user) throws Exception {
		if(user == null)
			throw new Exception("sem usuario");
		if(user.getNome() != null && user.getEmail() != null)
			repository.save(user);
		
	}
	
	
	public void setRepository(IUsuarioRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Usuario buscarPorID(Long id) {
		Usuario usuario = repository.getOne(id);
		return usuario;
	}

}
