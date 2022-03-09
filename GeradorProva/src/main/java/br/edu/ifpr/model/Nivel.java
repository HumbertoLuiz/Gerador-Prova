package br.edu.ifpr.model;

public enum Nivel {

	FACIL("Facil"),
	INTERMEDIARiO("Intermediario"),
	DIFICIL("Dificil");
	
	private String nome;
	private String valor;

	private Nivel(String nome) {
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


