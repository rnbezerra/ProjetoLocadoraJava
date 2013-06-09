package br.com.locadora.dataIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.locadora.model.AluguelSerializable;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.DVD;

public class Serializer<E> {

	private final String PATH = "SERIALIZADO";
	private E object;
	private Class<?> classtype;
	
	/*
	#### METODOS PÚBLICOS ####
	*/
	
	protected Serializer<E> using(E object){
		this.object = object;
		classtype = object.getClass();
		return this;
	}
	
	protected E getObject(){
		return object;
	}
	
	protected boolean salvarArquivo(String filename) {
		String classname = classtype.getSimpleName().toUpperCase();
		
		try {
			if(!new File(PATH).exists()){
				if(!new File(PATH).mkdir()) throw new IOException();
			}
			
			filename = String.format("%s\\%s_%s.quack", PATH, classname, filename);
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			
			objectOutputStream.writeObject(object);
			
			objectOutputStream.close();
			fileOutputStream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return true;
	}
	
	protected boolean carregarArquivo(String filename) {
		String classname = classtype.getSimpleName().toUpperCase();
		
		try {
			if(!new File(PATH).exists()){
				new File(PATH).mkdir();
				throw new IOException();
			}
			
			filename = String.format("%s\\%s_%s.quack", PATH, classname, filename);
					
			FileInputStream inputStream = new FileInputStream(filename);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			//object = object.getClass().cast(objectInputStream.readObject());
			object = (E) objectInputStream.readObject();
			//AluguelSerializable a = (AluguelSerializable) objectInputStream.readObject();
			objectInputStream.close();
			inputStream.close();
			
			return true;
			
		} catch (IOException i) {
			System.err.println("Erro na leitura do arquivo.");
			//i.printStackTrace();
			return false;
			
		}catch (ClassNotFoundException c) {
			System.err.println("Classe Não encontrada");
			//c.printStackTrace();
			return false;
		}
	}
	
	/*
	#### METODOS PRIVADOS ####
	*/
}
