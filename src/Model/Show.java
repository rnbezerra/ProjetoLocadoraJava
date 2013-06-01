package model;

public class Show extends DVD {

	private String artista;
	private String faixas;
		
	public Show() {
		super.tipo = TipoDVD.Show;
	}

	public Show(String titulo, String codigo, String area, String genero,
			String anoLancamento, CategoriaDVD categoria, int copias, String artista, String faixas) {
		super(titulo, codigo, area, genero, anoLancamento, categoria, copias);
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
