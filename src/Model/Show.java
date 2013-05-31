package model;

import model.DVD.Categoria;

public class Show extends DVD {

	private String artista;
		
	public Show() {
	}

	public Show(String titulo, String codigo, String area, String genero, String artista,
			String anoLancamento, Categoria categoria, int copias) {
		super(titulo, codigo, area, genero, anoLancamento, categoria, copias);
		this.artista = artista;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
}
