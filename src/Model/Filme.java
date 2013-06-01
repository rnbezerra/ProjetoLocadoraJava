package model;

import java.util.ArrayList;

public class Filme extends DVD {

	private String direcao;
	private ArrayList<String> elenco;
	private String sinopse;
	
	public Filme() {
		this.elenco = new ArrayList<String>();
	}
	
	public Filme(String direcao, ArrayList<String> elenco, String sinopse) {
		super();
		this.direcao = direcao;
		this.elenco = new ArrayList<String>();
		this.elenco = elenco;
		this.sinopse = sinopse;
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
