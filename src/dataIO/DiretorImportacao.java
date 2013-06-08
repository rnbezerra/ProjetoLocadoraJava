package dataIO;

import java.io.*;
import java.util.*;
import model.Diretor;
import model.Personalidade.*;


public class DiretorImportacao {
	
	/*
	 * A classe DiretorImportacao é responsável por obter os dados dos Diretores que estao dentro
	 * do aquivo diretor.txt na pasta importacao, e retornar uma ArrayList contendo todos os 
	 * dados dos Diretores. 
	 * 
	 * Pela dificuldade gerada ao trabalhar somente com a classe File, preenchi primeiramente uma 
	 * ArrayList com os dados deste arquivo e trabalhei com estes dados.
	 * Se fez necessário a utilização de outras ArrayLists para separar os campos e obter os filmes dirigidos 
	 * como uma arrayList e utiliza-la como parâmetro.
	 * 
	 * 
	 * */
	
	
	public static ArrayList<Diretor> listaDeDiretores(){
	//public static void main(String args[]){
		/*Declaração das variaveis*/
		
		ArrayList<Diretor> listaDeDiretores = new ArrayList<Diretor>();
		ArrayList<String> listaDeDados = new ArrayList<String>();
		ArrayList<String> listaDeFilmes = new ArrayList<String>();
		String[] linhaDiretor;
		String leitura;
		int i=0;
		
		/*------------------------*/
		
		File dir = new File("importacao");
		File arq = new File(dir, "diretor.txt");
		
				
		try{
			FileReader fileReader = new FileReader(arq);
				
			BufferedReader bufferedReader = new BufferedReader(fileReader);
					
			while((leitura = bufferedReader.readLine()) != null){
				listaDeDados.add(leitura);
			}			
			
			bufferedReader.close();
			
			while(i != listaDeDados.size()){
				
				Diretor diretor = new Diretor();
				
						
				linhaDiretor = listaDeDados.get(i).split(";");
				diretor.setCodigo(linhaDiretor[0]);
				diretor.setNome(linhaDiretor[1]);
				
				//Definição do Sexo do diretor
				if(linhaDiretor[2].toLowerCase().equals("masculino"))
					diretor.setSexo(Sexo.Masculino);
				else if(linhaDiretor[2].toLowerCase().equals("feminino"))
					diretor.setSexo(Sexo.Feminino);
				
				//Popular Lista de Filmes como uma ArrayList
				listaDeFilmes = new ArrayList<String>(Arrays.asList((linhaDiretor[3]).split(", ")));
				diretor.setFilmesDirigidos(listaDeFilmes);
				
				listaDeDiretores.add(diretor);
				i++;
			}
			
		}catch(IOException e){
			
				e.getStackTrace();
			
			}
		
		return listaDeDiretores;	
	}
	
	
	
}	
	