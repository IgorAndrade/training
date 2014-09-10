package br.com.irsa.training.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Academia;
import br.com.irsa.training.model.PersonalProfile;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;

@Service
public class PermissaoService implements IPermissaoService {

	@Autowired
	private IUsuario_LicencaRepository ulRepository;
	
	@Override
	public Map<Object, Set<Permissao>> getPermissoes(Usuario usuario) {
		HashMap<Object,Set<Permissao>> map = new HashMap<Object, Set<Permissao>>();
		Set permissoes = ulRepository.getAllPermissoes(usuario, Calendar.getInstance());
		map.put(usuario, permissoes);
		
		return map;
	}

	@Override
	public Set<Permissao> getPermissoes(Academia academia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Permissao> getPermissoes(PersonalProfile personal) {
		// TODO Auto-generated method stub
		return null;
	}

}
