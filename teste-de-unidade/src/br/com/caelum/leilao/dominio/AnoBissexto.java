package br.com.caelum.leilao.dominio;

public class AnoBissexto {
	
	/**Link Explicativo  anos bissextos na Wikipédia.
	 * https://pt.wikipedia.org/wiki/Ano_bissexto
	 * **/
	
	public boolean isAnoBissexto(int ano) {
	    if (((ano % 4) == 0) && ((ano % 100) != 0)) return true; 
	        else if ((ano % 400) == 0) return true; 
	        else return false;                
	}

	public Object getAnoBissexto(int i) {
		return isAnoBissexto(i) ;
	}

}
