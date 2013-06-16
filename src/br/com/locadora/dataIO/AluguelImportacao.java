package br.com.locadora.dataIO;

import br.com.locadora.model.AluguelSerializable;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;



public class AluguelImportacao extends Serializer<AluguelSerializable>{
	
	private static String codigoCliente;
	private static String codigoDvd;
	private static String dataAluguel;
	private static double valor;
	
	public static String getCodigoCliente() {
		return codigoCliente;
	}

	public static String getCodigoDvd() {
		return codigoDvd;
	}

	public static String getDataAluguel() {
		return dataAluguel;
	}

	public static double getValor() {
		return valor;
	}
	
	private static AluguelImportacao getInstance() {
		return new AluguelImportacao();
	}
	
	public static boolean salvarAluguel(DVD dvd, Cliente cliente, String dataAluguel, double valorPago ) {
		
		String filename = String.format("%s_%s_%s", cliente.getCodigo(), dvd.getCodigo(), dataAluguel.replace("/", ""));

		AluguelSerializable serializable = new AluguelSerializable(cliente.getCodigo(), dvd.getCodigo(), dataAluguel, valorPago);
				
		return new AluguelImportacao().using(serializable).saveFileWithName(filename);
		
	}

	public static boolean carregarAluguel(String codigoDVD, String codigoCliente, String dataAluguel) {
		String filename = String.format("%s_%s_%s", codigoCliente, codigoDVD, dataAluguel.replace("/", ""));
		
		
		AluguelSerializable aluguel = getInstance().using(new AluguelSerializable()).loadFileWithName(filename).getObject();
		boolean success = false;
		if((success = (aluguel != null))){			
			codigoCliente = aluguel.getCodigoCliente();
			codigoDvd = aluguel.getCodigoDVD();
			dataAluguel = aluguel.getDataLocacao();
			valor = aluguel.getValorPago();
		}
		
		return success;

	}
	

}
