package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HistoricoLocacao{

	private String codigoDVD;
	private Date dataLocacao;
	private Date dataDevolucao;
	
	public HistoricoLocacao() {
	}

	public HistoricoLocacao(String codigoDVD, Date dataLocacao,
			Date dataDevolucao) {
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

	public Date getDataLocacao() {
		return dataLocacao;
	}

	/**
	 * Este método retorna a data de locação em uma string
	 * @return String formatada em "dd/MM/yyyy"
	 */
	public String getDataLocacaoAsString() {
		return new SimpleDateFormat("dd/MM/yyyy").format(this.dataLocacao);
	}

	public void setDataLocacao(Date dataLocacao) {
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
			this.dataLocacao = new SimpleDateFormat("dd/MM/yyyy").parse(dataLocacao);
			return true;
		} catch (ParseException e) {
			return false;
		}  
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	/**
	 * Este método retorna a data de devolução em uma string
	 * @return String formatada em "dd/MM/yyyy"
	 */
	public String getDataDevolucaoAsString() {
		return new SimpleDateFormat("MM/dd/yyyy").format(this.dataDevolucao);
	}

	public void setDataDevolucao(Date dataDevolucao) {
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
			this.dataDevolucao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDevolucao);
			return true;
		} catch (ParseException e) {
			return false;
		}  
	}
	
	
	
	
	
	
}
