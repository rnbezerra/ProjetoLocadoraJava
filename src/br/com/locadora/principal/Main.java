package br.com.locadora.principal;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;

import br.com.locadora.controller.ControllerAluguel;
import br.com.locadora.controller.ControllerCliente;
import br.com.locadora.controller.ControllerDVD;
import br.com.locadora.dataIO.ClienteImportacao;
import br.com.locadora.dataIO.Serializer;
import br.com.locadora.model.Cliente;

public class Main {
		
	public static void main(String[] args) {

		HashMap<String, String> parameters = parseArrayToHashMap(args);
		
		if(parameters.containsKey("comando")){			
			/*
			Consulta de DVD 
			 * -comando consultaDVD -p <palavra chave>
			 * Parâmetros opcionais:
			 *  -y <Ano do lançamento>
			 *  -g <Gênero>
			 *  -a <Área>
			 *  -t <Tipo de DVD>
			 *  -c <Categoria>
			 * 
			*/ 
			if(parameters.get("comando").equalsIgnoreCase("consultaDVD")){
				ControllerDVD.listaDVDs(parameters);
			}
			//Visualizar os detalhes do DVD
			//-comando selecionaDVD -c <código do DVD>
			else if(parameters.get("comando").equalsIgnoreCase("selecionaDVD")){
				ControllerDVD.realizarBusca(parameters.get("c"));
			}
			//Alugar DVD
			//-comando alugarDVD -d <código do DVD> -c <código do Cliente> -t <data do aluguel (Formato DD/MM/YYYY)> -v <valor pago>
			else if(parameters.get("comando").equalsIgnoreCase("alugarDVD")){
				//verificar parametros obrigatórios
				ControllerAluguel.realizaAluguel(parameters);
			}
			//Devolver DVD
			//-comando devolverDVD -d <código do DVD> -c <código do Cliente> -t <data do aluguel (Formato DD/MM/YYYY)> -v <valor pago>
			else if(parameters.get("comando").equalsIgnoreCase("devolverDVD")){
				ControllerAluguel.realizarDevolucao(parameters);
			}
			//Consulta de Cliente
			//-comando consultaCliente -c <código do cliente>
			else if(parameters.get("comando").equalsIgnoreCase("consultaCliente")){
				ControllerCliente.realizarBusca(parameters.get("c"));
			}
			
		}
		
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

