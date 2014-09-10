package br.com.irsa.training.test.factory;

import br.com.irsa.training.enums.StatusUser;
import br.com.irsa.training.model.Duracao;
import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licenca;

public class CriaUsuarioLicenca {
	private Usuario_Licenca ul;

	public CriaUsuarioLicenca() {
		// TODO Auto-generated constructor stub
	}

	public static Usuario criaUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("teste2");
		usuario.setEmail("teste2@teste.com");
		usuario.setStatus(StatusUser.ATIVO);
		return usuario;
	}

	public static Licenca criaLicenca() {
		Licenca licenca = new Licenca();
		licenca.setAtivo(true);
		return licenca;
	}

	public static Licenca criaLicencaComDuracao(int dia, int mes, int ano) {
		Licenca licenca = criaLicenca();
		licenca.setAtivo(true);
		licenca.setDuracao(new Duracao(dia, mes, ano));
		return licenca;
	}

	public static Usuario_Licenca gerar(Usuario usuario, Licenca licenca) {
		return new Usuario_Licenca(usuario, licenca);
	}
	public static Usuario_Licenca gerar() {
		return new Usuario_Licenca(criaUsuario(), criaLicenca());
	}
}
