package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

import Model.Personalidade.Sexo;

public class Diretor extends Personalidade {

	public Diretor() {
		super();
	}
	
	public Diretor(String codigo, String nome, Sexo sexo,
			ArrayList<String> filmes) {
		super(codigo, nome, sexo, filmes);
	}	
	
	public ArrayList<String> getFilmesDirigidos() {
		return super.filmes;
	}
	
	public void setFilmesDirigidos(ArrayList<String> filmes) {
		super.filmes = filmes;
	}
	
	public void addFilmeDirigido(String codigo) {
		super.filmes.add(codigo);
	}
}
