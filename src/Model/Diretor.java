package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Diretor extends Personalidade {

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
