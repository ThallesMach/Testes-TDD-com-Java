package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		
//		==== Parte 1: Cenário =======
		Usuario joao = new Usuario("Joao");
		Usuario davi = new Usuario("Davi");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Playstation 4 ");
		
		leilao.propoe(new Lance(joao, 250.0) );
		leilao.propoe(new Lance(davi, 300.0) );
		leilao.propoe(new Lance(maria, 400.0) );
		
//		=== Parte 2: Ação =====
		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);
		
//		=== Parte 3: Valiação =====
		double maiorEsperando = 400;
		double menorEsperando = 250;
		
//		System.out.println( maiorEsperando == leiloeiro.getMaiorLance() );
		Assert.assertEquals(maiorEsperando, leiloeiro.getMaiorLance(), 0.00001 ); // 0.00001 é Delta para aceita um aredontamento.
		
//		System.out.println( menorEsperando == leiloeiro.getMenorLance() );
		Assert.assertEquals(menorEsperando, leiloeiro.getMenorLance(), 0.00001 );
		
	}

}
