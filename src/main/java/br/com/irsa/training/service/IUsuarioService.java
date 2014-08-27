package br.com.irsa.training.service;

import java.util.List;

import br.com.irsa.training.model.Permissoes;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuarioRepository;

public interface IUsuarioService {

	public void salvar(Usuario user) throws Exception;
	public void setRepository(IUsuarioRepository repository);
	public Usuario buscarPorID(Long id);
	public  Usuario buscarPorEmail(String email);
	public List<Permissoes> gelAllPermissoes(Usuario usuario);
	public Usuario getUserbyLogin(String login, String senha);
}
