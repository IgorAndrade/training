package br.com.irsa.training.permissao;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Usuario;

@Component
public class BuscadorPermissaoProfessor implements IBuscadorUserPermissao {

	@Override
	public Map<Object, Set<Permissao>> getPermissoes(Usuario usuario) {
		HashMap<Object,Set<Permissao>> map = new HashMap<Object, Set<Permissao>>();
		return map;
	}

}
