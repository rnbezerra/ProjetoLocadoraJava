package Principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Model.AluguelDvd;
import ProjectUtils.KeyValue;
import ProjectUtils.KeyValueCollection;

public class Main {
	//Comentario Ramon Java Feelings

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testeParametros();
		
		AluguelDvd advd = new AluguelDvd("002100", "01245", "12/04/2013", 12.45);
		testeSerializacao(advd);
		testeDeserializacao();
	}

	private static void testeSerializacao(AluguelDvd advd) {
		try{
			FileOutputStream fileOutputStream = new FileOutputStream("aluguel.ser");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(advd);
			objectOutputStream.close();
			fileOutputStream.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	private static void testeDeserializacao() {
		AluguelDvd aluguelDvd = new AluguelDvd();
		try {
			
			FileInputStream inputStream = new FileInputStream("aluguel.ser");
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
		System.out.println("Data de Aluguel: " + aluguelDvd.getDataAluguel());
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
