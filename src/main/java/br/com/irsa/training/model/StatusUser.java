package br.com.irsa.training.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusUser {
ATIVO,INATIVO,SUSPENSO;

@JsonValue
public String getValue(){
	return name();
}

@JsonCreator
public static StatusUser create(String status) {

	return valueOf(status);
}
}
