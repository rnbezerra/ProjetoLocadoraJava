package br.com.locadora.controller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.locadora.dataIO.AtorArtistaImportacao;
import br.com.locadora.dataIO.DiretorImportacao;
import br.com.locadora.dataIO.FilmeImportacao;
import br.com.locadora.dataIO.ShowImportacao;
import br.com.locadora.model.Diretor;
import br.com.locadora.model.Filme;
import br.com.locadora.model.Personalidade;
import br.com.locadora.model.Show;
import br.com.locadora.view.ViewDVD;

public class ControllerDVD {

	public static void teste() {
		realizarBusca("002");
		System.out.println("\n----\n");
		realizarBusca("004");
		System.out.println("\n----\n");
		realizarBusca("001");
		System.out.println("\n----\n");
		realizarBusca("003");
		System.out.println("\n----\n");
		realizarBusca("006");
		System.out.println("\n----\n");
		realizarBusca("009");
		System.out.println("\n----\n");
		realizarBusca("014");
		System.out.println("\n----\n");
		realizarBusca("013");
		System.out.println("\n----\n");
	}

	public static void realizarBusca(String codigo) {
		
		Filme filme;
		Show show;
		
		if( (show = getShow(codigo)) != null){
			ViewDVD.mostraShow(show);
		}
		else if( (filme = getFilme(codigo)) != null){
			HashMap<String, Personalidade> personalidades = new HashMap<String, Personalidade>();
			
			for (Personalidade personalidade : AtorArtistaImportacao.listaDeAtoresArtistas()) {
				personalidades.put(personalidade.getCodigo(), personalidade);
			}	
			String nomeDiretor = getDiretor(filme.getDirecao()).getNome();
			ViewDVD.mostraFilme(filme, personalidades, nomeDiretor);
		}
		else ViewDVD.dadoNaoEncontrado();
	}
	
	/*
	#### METODOS PRIVADOS ####
	*/
	
	private static Filme getFilme(String codigo) {
		ArrayList<Filme> lista = new ArrayList<Filme>();
		lista.addAll(FilmeImportacao.listaDeFilmes());

		for (Filme filme : lista) {
			if(filme.getCodigo().equals(codigo)) return filme;
		}
		
		return null;
	}
	
	private static Diretor getDiretor(String codigo) {
		ArrayList<Diretor> lista = new ArrayList<Diretor>();
		lista.addAll(DiretorImportacao.listaDeDiretores());

		for (Diretor diretor : lista) {
			if(diretor.getCodigo().equals(codigo)) return diretor;
		}
		
		return null;
	}
	
	private static Show getShow(String codigo) {
		ArrayList<Show> lista = new ArrayList<Show>();
		lista.addAll(ShowImportacao.listaDeShows());

		for (Show show : lista) {
			if(show.getCodigo().equals(codigo)) return show;
		}
		
		return null;
	}
}
