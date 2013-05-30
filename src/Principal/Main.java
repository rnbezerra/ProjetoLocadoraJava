package Principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Controller.ControllerAluguel;
import Model.AluguelSerializable;
import Model.Cliente;
import ProjectUtils.KeyValue;
import ProjectUtils.KeyValueCollection;




public class Main {
	//Comentario Ramon Java Feelings
	// Comentario teste Iago

	/**
	 * @param args
	 */
	public static void main(String[] param) {
		
		KeyValueCollection collection = new KeyValueCollection();
		collection.addKeyValuesFromArray(param);
		if(collection.hasKey("comando")){
			if(collection.getValue("comando") == "aluguelDVD"){
				// TODO verificar parametros obrigatórios
				ControllerAluguel.realizaAluguel();
			}
		}
		
//		testeParametros();
		
//		AluguelSerializable advd = new AluguelSerializable("002100", "01245", "12/04/2013", 12.45);
//		testeSerializacao(advd);
//		testeDeserializacao(String.format("ALUGUEL\\ALUGUEL_%s_%s.ser", advd.getCodigoCliente(), advd.getCodigoDVD()));
		
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

