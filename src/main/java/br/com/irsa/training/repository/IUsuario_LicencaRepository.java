package br.com.irsa.training.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Permissoes;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licenca;

public interface IUsuario_LicencaRepository extends JpaRepository<Usuario_Licenca, Long> {

	List<Usuario_Licenca> findByUsuario(Usuario usuario);
	List<Usuario_Licenca> findByLicenca(Licenca licenca);
	List<Usuario_Licenca> findByUsuarioAndLicencaAndDtFimAfterOrderByDtFimDesc(Usuario usuario,Licenca licenca,Calendar today);
	@Query("select ul.usuario from Usuario_Licenca ul where ul.licenca = :licenca")
	List<Usuario> findUsuariosLicensiados(@Param("licenca") Licenca licenca);
	@Query("select ul.licenca from Usuario_Licenca ul join ul.licenca l join l.permissoes p where ul.usuario = :usuario")
	List<Licenca> findLicencasDoUsuario(@Param("usuario") Usuario usuario);
	@Query("select DISTINCT p from Usuario_Licenca  ul join ul.licenca l join l.permissoes p where ul.usuario = :usuario and ul.dtFim >= :data ")
	List getAllPermissoes(@Param("usuario") Usuario usuario,@Param("data") Calendar data);

	
}
