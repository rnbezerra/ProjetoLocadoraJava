package br.com.locadora.dataIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.locadora.model.AluguelSerializable;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;


public class AluguelImportacao {

	private static final String PATH = "ALUGUEL";
	
	private static Cliente cliente;
	private static DVD dvd;
	private static String dataAluguel;
	private static double valor;
	
	public static boolean salvarAluguel(DVD dvd, Cliente cliente, String dataAluguel, double valorPago ) {
		AluguelSerializable serializable = new AluguelSerializable(
				cliente.getCodigo(), dvd.getCodigo(), dataAluguel, valorPago);

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

		return true;
	}

	public static void carregarArquivo(String codigoDVD, String codigoCliente, String dataAluguel) {
		AluguelSerializable aluguelDvd = new AluguelSerializable();
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
			
			
			
		} catch (IOException i) {
			System.err.println("Erro na leitura do arquivo.");
			//i.printStackTrace();
			return;
			
		}catch (ClassNotFoundException c) {
			System.err.println("Classe Não encontrada");
			//c.printStackTrace();
			return;
		}		
		
		System.out.println("Objeto carregado...");
		System.out.println("Codigo Cliente: " + aluguelDvd.getCodigoCliente());
		System.out.println("Codigo DVD: " + aluguelDvd.getCodigoDVD());
		System.out.println("Data de Aluguel: " + aluguelDvd.getDataLocacao());
		System.out.println("Valor Pago: R$" + aluguelDvd.getValorPago());
		
	}

	public static Cliente getCliente() {
		return cliente;
	}

	public static void setCliente(Cliente cliente) {
		AluguelImportacao.cliente = cliente;
	}

	public static DVD getDvd() {
		return dvd;
	}

	public static void setDvd(DVD dvd) {
		AluguelImportacao.dvd = dvd;
	}

	public static String getDataAluguel() {
		return dataAluguel;
	}

	public static void setDataAluguel(String dataAluguel) {
		AluguelImportacao.dataAluguel = dataAluguel;
	}

	public static double getValor() {
		return valor;
	}

	public static void setValor(double valor) {
		AluguelImportacao.valor = valor;
	}
	
	

}
