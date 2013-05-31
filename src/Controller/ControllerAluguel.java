package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.text.View;

import org.w3c.dom.ls.LSInput;

import model.AluguelSerializable;
import model.Cliente;
import model.DVD;
import model.Filme;
import model.HistoricoLocacao;
import model.Show;

import view.ViewAluguel;

public class ControllerAluguel {

	private Cliente cliente;
	private DVD dvd;
	private Date dataAluguel;
	private double valorPago;
	
	public static void realizaAluguel(String codigoDVD, String codigoCliente, String dataAluguel, double valorPago) {
		// TODO realizar logica de validação dos parametros
		// TODO realizar logica de persistencia de aluguel
		
		Cliente cliente;
		Object objectDvd;
				
		if((cliente = getCliente(codigoCliente)) == null || (objectDvd = getDVD(codigoDVD)) == null){
			ViewAluguel.dadoNaoEncontrado();
			return;
		}
		
		String tipoDvd = "";
		DVD dvd = new DVD();
		if(objectDvd instanceof Filme){
			tipoDvd = "Filme";
			dvd = (DVD)objectDvd;
		}
		else if(objectDvd instanceof Show){
			tipoDvd = "Show";
			dvd = (DVD)objectDvd;
		}
		
		if(dvd.getCopias() == 0){
			ViewAluguel.copiasIndisponiveis(dvd);
			return;
		}
		
		Calendar dataDevolucao = Calendar.getInstance();
		try {
			dataDevolucao.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(dataAluguel));
			int dia = dataDevolucao.get(Calendar.DATE) + dvd.getDiasParaLocacao();
			
			dataDevolucao.set(Calendar.DATE, dia);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		double saldo = valorPago;
			
		ViewAluguel.mostraAluguelRealizado(cliente, dvd, saldo, new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao));
		
	}

	private static Cliente getCliente(String codigo) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		//TODO carregar lista de clientes a partir do arquivo
			
		for (Cliente cliente : lista) {
			if(cliente.getCodigo().equals(codigo)) return cliente; 
		}
		
		return null;
	}
	
	private static DVD getDVD(String codigo) {
		ArrayList<DVD> lista = new ArrayList<DVD>();
		//TODO carregar lista de DVDs a partir do arquivo
		
		for (DVD dvd : lista) {
			if(dvd.getCodigo().equals(codigo)) return dvd;
		}
		
		return null;
	}
	/*
	private static boolean Save() {
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
	}*/

	
}
