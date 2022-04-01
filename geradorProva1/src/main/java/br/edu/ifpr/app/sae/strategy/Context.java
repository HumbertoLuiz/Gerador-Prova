package br.edu.ifpr.app.sae.strategy;

public class Context {

	private ProvaStrategy strategy;

	public void setStrategy(ProvaStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void executarSalvar() {
		this.strategy.redirect();
	}
}
