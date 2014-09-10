package br.com.irsa.training.test.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licenca;
import br.com.irsa.training.repository.ILicencaRepository;
import br.com.irsa.training.repository.IUsuarioRepository;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;
import br.com.irsa.training.test.factory.CriaUsuarioLicenca;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)

public class IUsuario_LicencaRepositoryTest {

	@Autowired
	IUsuario_LicencaRepository ULRepository;
	@Autowired
	IUsuarioRepository userRepository;
	@Autowired
	ILicencaRepository licencaRepository;
	
	@Test @Transactional
	public void buscaLicencaDoUsuarioTest() {
		
		Usuario usuario = CriaUsuarioLicenca.criaUsuario();
		Licenca licenca = CriaUsuarioLicenca.criaLicencaComDuracao(5, 1, 0);
		Usuario_Licenca ul = CriaUsuarioLicenca.gerar(usuario, licenca);
		userRepository.save(usuario);
		licencaRepository.save(licenca);
		
		ul.setDtInicio(Calendar.getInstance());
		ul.setDtFim(Calendar.getInstance());
		
		Usuario_Licenca saved = ULRepository.save(ul);
		assertNotNull(saved.getId());
		
		List<Licenca> findLicencasDoUsuario = ULRepository.findLicencasDoUsuario(usuario);
		
		assertTrue("Não recuperou a licenca salva",findLicencasDoUsuario.contains(saved.getLicenca()));
		
	}
	@Test
	public void buscaLicencasAtivasUsuario(){
		Usuario usuario = userRepository.findOne(new Long(2));
		Licenca licenca = licencaRepository.findOne(new Long(2));
		
		List<Usuario_Licenca> list = ULRepository.findByUsuarioAndLicencaAndDtFimAfterOrderByDtFimDesc(usuario, licenca, Calendar.getInstance());
		
		assertThat(list.size(), is(2));
		
	}

	@Test 
	public  void testListarPermissoes(){
		Usuario usuario = userRepository.getOne(Long.valueOf(2));
		Set<Permissao> permissoes = ULRepository.getAllPermissoes(usuario, Calendar.getInstance());
		
		assertThat("Lista diferente da esperada", permissoes, containsInAnyOrder(Permissao.CRIAR_SERIE,Permissao.CRIAR_TREINAMENTO));
	}
}
