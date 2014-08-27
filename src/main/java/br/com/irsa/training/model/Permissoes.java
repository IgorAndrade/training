package br.com.irsa.training.model;

import javax.persistence.Entity;
import javax.persistence.Id;

public enum Permissoes {
	CRIAR_TREINAMENTO,CRIAR_SERIE,USER;

	public String getNome(){
		return this.name();
	}
	
	
	@Override
	public String toString() {
		return this.name();
	}
	
	
}
