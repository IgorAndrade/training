package br.com.irsa.training.permissao;

import java.util.Map;
import java.util.Set;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Usuario;

public interface IBuscadorUserPermissao {
	public Map<Object, Set<Permissao>> getPermissoes(Usuario usuario);
}
