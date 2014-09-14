package br.com.irsa.training.test.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.model.Usuario;
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

	@Test
	public void testSalvarSemPreencherNome() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setEmail("teste");
		service.setRepository(repositoryMock);
		service.salvar(usuario);
		verify(repositoryMock, times(0)).save(usuario);
	}
	
	@Test
	public void testSalvarSemPreencherEmail() throws Exception {

		Usuario usuario = new Usuario();
		usuario.setNome("Igor");
		service.setRepository(repositoryMock);
		service.salvar(usuario);
		verify(repositoryMock, times(0)).save(usuario);
	}
	
	@Test
	public void testSalvarRepetido()throws Exception{
		
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
	public void testLisatPermissoes(){
		
	}

}