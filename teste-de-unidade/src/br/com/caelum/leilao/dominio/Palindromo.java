package br.com.caelum.leilao.dominio;

public class Palindromo {
	
	 public boolean ehPalindromo(String frase) {

	        String fraseFiltrada = frase
	                .toUpperCase().replace(" ", "").replace("-", "");

	        for(int i = 0; i < fraseFiltrada.length(); i++) {
//	            if(fraseFiltrada.charAt(i) != 
//	                    fraseFiltrada.charAt(fraseFiltrada.length() -(i+1))) {
//	        ------------------------------------------------------------------------------	
	       /*** O bug está justamente na hora de pegar o caractere do fim da frase.
	        		Precisamos subtrair 1, afinal o array vai de 0 até tamanho da string -1. ***/
	            // bug corrigido na linha abaixo!
	            int outroLado = fraseFiltrada.length() -i - 1;
	            if(fraseFiltrada.charAt(i) != fraseFiltrada.charAt(outroLado)) {
//	        -------------------------------------------------------------------------------
	                return false;
	            }
	        }  

	        return true;
	    }

}
