package br.com.irsa.training.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licenca;

public interface IUsuario_LicencaRepository extends JpaRepository<Usuario_Licenca, Long> {

	List<Usuario_Licenca> findByUsuario(Usuario usuario);
	List<Usuario_Licenca> findByLicenca(Licenca licenca);
	List<Usuario_Licenca> findByUsuarioAndLicencaAndDtFimAfterOrderByDtFimDesc(Usuario usuario,Licenca licenca,Date today);
	@Query("select ul.licenca from Usuario_Licenca ul where ul.usuario = :usuario")
	List<Licenca> findUsuariosLicensiados(Licenca licenca);
	@Query("select ul.usuario from Usuario_Licenca ul where ul.licenca = :licenca")
	List<Usuario> findLicencasDoUsuario(Usuario usuario);
	
}
