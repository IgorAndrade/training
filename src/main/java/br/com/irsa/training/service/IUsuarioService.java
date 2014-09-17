package br.com.irsa.training.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuarioRepository;

public interface IUsuarioService {

	public void salvar(Usuario user) throws Exception;
	public void setRepository(IUsuarioRepository repository);
	public Usuario buscarPorID(Long id);
	public  Usuario buscarPorEmail(String email);
	public Map<Object, Set<Permissao>> getPermissoes(Usuario usuario);
	public Usuario getUserbyLogin(String login, String senha);
	public void apagarUsuario(Usuario usuario);
	public void apagarUsuario(Long id);
}
