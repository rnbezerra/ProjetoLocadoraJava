package br.com.locadora.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import br.com.locadora.dataIO.AluguelImportacao;
import br.com.locadora.dataIO.ClienteImportacao;
import br.com.locadora.dataIO.FilmeImportacao;
import br.com.locadora.dataIO.ShowImportacao;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;
import br.com.locadora.model.DVD.TipoDVD;
import br.com.locadora.model.Filme;
import br.com.locadora.model.HistoricoLocacao;
import br.com.locadora.model.Show;
import br.com.locadora.view.ViewAluguel;




public class ControllerAluguel {
		
	private static ArrayList<Cliente> listaGeralClientes = new ArrayList<Cliente>();
	private static ArrayList<DVD> listaGeralDVDs = new ArrayList<DVD>();
	
	/*
	#### METODOS PÚBLICOS ####
	*/
	
	public static void realizaAluguel(HashMap<String, String> parameters) {
		
		Cliente cliente;
		DVD dvd;
		
		String codigoDVD = parameters.get("d"),
			   codigoCliente = parameters.get("c"),
			   dataAluguel = parameters.get("t");
		double valorPago =  Double.parseDouble(parameters.get("v").replace(",", "."));
		
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
		double saldo = 0;
		if(!Double.isNaN(valorPago)){
			saldo = valorPago - dvd.getPrecoLocacao(cliente.getStatus());
		}
		

		//Decremento do número de copias em função do aluguel
		dvd.setCopias(dvd.getCopias()+1);
		//salvar lista de dvds em arquivo
		if(dvd.getTipo() == TipoDVD.Filme){
			ArrayList<Filme> filmes = getFilmes();
			for (Filme filme : filmes) {
				if(filme.getCodigo().equals(dvd.getCodigo())){
					filme.setCopias(dvd.getCopias());
					//salvar filme
					FilmeImportacao.salvarFilme(filmes);
					break;
				}
			}
		}
		else{//tipo == show
			ArrayList<Show> shows = getShows();
			for (Show show : shows) {
				if(show.getCodigo().equals(dvd.getCodigo())){
					show.setCopias(dvd.getCopias());
					//salvar show
					ShowImportacao.salvarShow(shows);
					break;
				}
			}
		}
		
		//Adiciona novo alugal à lista de historico de locações
		cliente.addHistoricoLocacao(new HistoricoLocacao(codigoDVD, dataAluguel, false));
		ClienteImportacao.salvarClientes(listaGeralClientes);

		//salva lista de clientes em arquivo
		AluguelImportacao.salvarAluguel(dvd, cliente, dataAluguel, saldo);
		
		ViewAluguel.mostraAluguelRealizado(cliente, dvd, saldo, new SimpleDateFormat("dd/MM/yyyy").format(dataDevolucao.getTime()));
		
	}
	
	public static void realizarDevolucao(HashMap<String, String> parameters) {
		
		Cliente cliente;
		DVD dvd;
		

		String codigoDVD = parameters.get("d"),
			   codigoCliente = parameters.get("c"),
			   dataAluguel = parameters.get("t");
		double valorPago =  Double.parseDouble(parameters.get("v").replace(",", "."));
		
		//busca cliente e dvd
		if((cliente = getCliente(codigoCliente)) == null || (dvd = getDVD(codigoDVD)) == null){
			ViewAluguel.dadoNaoEncontrado();
			return;
		}
		
		//Carrega arquivo do aluguel de acordo com cliente e dvd
		if(!AluguelImportacao.carregarAluguel(dvd.getCodigo(), cliente.getCodigo(), dataAluguel)){
			ViewAluguel.dadoNaoEncontrado();
			return;
		}				
		
		//calculo do preço de locação
		double saldo = 0;
		if(!Double.isNaN(valorPago)){
			saldo = valorPago + AluguelImportacao.getValor();
		}
		

		dvd.setCopias(dvd.getCopias()+1);
		//salvar lista de dvds em arquivo
		if(dvd.getTipo() == TipoDVD.Filme){
			ArrayList<Filme> filmes = getFilmes();
			for (Filme filme : filmes) {
				if(filme.getCodigo().equals(dvd.getCodigo())){
					filme.setCopias(dvd.getCopias());
					//salvar filme
					FilmeImportacao.salvarFilme(filmes);
					break;
				}
			}
		}
		else{//tipo == show
			ArrayList<Show> shows = getShows();
			for (Show show : shows) {
				if(show.getCodigo().equals(dvd.getCodigo())){
					show.setCopias(dvd.getCopias());
					//salvar show
					ShowImportacao.salvarShow(shows);
					break;
				}
			}
		}

		String now = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		
		//insere a data de devolução no historico de locações
		cliente.getHistoricoLocacao()
			.getByCodigoDvdDataLocacao(codigoDVD, dataAluguel)
			.setDataDevolucao(dataAluguel);
		cliente.getHistoricoLocacao()
			.getByCodigoDvdDataLocacao(codigoDVD, dataAluguel)
			.setDevolvido(true);

		//salva lista de clientes em arquivo
		ClienteImportacao.salvarClientes(listaGeralClientes);
		
		
		ViewAluguel.mostraAluguelDevolvido(cliente, dvd, saldo, dataAluguel, now);
		
	}
	/*
	#### METODOS PRIVADOS ####
	*/
	private static Cliente getCliente(String codigo) {		
		listaGeralClientes = ClienteImportacao.listaDeClientes();
			
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
	
	private static ArrayList<Filme> getFilmes() {
		return FilmeImportacao.listaDeFilmes();
	}
	
	private static ArrayList<Show> getShows() {
		return ShowImportacao.listaDeShows();
	}
	
	
}
