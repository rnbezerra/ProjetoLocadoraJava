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
//		this.dataLocacao = dataLocacao;
//		this.dataDevolucao = dataDevolucao;
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
	 * Este método
	 * @return
	 */
	public String getDataLocacaoAsString() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this.dataLocacao);
	}

	public void setDataLocacao(Date dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public boolean setDataLocacao(String dataLocacao) {
		try {
			this.dataLocacao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dataLocacao);
			return true;
		} catch (ParseException e) {
			return false;
		}  
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public String getDataDevolucaoAsString() {
		return new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(this.dataDevolucao);
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public boolean setDataDevolucao(String dataDevolucao) {
		try {
			this.dataDevolucao = new SimpleDateFormat("dd/MM/yyyy").parse(dataDevolucao);
			return true;
		} catch (ParseException e) {
			return false;
		}  
	}
	
	
	
	
	
	
}
