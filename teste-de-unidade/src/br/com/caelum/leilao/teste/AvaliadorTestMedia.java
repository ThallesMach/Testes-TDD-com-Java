
package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.AvaliadorParaTest;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTestMedia {

	@Test
	public void deveCalcularAMedia() {

		// cenario: 3 lances em ordem crescente
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("José");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(maria, 300.0));
		leilao.propoe(new Lance(joao, 400.0));
		leilao.propoe(new Lance(jose, 500.0));

		// executando a acao
		AvaliadorParaTest leiloeiro = new AvaliadorParaTest();
		leiloeiro.avalia(leilao);

		// comparando a saida com o esperado
		Assert.assertEquals(400, leiloeiro.getMedia(), 0.0001);
	}


	@Test
	public void testaMediaDeZeroLance() {

		// Parte 1 do Teste Cenario
		Usuario ewertom = new Usuario("Ewertom");

		// Parte 2 do Teste Ação
		Leilao leilao = new Leilao("Iphone 7");

		AvaliadorParaTest avaliador = new AvaliadorParaTest();
		avaliador.avalia(leilao);

		// Parte 3 do Teste Validacao
		Assert.assertEquals(0, avaliador.getMedia(), 0.0001);

	}
}
