package br.com.locadora.model;

import java.util.ArrayList;

public class HistoricoLocacaoCollection extends ArrayList<HistoricoLocacao> {
	
	public HistoricoLocacao getByCodigoDvdDataLocacao(String codigoDVD, String dataLocacoo) {
		for (HistoricoLocacao hl : this) {
			if(hl.getCodigoDVD().equals(codigoDVD) && hl.getDataLocacaoAsString().equals(dataLocacoo)){
				return hl;
			}
		}
		return null;
	}	
}
