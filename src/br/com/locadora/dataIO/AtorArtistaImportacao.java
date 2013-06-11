package br.com.locadora.dataIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

import br.com.locadora.model.Artista;
import br.com.locadora.model.Personalidade.Sexo;



public class AtorArtistaImportacao {

	public static ArrayList<Artista> listaDeAtoresArtistas(){
	//public static void main(String[] args) {
		
		ArrayList<Artista> listaDeArtistas = new ArrayList<Artista>();
		ArrayList<String> listaDeDados = new ArrayList<String>();
		ArrayList<String> listaDeFilmes = new ArrayList<String>();
		String[] linhaArtista;
		String leitura;
		int i=0;
		
		/*------------------------*/
		
		File dir = new File("importacao");
		File arq = new File(dir, "atorArtista.txt");	
		
		
		try{
		FileReader fileReader = new FileReader(arq);
				
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while((leitura = bufferedReader.readLine()) != null){
			listaDeDados.add(leitura);
		}
		
		bufferedReader.close();
		
		while(i < listaDeDados.size()){
			
			Artista artista = new Artista();
			
			linhaArtista = listaDeDados.get(i).split(";");
			artista.setCodigo(linhaArtista[0]);
			artista.setNome(linhaArtista[1]);
			artista.setNomeCompleto(linhaArtista[2]);
			
			//Definição do Sexo do diretor
			if(linhaArtista[3].toLowerCase().equals("masculino"))
				artista.setSexo(Sexo.Masculino);
			else if(linhaArtista[3].toLowerCase().equals("feminino"))
				artista.setSexo(Sexo.Feminino);
			
			artista.setDataNasc(linhaArtista[4]);
			
			//Popular Lista de Filmes como uma ArrayList
			listaDeFilmes = new ArrayList<String>(Arrays.asList((linhaArtista[5]).split(", ")));
			artista.setFilmes(listaDeFilmes);
			
			listaDeArtistas.add(artista);
			i++;
		}	
		}catch(IOException e){
			
			e.getStackTrace();
			
		}
		
		return listaDeArtistas;
	}

}
