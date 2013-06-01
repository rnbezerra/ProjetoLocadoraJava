package model;

public class Cliente {

	public static final String BRONZE = "Bronze";
	public static final String PRATA = "Prata";
	public static final String OURO = "Ouro";
	
	public enum StatusCliente{
		Bronze, Prata, Ouro;
	}
	
	private String nome;
	private String codigo;
	private String cpf;
	private String endereco;
	private String cep;
	private String telefone;
	private HistoricoLocacaoCollection historicoLocacao;
	
	
	public Cliente() {
		this.historicoLocacao = new HistoricoLocacaoCollection();
	}
	
	/*
	 * Construtor
	 * */
	public Cliente(String nome, String codigo, String cpf, String endereco,
			String cep, String telefone) {
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.historicoLocacao = new HistoricoLocacaoCollection();
	}
	
	public Cliente(String nome, String codigo, String cpf, String endereco,
			String cep, String telefone,
			HistoricoLocacaoCollection historicoLocacao) {
		this.nome = nome;
		this.codigo = codigo;
		this.cpf = cpf;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.historicoLocacao = new HistoricoLocacaoCollection();
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

	public HistoricoLocacaoCollection getHistoricoLocacao() {
		return historicoLocacao;
	}

	public void setHistoricoLocacao(HistoricoLocacaoCollection historicoLocacao) {
		this.historicoLocacao = historicoLocacao;
	}

	/** M�todo para adi��o de um novo hist�rico de loca��es
	 * 	@param historicoLocacao HistoricoLocacao - Novo objeto do tipo HistoricoLocacao
	 * 	@return void*/
	public void addHistoricoLocacao(HistoricoLocacao historicoLocacao) {
		this.historicoLocacao.add(historicoLocacao);
	}
	/** Metodo para retorno da categoria de acordo com o 
	 * n�mero de loca��es j� realizadas. Esse m�todo utiliza o n�mero
	 * de elementos no array do tipo HistoricoLocacao dentro dessa Classe.  
	 * 
	 */
	public String getStatusAsString(){
		if(this.historicoLocacao.size() < 5) return BRONZE;
		else if(this.historicoLocacao.size() < 10) return PRATA;
		else return OURO;		
	}
	
	public StatusCliente getStatus(){
		if(this.historicoLocacao.size() < 5) return StatusCliente.Bronze;
		else if(this.historicoLocacao.size() < 10) return StatusCliente.Prata;
		else return StatusCliente.Ouro;		
	}

}
