
package br.com.caelum.leilao.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTestLancesEmOrdemCrescente  {
	
	   @Test
	    public void deveEntenderLancesEmOrdemCrescente() {
		   
	        // Parte 1 Cenário: 3 lances em ordem crescente
	        Usuario joao = new Usuario("Joao");
	        Usuario jose = new Usuario("José");
	        Usuario maria = new Usuario("Maria");

	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(maria,250.0));
	        leilao.propoe(new Lance(joao,300.0));
	        leilao.propoe(new Lance(jose,400.0));

//	        ==>> Parte 2 Ação: executando a acao
	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);

//	        ==>> Parte 3 Validação: comparando a saida com o esperado
	        double maiorEsperado = 400;
	        double menorEsperado = 250;

	        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
	        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	    }

}

