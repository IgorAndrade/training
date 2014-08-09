package br.com.irsa.training.test.regradenegocio;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.regradenegocio.RegrasNegocio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-config.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class RegraNegocioExceptionTest {
	@Autowired
	private RegraNegocioException rn;

	@Test
	public void testRNSemParametro() {
		try {
			rn.setRegra(RegrasNegocio.CadastroRepetido);
			throw rn;
		} catch (RegraNegocioException rnE) {
			assertEquals("Cadastro Repetido!", rnE.getMessage());
		}
	}

	@Test
	public void testRNComParametro() {
		try {
			String[] msg = { "Igor" };
			rn.setRegra(RegrasNegocio.UsuarioRepetido);
			rn.setParam(msg);
			throw rn;
		} catch (RegraNegocioException rnE) {
			assertEquals("Usuário Igor já existe!", rnE.getMessage());
		}
	}

}
