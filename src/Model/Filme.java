package model;

import java.util.ArrayList;

public class Filme extends DVD {

	private String direcao;
	private ArrayList<String> elenco;
	private String sinopse;
	
	public Filme() {
		super.tipo = TipoDVD.Filme;
		this.elenco = new ArrayList<String>();
	}
		
	public Filme(String titulo, String codigo, String area, String genero,
			String anoLancamento, CategoriaDVD categoria,
			int copias, String direcao, ArrayList<String> elenco, String sinopse) {
		super(titulo, codigo, area, genero, anoLancamento, categoria,
				copias);
		this.direcao = direcao;
		this.elenco = elenco;
		this.sinopse = sinopse;
		super.tipo = TipoDVD.Filme;
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

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	
	
	
}
