package br.com.locadora.dataIO;

import java.io.*;
import java.util.*;

import br.com.locadora.model.Show;
import br.com.locadora.model.DVD.CategoriaDVD;


public class ShowImportacao {
	/*
	 * A classe ShowImportacao � respons�vel por obter os dados dos Shows que estao dentro
	 * do aquivo dvdsShows.txt na pasta importacao, e retornar uma ArrayList contendo todos os 
	 * dados dos shows. 
	 * 
	 * Pela dificuldade gerada ao trabalhar somente com a classe File,
	 * preenchi primeiramente uma ArrayList com os dados deste arquivo e trabalhei com estes dados.
	 * Com rela��o a categoria (lan�amento, acervo), criei um if que pergunta se a linha � igual a lan�amento 
	 * ou categoria e com o uso do enum, eu seto o campo categoria corretamente.
	 * 
	 * 
	 * */
	
	//public static void main(String args[]){
	public static ArrayList<Show> listaDeShows(){
		/*Declara��o de vari�veis */
		
		int i = 0;
		String leitura, /*dados,*/ categoriaFile;
		//CategoriaDVD categoria;
		ArrayList<String> listaDeDados = new ArrayList<String>();
		ArrayList<Show> listaDeShows = new ArrayList<Show>();
		
		
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
					//i++;
					show.setCodigo(listaDeDados.get(i++));
					//i++;
					show.setArea(listaDeDados.get(i++));
					//i++;
					show.setFaixas(listaDeDados.get(i++));
					//i++;
					show.setGenero(listaDeDados.get(i++));
					//i++;
					show.setArtista(listaDeDados.get(i++));
					//i++;
					show.setAnoLancamento(listaDeDados.get(i++));
					//i++;
					show.setCopias(Integer.parseInt(listaDeDados.get(i++)));
					//i++; //inicio do tratamento de categoria
					categoriaFile = listaDeDados.get(i++);
					if(categoriaFile.toLowerCase().equals("lan�amento")){
						show.setCategoria(CategoriaDVD.Lancamento);
					}else if(categoriaFile.toLowerCase().equals("acervo")){
						show.setCategoria(CategoriaDVD.Acervo);	
					}
					//i++;
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
