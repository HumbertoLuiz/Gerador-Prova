package br.edu.ifpr.app.sae.model;

public enum Tipo {
	
	OBJETIVA("Objetiva"),
	SUBJETIVA("Subjetiva"),
	MISTA("Mista");
	
	private String nome;
	private String valor;

	private Tipo(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return valor = this.name();
	}
}


