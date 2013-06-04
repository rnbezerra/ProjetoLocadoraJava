package dataIO;

import java.io.*;
import java.util.*;

import model.Filme;
import model.DVD.CategoriaDVD;



public class FilmeImportacao {
	/*
	 * A classe FilmeImportacao é responsável por obter os dados dos Filmes que estao dentro
	 * do aquivo dvdsFilmes.txt na pasta importacao, e retornar uma ArrayList contendo todos os 
	 * dados dos Filmes. 
	 * 
	 * Pela dificuldade gerada ao trabalhar somente com a classe File, preenchi primeiramente uma 
	 * ArrayList com os dados deste arquivo e trabalhei com estes dados.
	 * Com relação a categoria (lançamento, acervo), criei um if que pergunta se a linha é igual a lançamento 
	 * ou categoria e com o uso do enum, eu seto o campo categoria corretamente.
	 * 
	 * 
	 * */
	
	
	
	
	//public static void main(String args[]){
	public static ArrayList<Filme> listaDeFilmes(){
	
		
	/*Declaração de variáveis */
		
		int i = 0;
		String leitura, /*dados,*/ categoriaFile;
		ArrayList<String> listaDeDados = new ArrayList<String>();
		ArrayList<Filme> listaDeFilmes = new ArrayList<Filme>();
		ArrayList<String> listaElenco = new ArrayList<String>();
		
		
	/*------------------------*/
		
		File dir = new File("importacao");
		File arq = new File(dir, "dvdsFilmes.txt");
				
			FileReader fileReader;
			try {
				fileReader = new FileReader(arq);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				while((leitura = bufferedReader.readLine()) != null){
						listaDeDados.add(leitura);
				}
				
				bufferedReader.close();
				
				while(i != listaDeDados.size()){
					Filme filme = new Filme();
					
					filme.setTitulo(listaDeDados.get(i++));
					//i++;
					filme.setCodigo(listaDeDados.get(i++));
					//i++;
					filme.setArea(listaDeDados.get(i++));
					//i++;
					filme.setSinopse(listaDeDados.get(i++));
					//i++;
					filme.setGenero(listaDeDados.get(i++));
					//i++;
					/*Inserindo o elenco como uma lista */
					
					listaElenco = new ArrayList<String>(Arrays.asList((listaDeDados.get(i++)).split(", ")));
					filme.setElenco(listaElenco);
					
					/*----------------------------------*/
					//i++;
					filme.setDirecao(listaDeDados.get(i++));
					//i++;
					filme.setAnoLancamento(listaDeDados.get(i++));
					//i++;
					filme.setCopias(Integer.parseInt(listaDeDados.get(i++)));
					//i++; //Pula o tipo Filme ou DVD 
					i++; //inicio do tratamento de categoria
					categoriaFile = listaDeDados.get(i++);
					if(categoriaFile.toLowerCase().equals("lançamento")){
						filme.setCategoria(CategoriaDVD.Lancamento);
					}else if(categoriaFile.toLowerCase().equals("acervo")){
						filme.setCategoria(CategoriaDVD.Acervo);
					}
					//i++;
					listaDeFilmes.add(filme);
					i++; 
				}
		
			}
			
			catch(IOException e){
				e.printStackTrace();				
			}
			
		return listaDeFilmes;
		
	}

}
