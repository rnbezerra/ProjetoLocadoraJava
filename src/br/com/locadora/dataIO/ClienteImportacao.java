package br.com.locadora.dataIO;

import java.io.*;


import java.util.*;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.HistoricoLocacao;


public class ClienteImportacao extends Serializer<ArrayList<Cliente>> {
	/*
	 * A classe ClienteImportacao � respons�vel por obter os dados dos clientes que estao dentro
	 * do aquivo clientes.txt na pasta importacao, e retornar uma ArrayList contendo todos os 
	 * dados desses clientes. 
	 * 
	 * Pela dificuldade gerada ao trabalhar somente com a classe File,
	 * preenchi primeiramente uma ArrayList com os dados deste arquivo e trabalhei com estes dados.
	 * Com rela��o ao historico de pedidos, criei um novo while para que assim seja possivel tratar
	 * os atributos entre # e ## quebra-los e preencher o historico de loca��es utilizando os metodos
	 * criados na classe HistoricoLocacao e HistoricoLocacaoCollection.
	 * 
	 * 
	 * */
	
	private static final String FILENAME = "Cliente";
	
	/**
	 * Este m�todo retorna um nova inst�ncia da classe ClienteImportacao
	 * @return new ClienteImportacao();
	 */
	private static ClienteImportacao getInstance() {
		return new ClienteImportacao();
	}
	
	public static void salvarClientes(ArrayList<Cliente> lista) {
		getInstance().using(lista).saveFileWithName(FILENAME);
	}
	
	
	public static ArrayList<Cliente> listaDeClientes(){

		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		
		/*VERIFICA SE J� EXISTE UM ARQUIVO SERIALIZADO*/
		if(getInstance().using(new ArrayList<Cliente>()).dirExists()){
			if(!(listaDeClientes = getInstance().using(new ArrayList<Cliente>()).loadFileWithName(FILENAME).getObject()).isEmpty()){
				return listaDeClientes; 
			}
		}
		
		/*Declara��o de Variaveis*/
		
		int i=0;
		String leitura;
		
		ArrayList<String> listaDeDados = new ArrayList<String>();
		
		
		String[] historico;
		/*----------------------*/
		
		
		File dir = new File("importacao");
		File arq = new File(dir, "clientes.txt");
		
		
		
			try {
				FileReader fileReader = new FileReader(arq);
					
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				
				while((leitura = bufferedReader.readLine()) != null){
					listaDeDados.add(leitura);
					}	
				
				bufferedReader.close();
				
				while( i < listaDeDados.size()){
				
					Cliente c = new Cliente();
					
					c.setNome(listaDeDados.get(i++));
					
					c.setCodigo(listaDeDados.get(i++));
					
					c.setCpf(listaDeDados.get(i++));
				
					c.setEndereco(listaDeDados.get(i++));
				
					c.setCep(listaDeDados.get(i++));
				
					c.setTelefone(listaDeDados.get(i++));
				
					i++;//Existe um campo com o tipo de usuario Bronze etc, nao existe set pra isso, entao pulei
					
					if((listaDeDados.get(i++)).equals("#")){
				
						while(!(listaDeDados.get(i).equals("##"))){
							HistoricoLocacao hisLoc = new HistoricoLocacao();
							historico = listaDeDados.get(i++).split(" ");
							hisLoc.setCodigoDVD(historico[0]);
							hisLoc.setDataLocacao(historico[1]);
							if((historico.length) > 2){//Se o historico tem tamanho 3, significa que h� registro de devolu��o
								hisLoc.setDataDevolucao(historico[2]);
								hisLoc.setDevolvido(true);
							}else{
								hisLoc.setDevolvido(false);
							}
							c.addHistoricoLocacao(hisLoc);							
				
						}
					}
					
					listaDeClientes.add(c);
					i++;
					
				}
				
			}catch(Exception e){
				
				e.getStackTrace();
				
			 }
			
			return listaDeClientes;

	}

}