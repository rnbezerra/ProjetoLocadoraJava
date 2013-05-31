package dataIO;

import java.io.*;

import model.Cliente;
import model.HistoricoLocacao;

import java.util.*;


public class ClienteImportacao {
	
	
	
//	
//	public static void dadosClientes(){
//	 File dir = new File("importacao");
//	 File arq = new File(dir, "clientes.txt");
//	
//	
//		try {
//			FileReader fileReader = new FileReader(arq);
//		
//			ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
//			
//			BufferedReader bufferedReader = new BufferedReader(fileReader);
//			
//			String leitura = bufferedReader.readLine();
//			
//			
//			Cliente lc = new Cliente();
//			
////			lc.setNome(nome);
////			lc.setCodigo(codigo);
////			lc.setCpf(cpf);
////			lc.setEndereco(endereco);
////			lc.setCep(cep);
////			lc.setTelefone(telefone);
////			lc.setHistoricoLocacao(historicoLocacao);
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}

	
	
	public static void main(String[] args) {
		
		/*Declaração de Variaveis*/
		
		int i=0;
		String leitura;
		
		ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
		ArrayList<String> listaDeDados = new ArrayList<String>();
		
		String Dados;
		String[] Historico;
		/*----------------------*/
		
		
		File dir = new File("importacao");
		File arq = new File(dir, "clientesbkp.txt");
		Cliente c = new Cliente();
		HistoricoLocacao hisLoc = new HistoricoLocacao();
		
			try {
				FileReader fileReader = new FileReader(arq);
					
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				//leitura = bufferedReader.readLine();
				
				while((leitura = bufferedReader.readLine()) != null){
					listaDeDados.add(leitura);
					}	
						
				while((Dados = listaDeDados.get(i))!= null){
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
							Historico = listaDeDados.get(i).split(" ");
							hisLoc.setCodigoDVD(Historico[0]);
							hisLoc.setDataLocacao(Historico[1]);
							hisLoc.setDataDevolucao(Historico[2]);
							c.addHistoricoLocacao(hisLoc);							
							i++;
						}
					}
					i++;										
				}
				
			}					
			catch(Exception e){
				e.getStackTrace();}
			
			System.out.println(c.getHistoricoLocacao().get(3).getCodigoDVD());

	}
}