package model;

public class Show extends DVD {

	private String artista;
		
	public Show() {
	}

	public Show(String titulo, String codigo, String area, String genero, String artista,
			String anoLancamento, int copias) {
		super(titulo, codigo, area, genero, anoLancamento, copias);
		this.artista = artista;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
}
