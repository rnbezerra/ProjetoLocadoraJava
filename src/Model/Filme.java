package Model;

import java.util.ArrayList;

public class Filme extends DVD {

	private String direcao;
	private ArrayList<String> elenco;
	
	public Filme() {
		this.elenco = new ArrayList<String>();
	}

	public Filme(String titulo, String codigo, String area, String genero, String direcao,
			ArrayList<String> elenco,
			String anoLancamento, int copias) {
		super(titulo, codigo, area, genero, anoLancamento, copias);
		this.direcao = direcao;
		this.elenco = elenco;
	}

	public String getDirecao() {
		return direcao;
	}

	public void setDirecao(String direcao) {
		this.direcao = direcao;
	}

	public ArrayList<String> getElenco() {
		return elenco;
	}

	public void setElenco(ArrayList<String> elenco) {
		this.elenco = elenco;
	}
	
	
	
	
}
