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

import dataIO.ClienteImportacao;

import model.AluguelSerializable;
import model.Cliente;
import model.DVD;
import model.DVD.TipoDVD;
import model.Filme;
import model.HistoricoLocacao;
import model.Show;

import view.ViewAluguel;

public class ControllerAluguel {
	
	public static void realizaAluguel(String codigoDVD, String codigoCliente, String dataAluguel, double valorPago) {
		
		Cliente cliente;
		DVD dvd;
				
		if((cliente = getCliente(codigoCliente)) == null || (dvd = getDVD(codigoDVD)) == null){
			ViewAluguel.dadoNaoEncontrado();
			return;
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
		
		//calculo do preço de locação
		double saldo = valorPago - dvd.getPrecoLocacao(cliente.getStatus());

		//Decremento do número de copias em função do aluguel e uma copia
		dvd.setCopias(dvd.getCopias()-1);
		
		//TODO chamar método de serialização do alugual
		
		ViewAluguel.mostraAluguelRealizado(cliente, dvd, saldo, new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao));
		
	}

	private static Cliente getCliente(String codigo) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		//TODO carregar lista de clientes a partir do arquivo
		lista = ClienteImportacao.clienteImportacao();
			
		for (Cliente cliente : lista) {
			if(cliente.getCodigo().equals(codigo)) return cliente; 
		}
		
		return null;
	}
	
	private static DVD getDVD(String codigo) {
		ArrayList<DVD> lista = new ArrayList<DVD>();
		//TODO carregar lista de DVDs a partir do arquivo
		//==CODIGO CRIADO SOMENTE PARA TESTES==
		//==CODIGO CRIADO SOMENTE PARA TESTES==
		
		for (DVD dvd : lista) {
			if(dvd.getCodigo().equals(codigo)) return dvd;
		}
		
		return null;
	}
	
	
}
