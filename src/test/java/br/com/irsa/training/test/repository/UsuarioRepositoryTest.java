package br.com.irsa.training.test.repository;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import br.com.irsa.training.enums.StatusUser;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuarioRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring/application-config.xml"})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UsuarioRepositoryTest {

	@Autowired
	IUsuarioRepository repository;
	
	@Before
	public void dependencyInjectionTest(){
		assertNotNull(repository);
	}
	
	@Test
	//@Rollback(true)
	public void testFindByNome() {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor");
		usuario.setEmail("teste@teste.com5");
		usuario.setStatus(StatusUser.ATIVO);
		repository.save(usuario);
		Usuario user2 = repository.findByNome("Igor");
		assertNotNull("Não achou o usuario", user2);
		assertThat(usuario.getNome(), is(equalTo(user2.getNome())));
	}

	@Test 	@Rollback(true) @Ignore
	public void testFindByEmail() {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor2");
		usuario.setEmail("teste2@teste.com");
		repository.save(usuario);
		Usuario user2 = repository.findByEmail("teste2@teste.com");
		assertNotNull("Não achou o usuario", user2);
		assertThat(usuario.getEmail(), is(equalTo(user2.getEmail())));
	}

	@Test	@Rollback(true) @Ignore
	public void testFindAll() {
		Usuario usuario = new Usuario();
		usuario.setNome("Igor2");
		usuario.setEmail("teste2@teste.com");
		Usuario usuario2 = new Usuario();
		usuario2.setNome("Igor");
		usuario2.setEmail("teste@teste.com");
		repository.save(usuario);
		repository.save(usuario2);
		assertTrue(repository.findAll().size()>1);
		
	}

	

}
