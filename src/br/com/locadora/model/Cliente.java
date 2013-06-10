package br.com.locadora.model;

public class Cliente {

	public enum StatusCliente{
		Bronze, Prata, Ouro;
	}
	
	private String nome;
	private String codigo;
	private String cpf;
	private String endereco;
	private String cep;
	private String telefone;
	private double saldo;
	private HistoricoLocacaoCollection historicoLocacao;
	
	
	public Cliente() {
		this.historicoLocacao = new HistoricoLocacaoCollection();
	}
		
	public Cliente(String nome, String codigo, String cpf, String endereco,
			String cep, String telefone, double saldo,
			HistoricoLocacaoCollection historicoLocacao) {
		super();
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.setSaldo(saldo);
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

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public HistoricoLocacaoCollection getHistoricoLocacao() {
		return historicoLocacao;
	}

	public void setHistoricoLocacao(HistoricoLocacaoCollection historicoLocacao) {
		this.historicoLocacao = historicoLocacao;
	}

	/** Método para adição de um novo histórico de locações
	 * 	@param historicoLocacao HistoricoLocacao - Novo objeto do tipo HistoricoLocacao
	 * 	@return void*/
	public void addHistoricoLocacao(HistoricoLocacao historicoLocacao) {
		this.historicoLocacao.add(historicoLocacao);
	}
	/** Metodo para retorno da categoria de acordo com o 
	 * número de locações já realizadas. Esse método utiliza o número
	 * de elementos no array do tipo HistoricoLocacao dentro dessa Classe.  
	 * 
	 */
	public String getStatusAsString(){
		if(this.historicoLocacao.size() < 5) return StatusCliente.Bronze.toString().toLowerCase();
		else if(this.historicoLocacao.size() < 10) return StatusCliente.Prata.toString().toLowerCase();
		else return StatusCliente.Ouro.toString().toLowerCase();
	}
	
	public StatusCliente getStatus(){
		if(this.historicoLocacao.size() < 5) return StatusCliente.Bronze;
		else if(this.historicoLocacao.size() < 10) return StatusCliente.Prata;
		else return StatusCliente.Ouro;		
	}

}
