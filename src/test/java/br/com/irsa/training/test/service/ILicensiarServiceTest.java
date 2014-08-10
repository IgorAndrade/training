package br.com.irsa.training.test.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licenca;
import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;
import br.com.irsa.training.service.ILicenciarService;
import br.com.irsa.training.test.factory.CriaUsuarioLicenca;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-config.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class ILicensiarServiceTest {

	@Autowired
	private ILicenciarService service;
	private IUsuario_LicencaRepository repositoryMock;

	@Before
	public void init() {
		repositoryMock = mock(IUsuario_LicencaRepository.class);
	}
	
	@Test
	public void Criar1Licencatest() throws RegraNegocioException {
		// cria resultado esperado
		Calendar dtInicio = Calendar.getInstance();
		 
		Calendar dtFim = Calendar.getInstance();
		dtFim.add(Calendar.DAY_OF_MONTH, 5);
		dtFim.add(Calendar.MONTH, 1);
 
		// cria cenario
		Usuario usuario = CriaUsuarioLicenca.criaUsuario();
		Licenca licenca = CriaUsuarioLicenca.criaLicencaComDuracao(5, 1, 0);

		// cria mock
		when(
				repositoryMock
						.findByUsuarioAndLicencaAndDtFimAfterOrderByDtFimDesc(
								any(Usuario.class), any(Licenca.class),
								any(Calendar.class))).thenReturn(null);
		ArgumentCaptor<Usuario_Licenca> ulCaptor = ArgumentCaptor
				.forClass(Usuario_Licenca.class);

		service.setRepository(repositoryMock);
		service.licenciarUsuario(usuario, licenca);

		// validação
		verify(repositoryMock).save(ulCaptor.capture());

		// assertEquals(ulExpected.getDtFim().get(Calendar.MONTH), ulCaptor
		// .getValue().getDtFim().get(Calendar.MONTH));
		// assertEquals(ulExpected.getDtFim().get(Calendar.DAY_OF_MONTH),
		// ulCaptor
		// .getValue().getDtFim().get(Calendar.DAY_OF_MONTH));
		assertEquals("Teste data inicio:", removerTempo(dtInicio), removerTempo(ulCaptor.getValue()
				.getDtInicio()));
		assertEquals("Teste data fim:", removerTempo(dtFim), removerTempo(ulCaptor.getValue().getDtFim()));
	}

	@Test
	public void CriarLicencaAcumuladatest() throws RegraNegocioException {
		// cria resultado do mock
		Usuario_Licenca ulExpected = CriaUsuarioLicenca.gerar();
		ulExpected.setDtInicio(Calendar.getInstance());
		Calendar dtFim = Calendar.getInstance();
		dtFim.add(Calendar.DAY_OF_MONTH, 3);
		ulExpected.setDtFim(dtFim);
		List<Usuario_Licenca> listRetorno = Arrays
				.asList(new Usuario_Licenca[] { ulExpected });

		// cria cenario
		Usuario usuario = CriaUsuarioLicenca.criaUsuario();
		Licenca licenca = CriaUsuarioLicenca.criaLicencaComDuracao(5, 0, 0);

		// cria mock
		when(
				repositoryMock
						.findByUsuarioAndLicencaAndDtFimAfterOrderByDtFimDesc(
								any(Usuario.class), any(Licenca.class),
								any(Calendar.class))).thenReturn(listRetorno);

		ArgumentCaptor<Usuario_Licenca> ulCaptor = ArgumentCaptor
				.forClass(Usuario_Licenca.class);

		service.setRepository(repositoryMock);
		service.licenciarUsuario(usuario, licenca);

		// validação
		verify(repositoryMock).save(ulCaptor.capture());

		Calendar dtInicioExpected = Calendar.getInstance();
		dtInicioExpected.add(Calendar.DAY_OF_MONTH, 3);

		Calendar dtFimExpected = Calendar.getInstance();
		dtFimExpected.add(Calendar.DAY_OF_MONTH, 3 + 5);

		 assertEquals("Teste data inicio:",removerTempo(dtInicioExpected),removerTempo(ulCaptor.getValue().getDtInicio()));
		 assertEquals("Teste data fim:",removerTempo(dtFimExpected),removerTempo(ulCaptor.getValue().getDtFim()));

	}
	
	@Test(expected=RegraNegocioException.class)
	public void licencaInatiaTest() throws RegraNegocioException{
		// cria cenario
				Usuario usuario = CriaUsuarioLicenca.criaUsuario();
				Licenca licenca = CriaUsuarioLicenca.criaLicencaComDuracao(5, 0, 0);
				licenca.setAtivo(false);
				
				service.licenciarUsuario(usuario, licenca);
				fail("Exceção não lançada");
	}
	
	private Calendar removerTempo(Calendar data){
		data.clear(Calendar.HOUR);
		data.clear(Calendar.MINUTE);
		data.clear(Calendar.SECOND);
		data.clear(Calendar.MILLISECOND);
		return data;
	}
}
