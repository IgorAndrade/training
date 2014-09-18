package br.com.irsa.training.test.service;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.irsa.training.enums.Permissao;
import br.com.irsa.training.model.Academia;
import br.com.irsa.training.model.Telefone;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.security.UsuarioLogado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-security.xml" })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class })
public class UsuarioLogadoTest {

	private static final String USER_LOGADO = "User logado";
	private static final String EMAIL_LOGADO = "email logado";
	HashMap<Object, Set<Permissao>> mapPermissoes;
	HashSet<Permissao> setUser;
	HashSet<Permissao> setAcademia;
	Academia academia;
	Usuario usuario;
	private UsuarioLogado logado;
	
	@Before
	public void init(){
		logado = new UsuarioLogado();
		usuario = new Usuario();
		usuario.setEmail(EMAIL_LOGADO);
		usuario.setNome(USER_LOGADO);
		logado.setUser(usuario);
		
		mapPermissoes = new HashMap<Object, Set<Permissao>>();
		
		setUser = new HashSet<Permissao>();
		setUser.add(Permissao.USER);
		setUser.add(Permissao.CRIAR_TREINAMENTO);
		mapPermissoes.put(usuario, setUser);
		
		academia = new Academia();
		setAcademia = new HashSet<Permissao>();
		setAcademia.add(Permissao.CRIAR_SERIE);
		setAcademia.add(Permissao.CRIAR_TREINAMENTO);
		mapPermissoes.put(academia, setAcademia);
		
		logado.setAllPermissoes(mapPermissoes);
	}
	
	@Test
	public void testGetAllPermissoes() {
		Map<Object, Set<Permissao>> allPermissoes = logado.getAllPermissoes();
		
		assertThat(allPermissoes,hasKey((Object) academia));
		assertThat(allPermissoes,hasKey((Object) usuario));
		
	}
	@Test
	public void testGetAllObjPermissoes() {
		Map<Object, Set<Permissao>> allPermissoes = logado.getAllPermissoes();
		
		Set<Permissao> set = allPermissoes.get(academia);
		assertThat(set, containsInAnyOrder(Permissao.CRIAR_TREINAMENTO,Permissao.CRIAR_SERIE));
		assertThat(set, not(hasItem(Permissao.USER)) );
	}

	@Test
	public void testHasAllPermissao() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasAnyPermissao() {
		fail("Not yet implemented");
	}

	@Test
	public void testLogOut() {
		fail("Not yet implemented");
	}

}
