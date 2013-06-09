package br.com.locadora.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.text.View;

import org.w3c.dom.ls.LSInput;

import br.com.locadora.dataIO.AluguelImportacao;
import br.com.locadora.dataIO.ClienteImportacao;
import br.com.locadora.dataIO.FilmeImportacao;
import br.com.locadora.dataIO.ShowImportacao;
import br.com.locadora.model.AluguelSerializable;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;
import br.com.locadora.model.Filme;
import br.com.locadora.model.HistoricoLocacao;
import br.com.locadora.model.Show;
import br.com.locadora.model.DVD.TipoDVD;
import br.com.locadora.view.ViewAluguel;




public class ControllerAluguel {
	/*
	#### METODOS PÚBLICOS ####
	*/
	
	public static void teste() {
		realizaAluguel("013", "005005", "30/05/2013", "3.00");
		
		System.out.println("\n\n\n");
		
		AluguelImportacao.carregarArquivo("013", "005005", "30/05/2013");
	}
	
	public static void realizaAluguel(String codigoDVD, String codigoCliente, String dataAluguel, String valorPago) {
		
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
			dataDevolucao.add(Calendar.DATE, dvd.getDiasParaLocacao());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		
		//calculo do preço de locação
		double saldo = 0,
				converted = Double.parseDouble(valorPago);
		if(!Double.isNaN(converted)){
			saldo = converted - dvd.getPrecoLocacao(cliente.getStatus());
		}
		

		//Decremento do número de copias em função do aluguel e uma copia
		dvd.setCopias(dvd.getCopias()-1);

		//TODO adicionar o histórico de locação no cliente
		
		//TODO chamar método de serialização do alugual
		AluguelImportacao.salvarAluguel(dvd, cliente, dataAluguel, saldo);
		
		ViewAluguel.mostraAluguelRealizado(cliente, dvd, saldo, new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao.getTime()));
		
	}
	
	public static void realizarDevolucao(String codigoDVD, String codigoCliente, String dataAluguel, String valorPago) {
		
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
		
		//calculo do preço de locação
		double saldo = 0,
				converted = Double.parseDouble(valorPago);
		if(Double.isNaN(converted)){
			saldo = converted - dvd.getPrecoLocacao(cliente.getStatus());
		}
	}
	/*
	#### METODOS PRIVADOS ####
	*/
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
		//lista.addAll(FilmeImportacao.listaDeFilmes());
		lista.addAll(ShowImportacao.listaDeShows());
		
		for (DVD dvd : lista) {
			if(dvd.getCodigo().equals(codigo)) return dvd;
		}
		
		return null;
	}
	
	
}
