package br.com.locadora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import br.com.locadora.dataIO.AluguelImportacao;
import br.com.locadora.dataIO.ClienteImportacao;
import br.com.locadora.dataIO.FilmeImportacao;
import br.com.locadora.dataIO.ShowImportacao;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;
import br.com.locadora.model.HistoricoLocacao;
import br.com.locadora.view.ViewAluguel;




public class ControllerAluguel {
	/*
	#### METODOS PÚBLICOS ####
	*/
	
	private static ArrayList<Cliente> listaGeralClientes = new ArrayList<Cliente>();
	private static ArrayList<DVD> listaGeralDVDs = new ArrayList<DVD>();
	
	
	public static void teste() {
		realizaAluguel("009", "003003", "02/03/2005", "2.00");
				
		realizarDevolucao("009", "003003", "02/03/2005", "4.00");
	}
	
	public static void realizaAluguel(String codigoDVD, String codigoCliente, String dataAluguel, String valorPago) {
		
		Cliente cliente;
		DVD dvd;
		
		//busca cliente e dvd
		if((cliente = getCliente(codigoCliente)) == null || (dvd = getDVD(codigoDVD)) == null){
			ViewAluguel.dadoNaoEncontrado();
			return;
		}
		
		//verifica se o nº de copias é igual a zero
		if(dvd.getCopias() == 0){
			ViewAluguel.copiasIndisponiveis(dvd);
			return;
		}
		
		//calcula data de devoluçao
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
		//TODO salvar lista de dvds em arquivo
		
		//Adiciona novo alugal à lista de historico de locações
		cliente.addHistoricoLocacao(new HistoricoLocacao(codigoDVD, dataAluguel, false));
		//TODO salvar lista de clientes em arquivo
				
		AluguelImportacao.salvarAluguel(dvd, cliente, dataAluguel, saldo);
		
		ViewAluguel.mostraAluguelRealizado(cliente, dvd, saldo, new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao.getTime()));
		
	}
	
	public static void realizarDevolucao(String codigoDVD, String codigoCliente, String dataAluguel, String valorPago) {
		
		Cliente cliente;
		DVD dvd;
				
		//busca cliente e dvd
		if((cliente = getCliente(codigoCliente)) == null || (dvd = getDVD(codigoDVD)) == null){
			ViewAluguel.dadoNaoEncontrado();
			return;
		}
		
		//Carrega arquivo do aluguel de acordo com cliente e dvd
		if(!AluguelImportacao.carregarArquivo(dvd.getCodigo(), cliente.getCodigo(), dataAluguel)){
			ViewAluguel.dadoNaoEncontrado();
						
		}
				
		
		//calculo do preço de locação
		double saldo = 0,
				valorPagoDouble = Double.parseDouble(valorPago);
		if(!Double.isNaN(valorPagoDouble)){
			saldo = valorPagoDouble + AluguelImportacao.getValor();
		}
		

		dvd.setCopias(dvd.getCopias()+1);
		//TODO salvar lista de dvds em arquivo
		
		//insere a data de devolução no historico de locações
		cliente.getHistoricoLocacao()
			.getByCodigoDvdDataLocacao(codigoDVD, dataAluguel)
			.setDataLocacao(dataAluguel);
		cliente.getHistoricoLocacao()
			.getByCodigoDvdDataLocacao(codigoDVD, dataAluguel)
			.setDevolvido(true);

		//TODO salvar lista de clientes em arquivo
		
		Date now = Calendar.getInstance().getTime();
		
		ViewAluguel.mostraAluguelDevolvido(cliente, dvd, saldo, dataAluguel, new SimpleDateFormat("dd/MM/yyyy").format(now));
		
	}
	/*
	#### METODOS PRIVADOS ####
	*/
	private static Cliente getCliente(String codigo) {
//		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		listaGeralClientes = ClienteImportacao.clienteImportacao();
			
		for (Cliente cliente : listaGeralClientes) {
			if(cliente.getCodigo().equals(codigo)) return cliente; 
		}
		
		return null;
	}
	
	private static DVD getDVD(String codigo) {
		
		listaGeralDVDs.addAll(FilmeImportacao.listaDeFilmes());
		listaGeralDVDs.addAll(ShowImportacao.listaDeShows());
		
		for (DVD dvd : listaGeralDVDs) {
			if(dvd.getCodigo().equals(codigo)) return dvd;
		}
		
		return null;
	}
	
	
}
