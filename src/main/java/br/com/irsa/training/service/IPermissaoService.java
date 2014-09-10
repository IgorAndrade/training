package br.com.irsa.training.service;

import java.util.Map;
import java.util.Set;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Academia;
import br.com.irsa.training.model.PersonalProfile;
import br.com.irsa.training.model.Usuario;

public interface IPermissaoService {

	public Map<Object,Set<Permissao>> getPermissoes(Usuario usuario);
	public Set<Permissao> getPermissoes(Academia academia);
	public Set<Permissao> getPermissoes(PersonalProfile personal);
}
