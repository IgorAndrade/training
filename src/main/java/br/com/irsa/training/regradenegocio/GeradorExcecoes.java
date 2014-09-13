package br.com.irsa.training.regradenegocio;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class GeradorExcecoes implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String prefixoRN = "erro.regranegocio.";
	@Autowired
	private MessageSource msg;
	
	public GeradorExcecoes() {}
	

	public RegraNegocioException getRNException(RegrasNegocio regra, String[] param){
		return new RegraNegocioException(getMensagem(regra,param));
	}
	public RegraNegocioException getRNException(RegrasNegocio regra, String param){
		String[] params = {param};
		return new RegraNegocioException(getMensagem(regra,params));
	}
	public RegraNegocioException getRNException(RegrasNegocio regra){
		return new RegraNegocioException(getMensagem(regra,null));
	}
	
	private String getMensagem(RegrasNegocio regra, String[] param){
		return msg.getMessage(prefixoRN+regra.name(), param,null);
	}
	
}
