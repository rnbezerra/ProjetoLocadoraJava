package Model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AluguelSerializable implements Serializable {

	private String codigoCliente;
	private String codigoDVD;
	private String dataLocacao;
	private double valorPago;
	
	public AluguelSerializable() {}
		

	public AluguelSerializable(String codigoCliente, String codigoDVD,
			String dataLocacao, double valorPago) {
		super();
		this.codigoCliente = codigoCliente;
		this.codigoDVD = codigoDVD;
		this.dataLocacao = dataLocacao;
		this.valorPago = valorPago;
	}
	
	public AluguelSerializable(String codigoCliente, String codigoDVD,
			Date dataLocacao, double valorPago) {
		super();
		this.codigoCliente = codigoCliente;
		this.codigoDVD = codigoDVD;
		this.setDataLocacao(dataLocacao);
		this.valorPago = valorPago;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}
	
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public String getCodigoDVD() {
		return codigoDVD;
	}
	
	public void setCodigoDVD(String codigoDVD) {
		this.codigoDVD = codigoDVD;
	}
	
	public String getDataLocacao() {
		return dataLocacao;
	}
	
	public void setDataLocacao(String dataAluguel) {
		this.dataLocacao = dataAluguel;
	}

	public void setDataLocacao(Date ataLocacao) {
		this.dataLocacao = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this.dataLocacao);
	}
	
	public double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	
	
}
