package br.com.irsa.training.test.regradenegocio;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import br.com.irsa.training.regradenegocio.GeradorExcecoes;
import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.regradenegocio.RegrasNegocio;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring/application-config.xml" })
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
public class RegraNegocioExceptionTest {
	@Autowired
	private GeradorExcecoes rn;

	@Test
	public void testRNSemParametro() {
		try {
			
			throw rn.getRNException(RegrasNegocio.CadastroRepetido);
		} catch (RegraNegocioException rnE) {
			assertEquals("Cadastro Repetido!", rnE.getMessage());
		}
	}

	@Test
	public void testRNComParametro() {
		try {
			throw rn.getRNException(RegrasNegocio.UsuarioRepetido, new String[]{"Igor"});
		} catch (RegraNegocioException rnE) {
			assertEquals("Usuário Igor já existe!", rnE.getMessage());
		}
	}

}
