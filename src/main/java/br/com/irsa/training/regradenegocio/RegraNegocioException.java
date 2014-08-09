package br.com.irsa.training.regradenegocio;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

public class RegraNegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public RegraNegocioException() {
		super();
	}
	
	public RegraNegocioException(String msg) {
		super(msg);
	}
	
	
	
}
