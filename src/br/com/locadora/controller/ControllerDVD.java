package br.com.locadora.controller;

import java.util.ArrayList;
import java.util.HashMap;

import br.com.locadora.dataIO.AtorArtistaImportacao;
import br.com.locadora.dataIO.DiretorImportacao;
import br.com.locadora.dataIO.FilmeImportacao;
import br.com.locadora.dataIO.ShowImportacao;
import br.com.locadora.model.DVD;
import br.com.locadora.model.DVD.TipoDVD;
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
		
		HashMap<String, String> hash = new HashMap<String, String>();
		//hash.put("t", "show");
		hash.put("t", "filme");
		listaDVDs("tom", hash);
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
	
	public static void listaDVDs(String queryString, HashMap<String, String> optionalParameters) {
		
		ArrayList<DVD> lista = getDVDs();
		ArrayList<DVD> matchedDVDs = new ArrayList<DVD>();
		HashMap<String, Personalidade> personalidades = getPersonalidades();				
		
		queryString = queryString.toLowerCase();
		
		for (DVD dvd : lista) {

			//TODO filtro pela query string
			//filtrar em titulo e nome(Personalidade)
			
			boolean queryMatch = false;
			//Verifica se a lista ainda é maior que 0
			if(lista.size() > 0){
				//verifica se o titulo do DVD possia a queryString
				//se tiver o DVD permanesse na lista, senão...
				if(dvd.getTitulo().toLowerCase().indexOf(queryString) == -1){
					
					
					//verifica se o tipo do dvd é filme
					if(dvd.getTipo() == TipoDVD.Filme)
					{
						//carrega o filme pelo codigo
						Filme filme = getFilme(dvd.getCodigo());
						//verifica se o filme tem o diretor com o nome na queryString
						//se tiver o DVD permanesse na lista, senão... 
						if(getDiretor(filme.getDirecao()).getNome().toLowerCase().indexOf(queryString) == -1){
							//verifica se algum dos atores no elenco do filme tem o nome compativel com a queryString
							for (String codArtista : filme.getElenco()) {
								if(personalidades.get(codArtista).getNome().toLowerCase().indexOf(queryString) != -1){
									queryMatch = true;
									break;
								}
							}
							//se rodou todo a lista do elenco e não achou a queryString
							if(!queryMatch){
								continue;
							}
								
						}						
					}
					else{//tipo == Show
						
						Show show = getShow(dvd.getCodigo());
						
						if(personalidades.get(show.getArtista()).getNome().toLowerCase().indexOf(queryString) == -1){
							continue;
						}
					}
					
					
				}
			}
			else break;

			//TODO filtro por ano de lançamento
			if(optionalParameters.containsKey("y") && lista.size() > 0){
				if(!dvd.getAnoLancamento().equals(optionalParameters.get("y"))){//exclui dvd
					continue;
				}
			}
			
			//TODO filtro por genero
			if(optionalParameters.containsKey("g") && lista.size() > 0){
				if(!dvd.getGenero().equalsIgnoreCase(optionalParameters.get("g"))){//exclui dvd
					continue;
				}
			}
			
			//TODO filtro por area
			if(optionalParameters.containsKey("a") && lista.size() > 0){
				if(!dvd.getArea().equals(optionalParameters.get("a"))){//exclui dvd
					continue;
				}
			}
			
			//TODO filtro por tipo de dvd
			if(optionalParameters.containsKey("t") && lista.size() > 0){
				if(!dvd.getTipoAsString().equalsIgnoreCase(optionalParameters.get("t"))){//exclui dvd
					continue;
				}
			}
			
			//TODO filtro por categoria
			if(optionalParameters.containsKey("c") && lista.size() > 0){
				if(!dvd.getCategoriaAsString().equalsIgnoreCase(optionalParameters.get("c"))){//exclui dvd
					continue;
				}
			}
			
			matchedDVDs.add(dvd);
		}
		
		
		if(matchedDVDs.size() > 0) ViewDVD.mostraListaDeDVDs(matchedDVDs);
		else ViewDVD.dadoNaoEncontrado();
	}
	
	/*
	#### METODOS PRIVADOS ####
	*/
	
	private static ArrayList<DVD> getDVDs() {
		ArrayList<DVD> lista = new ArrayList<DVD>();
		
		lista.addAll(FilmeImportacao.listaDeFilmes());
		lista.addAll(ShowImportacao.listaDeShows());
		
		return lista;
	}
	
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
	
	private static HashMap<String, Personalidade> getPersonalidades() {
		HashMap<String, Personalidade> hash = new HashMap<String, Personalidade>();
		
		for (Personalidade p : AtorArtistaImportacao.listaDeAtoresArtistas()) {
			hash.put(p.getCodigo(), p);
		}
		
		return hash; 
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
