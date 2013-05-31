package model;

public class DVD {

	public enum Categoria{
		Acervo, Lancamento;
	}
	
	protected String titulo;
	protected String codigo;
	protected String area;
	protected String genero;
	protected String anoLancamento;
	protected Categoria categoria;
	protected int copias;
	
	public DVD() {
	}
		
	public DVD(String titulo, String codigo, String area, String genero,
			String anoLancamento, Categoria categoria, int copias) {
		super();
		this.titulo = titulo;
		this.codigo = codigo;
		this.area = area;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.categoria = categoria;
		this.copias = copias;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getAnoLancamento() {
		return anoLancamento;
	}

	public void setAnoLancamento(String anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public String getCategoriaAsString() {
		switch (this.categoria) {
		case Acervo: return "Acervo";
		case Lancamento: 
		default: return "Lancamento";
		}
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}
	
	public int getDiasParaLocacao() {
		switch (this.categoria) {
		case Acervo: return 2;
		case Lancamento: 
		default: return 3;
		}
	}
}
