package br.com.locadora.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Artista extends Personalidade {

	private String nomeCompleto;
	private Calendar dataNasc;
	
	public Artista() {
		super();
	}
	
	public Artista(String codigo, String nome, String nomeCompleto, Sexo sexo, Calendar dataNasc,
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


	public Calendar getDataNasc() {
		return dataNasc;
	}

	/**
	 * Este método retorna a data de nascimento em uma string
	 * @return String formatada em "dd/MM/yyyy"
	 */
	public String getDataNascAsString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.dataNasc.getTime());
	}

	public void setDataNasc(Calendar dataNasc) {
		this.dataNasc = dataNasc;
	}
	
	/**
	 * Este método insere valor no campo DataNasc da classe.
	 * @param dataLocacao String - "dd/MM/yyyy"
	 * 	- Exemplo: "12/08/1994"
	 * @return true - se a data for convertida e inserida;
	 * 		   ou false - se ocorrer um erro na conversão;
	 */
	public boolean setDataNasc(String dataNasc) {
		try {
			this.dataNasc = Calendar.getInstance();
			this.dataNasc.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataNasc));
			return true;
		} catch (ParseException e) {
			return false;
		}  
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
