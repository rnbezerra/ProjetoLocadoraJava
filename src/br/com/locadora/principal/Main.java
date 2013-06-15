package br.com.locadora.principal;

import java.util.HashMap;

public class Main {
		
	public static void main(String[] param) {
		//String testeString = " -a oi -b tudo -c bem -d com voce";
		HashMap<String, String> parameters = parseArrayToHashMap(param);
		
		System.out.println(parameters);
		//ControllerCliente.teste();
		//ControllerDVD.teste();
				
		/*
		KeyValueCollection collection = new KeyValueCollection();
		collection.addKeyValuesFromArray(param);
		if(collection.hasKey("comando")){			
			Consulta de DVD 
			 * -comando consultaDVD -p <palavra chave>
			 * Parâmetros opcionais:
			 *  -y <Ano do lançamento>
			 *  -g <Gênero>
			 *  -a <Área>
			 *  -t <Tipo de DVD>
			 *  -c <Categoria>
			 * 
			 
			if(collection.getValue("comando") == "consultaDVD"){
				
			}
			//Visualizar os detalhes do DVD
			//-comando selecionaDVD -c <código do DVD>
			else if(collection.getValue("comando") == "selecionaDVD"){
				
			}
			//Alugar DVD
			//-comando alugarDVD -d <código do DVD> -c <código do Cliente> -t <data do aluguel (Formato DD/MM/YYYY)> -v <valor pago>
			else if(collection.getValue("comando") == "aluguelDVD"){
				//verificar parametros obrigatórios
				if( collection.hasKey("d") && collection.hasKey("c") &&
					collection.hasKey("t") && collection.hasKey("v")){
					
					ControllerAluguel.realizaAluguel();
				}
				else invalidParameters();
			}
			//Devolver DVD
			//-comando devolverDVD -d <código do DVD> -c <código do Cliente> -t <data do aluguel (Formato DD/MM/YYYY)> -v <valor pago>
			else if(collection.getValue("comando") == "devolverDVD"){
				
			}
			//Consulta de Cliente
			//-comando consultaCliente -c <código do cliente>
			else if(collection.getValue("comando") == "consultaCliente"){
				
			}
			
		}
		*/
	}

	public static HashMap<String, String> parseArrayToHashMap(String[] param){
		HashMap<String, String> hashmap = new HashMap<String, String>(); 
		StringBuilder allParams = new StringBuilder();
		
		for(String p : param){
			allParams.append(p).append(":");
		}
		
		String[] allParamsArray = allParams.toString().split("-");
		
		for(String str : allParamsArray){		
			if(str.split(":").length >= 2){
				hashmap.put(str.split(":")[0], str.split(":")[1]);
			}
		}
		
		return hashmap;
	}
}

