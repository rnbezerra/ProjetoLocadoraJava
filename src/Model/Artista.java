package Model;

import java.util.ArrayList;
import java.util.Date;

public class Artista extends Personalidade {

	private String nomeCompleto;
	private Date dataNasc;
	
	public Artista() {
		super();
	}
	
	public Artista(String codigo, String nome, String nomeCompleto, Sexo sexo, Date dataNasc,
			ArrayList<String> filmes) {
		super(codigo, nome, sexo, filmes);
		this.nomeCompleto = nomeCompleto;
		this.dataNasc = dataNasc;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public ArrayList<String> getFilmes() {
		return super.filmes;
	}
	
	public void setFilmes(ArrayList<String> filmes) {
		super.filmes = filmes;
	}
	
	public void addFilme(String codigo) {
		super.filmes.add(codigo);
	}
	
		
}
