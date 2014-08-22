package br.com.irsa.training.model;


public enum Permissoes {
	CRIAR_TREINAMENTO,CRIAR_SERIE;
	

	
	public String getNome(){
		return this.name();
	}
}
