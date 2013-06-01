package dataIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.AluguelSerializable;
import model.Cliente;
import model.DVD;

public class AlugueImportacao {

	private static Cliente cliente;
	private static DVD dvd;
	private static String dataAluguel;
	private static double valor;
	
	public static boolean salvarAluguel(Cliente cliente, DVD dvd, String dataAluguel, double valorPago ) {
		AluguelSerializable serializable = new AluguelSerializable(
				cliente.getCodigo(), dvd.getCodigo(), dataAluguel, valorPago);

		try {
			String filename = String.format("ALUGUEL\\ALUGUEL_%s_%s",cliente.getCodigo(), dvd.getCodigo());
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

	public static void carregarArquivo(String filename) {
		AluguelSerializable aluguelDvd = new AluguelSerializable();
		try {
			
			FileInputStream inputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			aluguelDvd = aluguelDvd.getClass().cast(objectInputStream.readObject());
			
			objectInputStream.close();
			inputStream.close();
			
			
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
			
		}catch (ClassNotFoundException c) {
			System.out.println("Classe Não encontrada");
			c.printStackTrace();
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
		AlugueImportacao.cliente = cliente;
	}

	public static DVD getDvd() {
		return dvd;
	}

	public static void setDvd(DVD dvd) {
		AlugueImportacao.dvd = dvd;
	}

	public static String getDataAluguel() {
		return dataAluguel;
	}

	public static void setDataAluguel(String dataAluguel) {
		AlugueImportacao.dataAluguel = dataAluguel;
	}

	public static double getValor() {
		return valor;
	}

	public static void setValor(double valor) {
		AlugueImportacao.valor = valor;
	}
	
	

}
