package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import model.AluguelSerializable;
import model.Cliente;
import model.DVD;
import model.HistoricoLocacao;

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

	public static void realizaAluguel(String codigoDVD, String codigoCliente, String dataAluguel, double valorPago) {
		// TODO realizar logica de validação dos parametros
		// TODO realizar logica de persistencia de aluguel
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
		Thread threadCliente = new Thread(){
			@Override
			public void run() {
//				listaClientes = 
//				super.run();
			}
		};
		
		Cliente cliente = new Cliente();
		
		HistoricoLocacao historicoLocacao = new HistoricoLocacao();
		historicoLocacao.setCodigoDVD(codigoDVD);
		historicoLocacao.setDataLocacao("12/08/1994");
		historicoLocacao.setDataDevolucao("15/08/1994");		
		
		cliente.addHistoricoLocacao(historicoLocacao);
		System.out.println(cliente.getHistoricoLocacao().get(0).getCodigoDVD());
		
		ViewAluguel.mostraAluguelRealizado();
		
	}
}
