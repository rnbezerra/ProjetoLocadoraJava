package Model;

public class DVD {

	protected String titulo;
	protected String codigo;
	protected String area;
	protected String genero;
	protected String anoLancamento;
	protected int copias;
	
	public DVD() {
	}

	public DVD(String titulo, String codigo, String area, String genero,
			String anoLancamento, int copias) {
		this.titulo = titulo;
		this.codigo = codigo;
		this.area = area;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
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

	public int getCopias() {
		return copias;
	}

	public void setCopias(int copias) {
		this.copias = copias;
	}
		
}
