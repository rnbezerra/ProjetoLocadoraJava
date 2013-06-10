package br.com.locadora.dataIO;

import br.com.locadora.model.AluguelSerializable;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;



public class AluguelImportacao extends Serializer<AluguelSerializable>{

	private static final String PATH = "ALUGUEL";
	
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
	
	public static boolean salvarAluguel(DVD dvd, Cliente cliente, String dataAluguel, double valorPago ) {
		
		String filename = String.format("%s_%s_%s", cliente.getCodigo(), dvd.getCodigo(), dataAluguel.replace("/", ""));

		AluguelSerializable serializable = new AluguelSerializable(cliente.getCodigo(), dvd.getCodigo(), dataAluguel, valorPago);
				
		return new AluguelImportacao().using(serializable).salvarArquivo(filename);
		
		/*
		try {
			if(!new File(PATH).exists()){
				if(!new File(PATH).mkdir())	throw new IOException();
			}
			
			String filename = String.format("%s\\ALUGUEL_%s_%s_%s.quack", PATH, cliente.getCodigo(), dvd.getCodigo(), dataAluguel.replace("/", ""));
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(serializable);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return true;*/
	}

	public static boolean carregarArquivo(String codigoDVD, String codigoCliente, String dataAluguel) {
		String filename = String.format("%s_%s_%s", codigoCliente, codigoDVD, dataAluguel.replace("/", ""));
		
		AluguelImportacao importacao = new AluguelImportacao();
		boolean success = importacao.using(new AluguelSerializable()).carregarArquivo(filename);
		if(success){
			AluguelSerializable ai = importacao.getObject();
			
			codigoCliente = ai.getCodigoCliente();
			codigoDvd = ai.getCodigoDVD();
			dataAluguel = ai.getDataLocacao();
			valor = ai.getValorPago();
		}
		
		return success;
		/*AluguelSerializable aluguelDvd = new AluguelSerializable();
		try {

			if(!new File(PATH).exists()){
				new File(PATH).mkdir();
				throw new IOException();
			}
			
			String filename = String.format("%s\\ALUGUEL_%s_%s_%s.quack", PATH, codigoCliente, codigoDVD, dataAluguel.replace("/", ""));
					
			FileInputStream inputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			aluguelDvd = aluguelDvd.getClass().cast(objectInputStream.readObject());
			
			objectInputStream.close();
			inputStream.close();
			

			AluguelImportacao.codigoCliente = aluguelDvd.getCodigoCliente();
			AluguelImportacao.codigoDvd = aluguelDvd.getCodigoDVD();
			AluguelImportacao.dataAluguel = aluguelDvd.getDataLocacao();
			AluguelImportacao.valor = aluguelDvd.getValorPago();
			
			System.out.println("Objeto carregado...");
			System.out.println("Codigo Cliente: " + aluguelDvd.getCodigoCliente());
			System.out.println("Codigo DVD: " + aluguelDvd.getCodigoDVD());
			System.out.println("Data de Aluguel: " + aluguelDvd.getDataLocacao());
			System.out.println("Valor Pago: R$" + aluguelDvd.getValorPago());
			System.out.println();
			
			//TODO detelar arquivo ap�s importa��o
			
			return true;
			
		} catch (IOException i) {
			System.err.println("Erro na leitura do arquivo.");
			//i.printStackTrace();
			return false;
			
		}catch (ClassNotFoundException c) {
			System.err.println("Classe N�o encontrada");
			//c.printStackTrace();
			return false;
		}		
		*/
	}
	

}
