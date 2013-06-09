package br.com.locadora.principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import br.com.locadora.controller.ControllerAluguel;
import br.com.locadora.dataIO.Serializer;
import br.com.locadora.model.AluguelSerializable;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;
import br.com.locadora.model.Filme;
import br.com.locadora.model.HistoricoLocacao;
import br.com.locadora.model.Show;
import br.com.locadora.model.DVD.CategoriaDVD;
import br.com.locadora.model.DVD.TipoDVD;
import br.com.locadora.utils.KeyValue;
import br.com.locadora.utils.KeyValueCollection;





public class Main {
	
	
	public static void main(String[] param) {

		ControllerAluguel.teste();
		
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


	private static void invalidParameters() {
		System.out.println("Parametros obrigarótios inválidos.");
	}

	private static void testeSerializacao(AluguelSerializable advd) {
		try{
			String filename = String.format("ALUGUEL\\ALUGUEL_%s_%s.ser", advd.getCodigoCliente(), advd.getCodigoDVD());
			System.out.println(filename);
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(advd);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	private static void testeDeserializacao(String filename) {
		AluguelSerializable aluguelDvd = new AluguelSerializable();
		try {
			
			FileInputStream inputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//			aluguelDvd = (AluguelDvd) objectInputStream.readObject();
			aluguelDvd = aluguelDvd.getClass().cast(objectInputStream.readObject());
			
			objectInputStream.close();
			inputStream.close();
			
		} catch (IOException i) {
			i.printStackTrace();
			return;
			
		}catch (ClassNotFoundException c) {
			System.out.println("Classe Não encontrada");
			c.printStackTrace();
			return;
		}
		
		
		System.out.println("Objeto carregado...");
		System.out.println("Codigo Cliente: " + aluguelDvd.getCodigoCliente());
		System.out.println("Codigo DVD: " + aluguelDvd.getCodigoDVD());
		System.out.println("Data de Aluguel: " + aluguelDvd.getDataLocacao());
		System.out.println("Valor Pago: R$" + aluguelDvd.getValorPago());
		
	}

	private static void testeParametros() {
		String parametosTeste = " -a oi -b tudo -c bem -d com voce";
		
		KeyValueCollection collecton = new KeyValueCollection();
		collecton.addKeyValuesFromArray(parametosTeste.split(" "));
		
		for (KeyValue keyValue : collecton) {
			System.out.println(keyValue.getKeyValue());
		}
	}

}

