package br.com.irsa.training.service;

import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuarioRepository;

public interface IUsuarioService {

	public void salvar(Usuario user) throws Exception;
	public void setRepository(IUsuarioRepository repository);
}
