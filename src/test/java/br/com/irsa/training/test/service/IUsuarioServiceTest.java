package br.com.irsa.training.test.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.*;
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

import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.repository.IUsuarioRepository;
import br.com.irsa.training.service.IUsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-security.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class IUsuarioServiceTest {
	@Autowired
	private IUsuarioService service;
	private IUsuarioRepository repositoryMock;

	@Before
	public void init() {
		repositoryMock = mock(IUsuarioRepository.class);
	}

	@Test()
	public void testSalvarSemPreencherNome() throws Exception {
		try {
			Usuario usuario = new Usuario();
			usuario.setEmail("teste");
			service.setRepository(repositoryMock);
			service.salvar(usuario);
			verify(repositoryMock, times(0)).save(usuario);
		} catch (RegraNegocioException ern) {
			assertThat(ern.getMessage(), equalTo("Cadastro Inválido!"));
		}
	}

	@Test
	public void testSalvarSemPreencherEmail() throws Exception {
		try {
			Usuario usuario = new Usuario();
			usuario.setNome("Igor");
			service.setRepository(repositoryMock);
			service.salvar(usuario);
			verify(repositoryMock, times(0)).save(usuario);
			fail("Era para lançar exceção");
		} catch (RegraNegocioException ern) {
			assertThat(ern.getMessage(), equalTo("Cadastro Inválido!"));
		}
	}

	//@Test(expected = RegraNegocioException.class)
	@Test
	public void testSalvarEmailRepetidoMasUsuarioDiferente() throws Exception {
		final String email = "testSalvarEmailRepetido";
		try{
		service.setRepository(repositoryMock);
		Usuario usuario = new Usuario();
		usuario.setNome("testSalvarEmailRepetido");
		usuario.setEmail(email);
		when(repositoryMock.findByEmail(email)).thenReturn(
				usuario);

		Usuario usuario2 = new Usuario();
		usuario2.setNome("testSalvarEmailRepetido2");
		usuario2.setEmail("testSalvarEmailRepetido");
		service.salvar(usuario2);
		verify(repositoryMock, times(0)).save(usuario2);
		}catch(RegraNegocioException ern){
			assertThat(ern.getMessage(), equalTo("Usuário "+email+" já existe!"));
		}
	}

	@Test()
	public void testEditarUsuarioESalvar() throws Exception {
		List<Usuario> listarTodos = service.listarTodos();
		assertTrue("Lista vazia", !listarTodos.isEmpty());
		Usuario usuario = listarTodos.get(0);
		usuario.setNome("alterado");
		service.setRepository(repositoryMock);
		when(repositoryMock.findByEmail(usuario.getEmail()))
				.thenReturn(usuario);
		service.salvar(usuario);

		ArgumentCaptor<Usuario> captor = ArgumentCaptor.forClass(Usuario.class);

		verify(repositoryMock, times(1)).save(usuario);
		verify(repositoryMock).save(captor.capture());

		assertThat(usuario.getEmail(),
				is(equalTo(captor.getValue().getEmail())));

	}

	@Test
	public void testSalvar() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNome("Igor");
		usuario.setEmail("teste");
		service.setRepository(repositoryMock);
		service.salvar(usuario);
		verify(repositoryMock, times(1)).save(usuario);
	}

	@Test(expected = Exception.class)
	public void testUsuarioNull() throws Exception {
		service.salvar(null);
		fail("Não lancou excep");
	}

	@Test
	public void testLisatPermissoes() {

	}

}