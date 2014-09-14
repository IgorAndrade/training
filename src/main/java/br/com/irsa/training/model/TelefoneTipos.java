package br.com.irsa.training.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TelefoneTipos {
	Casa,Celular,Principal,Trabalho,Outros;
	
	@JsonValue
	public String getValue(){
		return name();
	}
	
	@JsonCreator
	public static TelefoneTipos create(String tipo) {

		return valueOf(tipo);
	}
}
