package br.com.irsa.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.irsa.training.model.Licensa;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licensa;

public interface IUsuario_LicensaRepository extends JpaRepository<Usuario_Licensa, Long> {

	List<Usuario_Licensa> findByUsuario(Usuario usuario);
	List<Usuario_Licensa> findByLicensa(Licensa licensa);
	@Query("select ul.licensa from Usuario_Licensa ul where ul.usuario = :usuario")
	List<Licensa> findUsuariosLicensiados(Licensa licensa);
	@Query("select ul.usuario from Usuario_Licensa ul where ul.licensa = :licensa")
	List<Usuario> findLicensasDoUsuario(Usuario usuario);
	
}
