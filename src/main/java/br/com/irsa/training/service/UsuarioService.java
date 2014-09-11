package br.com.irsa.training.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Login;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.permissao.IBuscadorUserPermissao;
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
	
	@Autowired
	private List<IBuscadorUserPermissao> listBuscador;

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
	public Map<Object, Set<Permissao>> getPermissoes(Usuario usuario) {
		HashMap<Object,Set<Permissao>> map = new HashMap<Object, Set<Permissao>>();
		map.put(usuario, ULrepository.getAllPermissoes(usuario, Calendar.getInstance()));
		
		for(IBuscadorUserPermissao buscador : listBuscador){
			Map<Object, Set<Permissao>> permissoes = buscador.getPermissoes(usuario);
			for(Object obj : permissoes.keySet()){
				if(map.containsKey(obj))
					map.get(obj).addAll(permissoes.get(obj));
				else
					map.put(obj, permissoes.get(obj));
			}
			
		}
		
		return map;
	}

	
	@Override
	public Usuario getUserbyLogin(String login, String senha) {
		Login loginexistente = loginRepository.findByLoginAndSenha(login, senha);
		
		if(loginexistente == null) return null;
		Usuario usuario = userRepository.findOne(loginexistente.getId());
		String nome = usuario.getNome();
		return usuario;
	}
	
	public void setListBuscador(List<IBuscadorUserPermissao> listBuscador) {
		this.listBuscador = listBuscador;
	}
}
