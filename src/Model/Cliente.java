package Model;

import java.util.ArrayList;

public class Cliente {

	public static final String BRONZE = "Bronze";
	public static final String PRATA = "Prata";
	public static final String OURO = "Ouro";
	
	private String nome;
	private String codigo;
	private String cpf;
	private String endereco;
	private String cep;
	private String telefone;
	private ArrayList<HistoricoLocacao> historicoLocacao;
	
	
	public Cliente() {
	}
		
	public Cliente(String nome, String codigo, String cpf, String endereco,
			String cep, String telefone) {
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
	}
	
	public Cliente(String nome, String codigo, String cpf, String endereco,
			String cep, String telefone,
			ArrayList<HistoricoLocacao> historicoLocacao) {
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.historicoLocacao = historicoLocacao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ArrayList<HistoricoLocacao> getHistoricoLocacao() {
		return historicoLocacao;
	}

	public void setHistoricoLocacao(ArrayList<HistoricoLocacao> historicoLocacao) {
		this.historicoLocacao = historicoLocacao;
	}

	public void addHistoricoLocacao(HistoricoLocacao historicoLocacao) {
		this.historicoLocacao.add(historicoLocacao);
	}
	
	public String getCategoria(){
		if(this.historicoLocacao.size() < 5) return BRONZE;
		else if(this.historicoLocacao.size() < 10) return PRATA;
		else return OURO;
		
	}

}
