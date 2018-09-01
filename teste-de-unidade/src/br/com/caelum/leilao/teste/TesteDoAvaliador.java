package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {
	
	public static void main(String[] args) {
		
		Usuario joao = new Usuario("Joao");
		Usuario davi = new Usuario("Davi");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 4 ");
		
		leilao.propoe(new Lance(joao, 300.0) );
		leilao.propoe(new Lance(davi, 400.0) );
		leilao.propoe(new Lance(maria, 250.0) );
		
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
		System.out.println(leiloeiro.getMaiorLance() );
		System.out.println(leiloeiro.getMenorLance() );
		
		
	}

}
