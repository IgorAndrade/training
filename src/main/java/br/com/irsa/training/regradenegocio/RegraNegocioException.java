package br.com.irsa.training.regradenegocio;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;

public class RegraNegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	private RegrasNegocio regra;
	private static final String prefixo ="erro.regranegocio.";
	@Autowired
	private MessageSource msg;
	private String[] param;
	
	public RegraNegocioException(String msg) {
		super(msg);
	}
	
	public RegraNegocioException(RegrasNegocio regra) {
		
		this.regra = regra;
	}
	
	public RegraNegocioException(RegrasNegocio regra, String[] param) {
		this.param = param;
		this.regra = regra;
	}
	
	public RegraNegocioException(RegrasNegocio regra, List<String> param) {
		this.param = param.toArray(new String[param.size()]);
		this.regra = regra;
	}
	
	@Override
	public String getMessage() {
		return msg.getMessage(prefixo+regra.name(), param, null);
	}

}
