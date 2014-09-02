package br.com.irsa.training.enums;

import javax.persistence.Entity;
import javax.persistence.Id;

public enum Permissao {
	CRIAR_TREINAMENTO,CRIAR_SERIE,USER;

	public String getNome(){
		return this.name();
	}
	
	
	@Override
	public String toString() {
		return this.name();
	}
	
	
}
