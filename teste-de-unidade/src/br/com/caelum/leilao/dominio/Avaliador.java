package br.com.caelum.leilao.dominio;

public class Avaliador {
	
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	private double menorDeTodos = Double.POSITIVE_INFINITY;
	
	public void avalia(Leilao leiao) {
		for( Lance lance : leiao.getLances() ) {
			if( lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
			else if(lance.getValor() < menorDeTodos   ) menorDeTodos = lance.getValor();
		}
	}

	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
	public double getMenorLance() {
		return menorDeTodos;
	}
	
}
