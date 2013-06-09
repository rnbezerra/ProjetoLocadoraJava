package br.com.locadora.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HistoricoLocacao{

	private String codigoDVD;
	private Calendar dataLocacao;
	private Calendar dataDevolucao;
	private boolean devolvido;
	
	public HistoricoLocacao() {
	}

	public HistoricoLocacao(String codigoDVD, Calendar dataLocacao,
			Calendar dataDevolucao) {
		super();
		this.codigoDVD = codigoDVD;
		this.dataLocacao = dataLocacao;
		this.dataDevolucao = dataDevolucao;
	}

	public HistoricoLocacao(String codigoDVD, String dataLocacao,
			String dataDevolucao) {
		super();
		this.codigoDVD = codigoDVD;
		this.setDataLocacao(dataLocacao);
		this.setDataDevolucao(dataDevolucao);
	}

	public String getCodigoDVD() {
		return codigoDVD;
	}

	public void setCodigoDVD(String codigoDVD) {
		this.codigoDVD = codigoDVD;
	}

	public Calendar getDataLocacao() {
		return dataLocacao;
	}

	/**
	 * Este método retorna a data de locação em uma string
	 * @return String formatada em "dd/MM/yyyy"
	 */
	public String getDataLocacaoAsString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.dataLocacao.getTime());
	}

	public void setDataLocacao(Calendar dataLocacao) {
		this.dataLocacao = dataLocacao;
	}
	
	/**
	 * Este método insere valor no campo DataLocacao da classe.
	 * @param dataLocacao String - "dd/MM/yyyy"
	 * 	- Exemplo: "12/08/1994"
	 * @return true - se a data for convertida e inserida;
	 * 		   ou false - se ocorrer um erro na conversão;
	 */
	public boolean setDataLocacao(String dataLocacao) {
		try {
			this.dataLocacao = Calendar.getInstance();
			this.dataLocacao.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataLocacao));
			return true;
		} catch (ParseException e) {
			return false;
		}  
	}

	public Calendar getDataDevolucao() {
		return dataDevolucao;
	}
	
	/**
	 * Este método retorna a data de devolução em uma string
	 * @return String formatada em "dd/MM/yyyy"
	 */
	public String getDataDevolucaoAsString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.dataDevolucao.getTime());
	}

	public void setDataDevolucao(Calendar dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	/**
	 * Este método insere valor no campo DataDevolucao da classe.
	 * @param dataDevolucao String - "dd/MM/yyyy"
	 * 	- Exemplo: "12/08/1994"
	 * @return true - se a data for convertida e inserida;
	 * 		   ou false - se ocorrer um erro na conversão;
	 */
	public boolean setDataDevolucao(String dataDevolucao) {
		try {
			this.dataDevolucao = Calendar.getInstance();
			this.dataDevolucao.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataDevolucao));
			return true;
		} catch (ParseException e) {
			return false;
		}  
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
	
	
	
	
	
	
}
