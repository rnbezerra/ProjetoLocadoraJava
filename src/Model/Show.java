package model;

import model.DVD.CategoriaDVD;

public class Show extends DVD {

	private String artista;
	private String faixas;
		
	public Show() {
	}
		
	public Show(String artista, String faixas) {
		super();
		this.artista = artista;
		this.faixas = faixas;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getFaixas() {
		return faixas;
	}

	public void setFaixas(String faixas) {
		this.faixas = faixas;
	}
}
