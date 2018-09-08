package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class AvaliadorTest {
	

	private Avaliador   leiloeiro;
	private Usuario joao;
	private Usuario jose;
	private Usuario maria;

	/**Para JUnit Excut this method uma vez antes de Cada method de Test **/
	@Before
	public void criaAvaliador() {
	 	this.leiloeiro = new Avaliador();
//	 	System.out.println("Cria Avaliador");
	 	this.joao = new Usuario("Joao");
        this.jose = new Usuario("José");
        this.maria = new Usuario("Maria");
	}
	
	   @Test
	    public void deveEntenderLancesEmOrdemCrescente() {
		   
	        // Parte 1 Cenário: 3 lances em ordem crescente
//	        Usuario joao = new Usuario("Joao");
//	        Usuario jose = new Usuario("José");
//	        Usuario maria = new Usuario("Maria");

	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(maria,250.0));
	        leilao.propoe(new Lance(joao,300.0));
	        leilao.propoe(new Lance(jose,400.0));

//	        ==>> Parte 2 Ação: executando a acao
	       /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
	        leiloeiro.avalia(leilao);

//	        ==>> Parte 3 Validação: comparando a saida com o esperado
	        double maiorEsperado = 400;
	        double menorEsperado = 250;

	        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
	        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
	    }

	   
	   @Test
	    public void deveEntenderLeilaoComApenasUmLance() {
		   
		  
		   Leilao leilao = new Leilao("Playstation 4 ");
		   
		   leilao.propoe(new Lance(joao, 2000.0) );
		   
		   /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
		   leiloeiro.avalia(leilao);
		   
		   assertEquals( 2000.0, leiloeiro.getMaiorLance(), 0.00001 );
		   assertEquals( 2000.0, leiloeiro.getMenorLance(), 0.00001 );
		   
		   
	   }
	   
	   @Test
	   public void deveEncontraOsTresMaioresLances() {
		   
		   Leilao leilao = new Leilao("Playstation 4 ");
		   
		   leilao.propoe(new Lance(joao, 100.0) );
		   leilao.propoe(new Lance(maria, 200.0) );
		   leilao.propoe(new Lance(joao, 300.0) );
		   leilao.propoe(new Lance(maria, 400.0) );
		   
		   /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
		   leiloeiro.avalia(leilao);
		   
		   List<Lance> maiores = leiloeiro.getTresMaiores();
		   assertEquals(3, maiores.size() );
		   assertEquals(400.0, maiores.get(0).getValor(), 0.00001 );
		   assertEquals(300.0, maiores.get(1).getValor(), 0.00001 );
		   assertEquals(200.0, maiores.get(2).getValor(), 0.00001 );
		   
	   }
	   
	   
//	   =========== Lance com Arredondamento  ==========================
	    @Test
	    public void deveEntenderLeilaoComLancesEmOrdemRandomica() {
	         
	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao,200.0));
	        leilao.propoe(new Lance(maria,450.0));
	        leilao.propoe(new Lance(joao,120.0));
	        leilao.propoe(new Lance(maria,700.0));
	        leilao.propoe(new Lance(joao,630.0));
	        leilao.propoe(new Lance(maria,230.0));

	        /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
	        leiloeiro.avalia(leilao);

	        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
	        assertEquals(120.0, leiloeiro.getMenorLance(), 0.0001);
	    }
	    
	    
//	    ============= Lance com Valor Decrescente ======================
	    @Test
	    public void deveEntenderLeilaoComLancesEmOrdemDecrescente() {
	        
	    	Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao,400.0));
	        leilao.propoe(new Lance(maria,300.0));
	        leilao.propoe(new Lance(joao,200.0));
	        leilao.propoe(new Lance(maria,100.0));

	        /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
	        leiloeiro.avalia(leilao);

	        assertEquals(400.0, leiloeiro.getMaiorLance(), 0.0001);
	        assertEquals(100.0, leiloeiro.getMenorLance(), 0.0001);
	    }
	    
	    
//-----------------------------------------------------------------------------------------------
	    
	    @Test
	    public void deveEncontrarOsTresMaioresLances() {
	        
	    	Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 100.0));
	        leilao.propoe(new Lance(maria, 200.0));
	        leilao.propoe(new Lance(joao, 300.0));
	        leilao.propoe(new Lance(maria, 400.0));

	        /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
	        leiloeiro.avalia(leilao);

	        List<Lance> maiores = leiloeiro.getTresMaiores();

	        assertEquals(3, maiores.size());
	        assertEquals(400, maiores.get(0).getValor(), 0.00001);
	        assertEquals(300, maiores.get(1).getValor(), 0.00001);
	        assertEquals(200, maiores.get(2).getValor(), 0.00001);
	    }

	    @Test
	    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
	        
	    	Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 100.0));
	        leilao.propoe(new Lance(maria, 200.0));

	        /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
	        leiloeiro.avalia(leilao);

	        List<Lance> maiores = leiloeiro.getTresMaiores();

	        assertEquals(2, maiores.size());
	        assertEquals(200, maiores.get(0).getValor(), 0.00001);
	        assertEquals(100, maiores.get(1).getValor(), 0.00001);
	    }

	    @Test
	    public void deveDevolverListaVaziaCasoNaoHajaLances() {
	        
	    	Leilao leilao = new Leilao("Playstation 3 Novo");

	        /* Tem @Before no começo do códego
	        criaAvaliador();	//	Avaliador leiloeiro = new Avaliador();		*/
	        leiloeiro.avalia(leilao);

	        List<Lance> maiores = leiloeiro.getTresMaiores();

	        assertEquals(0, maiores.size());
	    }

}
