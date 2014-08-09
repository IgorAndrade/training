package br.com.irsa.training.service;

import org.springframework.stereotype.Service;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;

@Service
public interface ILicenciarService {
	
	public void licenciarUsuario(Usuario usuario, Licenca licenca);

	public void setRepository(IUsuario_LicencaRepository repository);
}
