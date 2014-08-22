package br.com.irsa.training.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuarioRepository;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;

@Service
@Transactional
public class UsuarioService implements IUsuarioService {

	@Autowired
	private IUsuarioRepository repository;
	@Autowired
	private IUsuario_LicencaRepository ULrepository;
	
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
	
	@Override
	public Usuario buscarPorEmail(String email){
		return repository.findByEmail(email);
	}
@Override
public List<String> gelAllPermissoes(Usuario usuario) {
	return ULrepository.getAllPermissoes(usuario,Calendar.getInstance());
}
}
