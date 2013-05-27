package Model;

import java.io.Serializable;

public class AluguelSerializable implements Serializable {

	private String codigoCliente;
	private String codigoDVD;
	private String dataAluguel;
	private double valorPago;
	
	public AluguelSerializable() {}
		
	
	public AluguelSerializable(String codigoCliente, String codigoDVD,
			String dataAluguel, double valorPago) {
		super();
		this.codigoCliente = codigoCliente;
		this.codigoDVD = codigoDVD;
		this.dataAluguel = dataAluguel;
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
	
	public String getDataAluguel() {
		return dataAluguel;
	}
	
	public void setDataAluguel(String dataAluguel) {
		this.dataAluguel = dataAluguel;
	}
	
	public double getValorPago() {
		return valorPago;
	}
	
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	
	
}
