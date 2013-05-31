package dataIO;

import java.io.*;

import model.Cliente;
import model.HistoricoLocacao;

import java.util.*;


public class ClienteImportacao {
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
	
	public static ArrayList<Cliente> clienteImportacao(){
		
		/*Declara��o de Variaveis*/
		
		int i=0;
		String leitura;
		
		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		ArrayList<String> listaDeDados = new ArrayList<String>();
		
		String Dados;
		String[] Historico;
		/*----------------------*/
		
		
		File dir = new File("importacao");
		File arq = new File(dir, "clientes.txt");
		
		
		
			try {
				FileReader fileReader = new FileReader(arq);
					
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				//leitura = bufferedReader.readLine();
				
				while((leitura = bufferedReader.readLine()) != null){
					listaDeDados.add(leitura);
					}	
				
				bufferedReader.close();
				
				while((Dados = listaDeDados.get(i))!= null){
					Cliente c = new Cliente();
					
					c.setNome(Dados);
					i++;
					c.setCodigo(listaDeDados.get(i));
					i++;
					c.setCpf(listaDeDados.get(i));
					i++;
					c.setEndereco(listaDeDados.get(i));
					i++;
					c.setCep(listaDeDados.get(i));
					i++;
					c.setTelefone(listaDeDados.get(i));
					i++;
					i++;//Existe um campo com o tipo de usuario Bronze etc, nao existe set pra isso, entao pulei
					
					if((Dados = listaDeDados.get(i)).equals("#")){
						i++;
						while(!(listaDeDados.get(i).equals("##"))){
							HistoricoLocacao hisLoc = new HistoricoLocacao();
							Historico = listaDeDados.get(i).split(" ");
							hisLoc.setCodigoDVD(Historico[0]);
							hisLoc.setDataLocacao(Historico[1]);
							hisLoc.setDataDevolucao(Historico[2]);
							c.addHistoricoLocacao(hisLoc);							
							i++;
						}
					}
					
					listaDeClientes.add(c);
					i++;
					
				}
				
			}					
			catch(Exception e){
				e.getStackTrace();}
			
			return listaDeClientes;

	}

// Uma main de quebra pra teste :P
//	public static void main(String args[]){ 
//		
//		clienteImportacao();
//		
//		
//		
//	}


}