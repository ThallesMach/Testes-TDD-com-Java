package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		int total = qtdDeLancesDo(lance.getUsuario() );
		
		// So podemos add o lances.isEmpty() === Lista Lance for Vazia
		// ou == || se ultima lance dado Não for pelo mesmo Usuario pelo Lance Atual
		if(lances.isEmpty() || podeDarLance(lance.getUsuario() ) ) {
			lances.add(lance);
		}
	}

	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario ) && qtdDeLancesDo(usuario) <5;
	}

	private int qtdDeLancesDo(Usuario usuario) {
		int total = 0;
		for(Lance l : lances) {
			if(l.getUsuario().equals(usuario ) ) total++; 
		}
		return total;
	}
	
	/*---->>> Para fazer o teste passar, implementamos-------------------------*/
//    public void dobraLance(Usuario usuario) {
//        Lance ultimo = null;
//        for(Lance lance : lances) {
//            if(lance.getUsuario().equals(usuario)) ultimo = lance;
//        }
//
//        propoe(new Lance(usuario, ultimo.getValor()*2));
//    }

    
	/**-----Com o teste passando, refatoramos o código-----**/
//    public void dobraLance(Usuario usuario) {
//        Lance ultimoLance = ultimoLanceDo(usuario);
//            propoe(new Lance(usuario, ultimoLance.getValor()*2));
//    }

    private Lance ultimoLanceDo(Usuario usuario) {
        Lance ultimo = null;
        for(Lance lance : lances) {
            if(lance.getUsuario().equals(usuario)) ultimo = lance;
        }

        return ultimo;
    }
    
    /**---Para fazê-lo passar alteramos o método dobraLance() -----**/
    public void dobraLance(Usuario usuario) {
        Lance ultimoLance = ultimoLanceDo(usuario);
        if(ultimoLance!=null) {
            propoe(new Lance(usuario, ultimoLance.getValor()*2));
        }
    }
    
    
	private Lance ultimoLanceDado() {
		return lances.get(lances.size()-1);
	}
    
    

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}
