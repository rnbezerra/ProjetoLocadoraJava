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

public class Serializer<E> {

	

	/*
	#### METODOS PÚBLICOS ####
	*/
	/*
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

	public static boolean carregarArquivo(String codigoDVD, String codigoCliente, String dataAluguel) {
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
			
			//TODO detelar arquivo após importação
			
			return true;
			
		} catch (IOException i) {
			System.err.println("Erro na leitura do arquivo.");
			//i.printStackTrace();
			return false;
			
		}catch (ClassNotFoundException c) {
			System.err.println("Classe Não encontrada");
			//c.printStackTrace();
			return false;
		}		
		
	}*/
	
	public void teste() {
		getPath();
	}
	
	/*
	#### METODOS PRIVADOS ####
	*/
	
	private static String getPath() {
		
		return "";
	}
}
