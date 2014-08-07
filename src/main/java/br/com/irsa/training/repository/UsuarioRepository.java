package br.com.irsa.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.irsa.training.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNome(String nome);
	public Usuario findByEmail(String email);
}
