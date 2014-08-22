package br.com.irsa.training.service;

import org.springframework.stereotype.Service;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;

public interface ILicenciarService {
	
	public void licenciarUsuario(Usuario usuario, Licenca licenca) throws RegraNegocioException;

	public void setRepository(IUsuario_LicencaRepository repository);
}
