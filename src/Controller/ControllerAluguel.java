package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

import model.AluguelSerializable;
import model.Cliente;
import model.DVD;

import view.ViewAluguel;



public class ControllerAluguel {

	private Cliente cliente;
	private DVD dvd;
	private Date dataAluguel;
	private double valorPago;
	
	public boolean Save() {
		AluguelSerializable serializable = new AluguelSerializable(cliente.getCodigo(), dvd.getCodigo(), dataAluguel, valorPago);
		
		try{
			String filename = String.format("ALUGUEL\\ALUGUEL_%s_%s", cliente.getCodigo(), dvd.getCodigo());
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(serializable);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return true;
	}

	public static void realizaAluguel() {
		// TODO realizar logica de validação dos parametros
		// TODO realizar logica de persistencia de aluguel
		
		ViewAluguel.mostraAluguelRealizado();
		
	}
}
