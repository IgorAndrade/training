package br.com.irsa.training.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.irsa.training.model.Licenca;
import br.com.irsa.training.model.Usuario;
import br.com.irsa.training.model.Usuario_Licenca;
import br.com.irsa.training.regradenegocio.GeradorExcecoes;
import br.com.irsa.training.regradenegocio.RegraNegocioException;
import br.com.irsa.training.regradenegocio.RegrasNegocio;
import br.com.irsa.training.repository.IUsuario_LicencaRepository;
@Service
public class LicenciarService implements ILicenciarService {
	@Autowired
	GeradorExcecoes excecoes ; 
	@Autowired
	private IUsuario_LicencaRepository repository;
	
	@Override 
	public void licenciarUsuario(Usuario usuario, Licenca licenca) throws RegraNegocioException {

		if(!licenca.getAtivo()){
			throw excecoes.getRNException(RegrasNegocio.LicencaInativa, new String[]{licenca.getNome()});
		}
		
		Usuario_Licenca ul = new Usuario_Licenca(usuario, licenca);
		
		ul.setDtInicio(buscarDataFinalLicenca(usuario,licenca));
		Calendar dtfim = (Calendar) ul.getDtInicio().clone();
		
		dtfim.add(Calendar.DAY_OF_MONTH, licenca.getDuracao().getDias());
		dtfim.add(Calendar.YEAR, licenca.getDuracao().getAnos());
		dtfim.add(Calendar.MONTH, licenca.getDuracao().getMes());
		
		ul.setDtFim(dtfim);
		
		repository.save(ul);
	}
	
	public Calendar buscarDataFinalLicenca(Usuario usuario, Licenca licenca){
		List<Usuario_Licenca> list = repository.findByUsuarioAndLicencaAndDtFimAfterOrderByDtFimDesc(usuario, licenca, Calendar.getInstance().getTime());
		if(list == null || list.size()==0)
			return Calendar.getInstance();
		else{
			return (Calendar) list.get(0).getDtFim().clone();
			
		}
	}
	
	@Override
	public void setRepository(IUsuario_LicencaRepository repository) {
		this.repository = repository;
	}

}
