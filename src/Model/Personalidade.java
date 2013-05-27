package Model;

import java.util.ArrayList;

public class Personalidade {
	
	public static final String MASCULINO = "Masculino";
	public static final String FEMININO = "Feminino";
	
	public enum Sexo{
		Masculino, Feminino;
	}
		
	protected String codigo;
	protected String nome;
	protected Sexo sexo;
	protected ArrayList<String> filmes = new ArrayList<String>();
	
	public Personalidade() {
		// TODO Auto-generated constructor stub
	}
		
	public Personalidade(String codigo, String nome, Sexo sexo,
			ArrayList<String> filmes) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.sexo = sexo;
		this.filmes = filmes;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	

}
