package br.com.locadora.dataIO;

import java.io.*;
import java.util.*;

import br.com.locadora.model.Show;
import br.com.locadora.model.DVD.CategoriaDVD;


public class ShowImportacao extends Serializer<ArrayList<Show>>{
	/*
	 * A classe ShowImportacao é responsável por obter os dados dos Shows que estao dentro
	 * do aquivo dvdsShows.txt na pasta importacao, e retornar uma ArrayList contendo todos os 
	 * dados dos shows. 
	 * 
	 * Pela dificuldade gerada ao trabalhar somente com a classe File,
	 * preenchi primeiramente uma ArrayList com os dados deste arquivo e trabalhei com estes dados.
	 * Com relação a categoria (lançamento, acervo), criei um if que pergunta se a linha é igual a lançamento 
	 * ou categoria e com o uso do enum, eu seto o campo categoria corretamente.
	 * 
	 * 
	 * */

	
	
	private static final String FILENAME = "Show";
	
	/**
	 * Este método retorna um nova instância da classe ShowImportacao
	 * @return new ShowImportacao();
	 */
	private static ShowImportacao getInstance() {
		return new ShowImportacao();
	}
	
	public static void salvarShow(ArrayList<Show> lista) {
		getInstance().using(lista).saveFileWithName(FILENAME);
	}	

	public static ArrayList<Show> listaDeShows(){
		
		ArrayList<Show> listaDeShows = new ArrayList<Show>();
		
		/*VERIFICA SE JÁ EXISTE UM ARQUIVO SERIALIZADO*/
		if(getInstance().using(new ArrayList<Show>()).dirExists()){
			if(!(listaDeShows = getInstance().using(new ArrayList<Show>()).loadFileWithName(FILENAME).getObject()).isEmpty()){
				return listaDeShows;
			}
		}
		
		/*Declaração de variáveis */
		
		int i = 0;
		String leitura, categoriaFile;
		ArrayList<String> listaDeDados = new ArrayList<String>();
		
		
		/*------------------------*/
		
		File dir = new File("importacao");
		File arq = new File(dir, "dvdsShows.txt");
				
			FileReader fileReader;
			try {
				fileReader = new FileReader(arq);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while((leitura = bufferedReader.readLine()) != null){
						listaDeDados.add(leitura);
				}
				
				bufferedReader.close();
				
				while(i != listaDeDados.size()){
					Show show = new Show();
					
					show.setTitulo(listaDeDados.get(i++));
					show.setCodigo(listaDeDados.get(i++));
					show.setArea(listaDeDados.get(i++));
					show.setFaixas(listaDeDados.get(i++));
					show.setGenero(listaDeDados.get(i++));
					show.setArtista(listaDeDados.get(i++));
					show.setAnoLancamento(listaDeDados.get(i++));
					show.setCopias(Integer.parseInt(listaDeDados.get(i++)));

					//inicio do tratamento de categoria
					categoriaFile = listaDeDados.get(i++);
					if(categoriaFile.toLowerCase().equals("lançamento")){
						show.setCategoria(CategoriaDVD.Lancamento);
					}else if(categoriaFile.toLowerCase().equals("acervo")){
						show.setCategoria(CategoriaDVD.Acervo);	
					}
					
					listaDeShows.add(show);
					i++; 
				}
		
			}
			
			catch(IOException e){
				e.printStackTrace();				
			}
			
		return listaDeShows;
		
	}

}
