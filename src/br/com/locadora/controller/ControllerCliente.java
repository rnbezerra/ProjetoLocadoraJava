package br.com.locadora.controller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.locadora.dataIO.ClienteImportacao;
import br.com.locadora.dataIO.FilmeImportacao;
import br.com.locadora.dataIO.ShowImportacao;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;
import br.com.locadora.model.HistoricoLocacao;
import br.com.locadora.view.ViewCliente;

public class ControllerCliente {
	
	public static void teste() {
		realizarBusca("001001");
	}
	

	public static void realizarBusca(String codigo) {
		
		Cliente cliente;
		if((cliente = getCliente(codigo)) == null){
			ViewCliente.dadoNaoEncontrado();
			return;
		}
		
		HashMap<String, String> nomesDvds = new HashMap<String, String>();
		
		for (HistoricoLocacao hl : cliente.getHistoricoLocacao()) {
			DVD dvd;
			if((dvd = getDVD(hl.getCodigoDVD())) != null) nomesDvds.put(dvd.getCodigo(), dvd.getTitulo());
		}
		
		ViewCliente.mostraCliente(cliente, nomesDvds);
	}
	
	/*
	#### METODOS PRIVADOS ####
	*/
	private static Cliente getCliente(String codigo) {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();
		
		lista = ClienteImportacao.listaDeClientes();
			
		for (Cliente cliente : lista) {
			if(cliente.getCodigo().equals(codigo)) return cliente; 
		}
		
		return null;
	}
	
	
	private static DVD getDVD(String codigo) {
		ArrayList<DVD> lista = new ArrayList<DVD>();
		lista.addAll(FilmeImportacao.listaDeFilmes());
		lista.addAll(ShowImportacao.listaDeShows());
		
		for (DVD dvd : lista) {
			if(dvd.getCodigo().equals(codigo)) return dvd;
		}
		
		return null;
	}
	
}
