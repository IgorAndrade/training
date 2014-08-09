package br.com.irsa.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.irsa.training.model.Licensa;
import br.com.irsa.training.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNome(String nome);
	public Usuario findByEmail(String email);
	
	@Query("select ul.licensa from Usuario_Licensa ul where ul.usuario = :usuario")
	public List<Licensa> licensas(Usuario usuario);
}
