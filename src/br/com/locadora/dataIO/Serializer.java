package br.com.locadora.dataIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer<E> {

	private final String PATH = "SERIALIZADO";
	private E object;
	private Class<?> classType;

	/*
	#### METODOS PÚBLICOS ####
	*/
	
	protected Serializer<E> using(E object){
		this.object = object;
		classType = object.getClass();
		return this;
	}
	
	protected E getObject(){
		return object;
	}
	
	protected String getFileName(String filename) {
		String classname = classType.getSimpleName().toUpperCase();
		return String.format("%s\\%s_%s.quack", PATH, classname, filename); 
	}
	
	protected boolean saveFileWithName(String filename) {
		
		try {
			if(!dirExists()){
				if(!new File(PATH).mkdir()) throw new IOException();
			}
			
			filename = getFileName(filename);
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
	
	protected Serializer<E> loadFileWithName(String filename) {
		String classname = classType.getSimpleName().toUpperCase();
		
		try {
			if(!dirExists() || !new File(getFileName(filename)).exists()){
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
			
		} catch (IOException i) {			
		} catch (ClassNotFoundException c) {
		}
		
		return this;
	}
	
	protected boolean dirExists() {
		return new File(PATH).exists();
	}
	
}
