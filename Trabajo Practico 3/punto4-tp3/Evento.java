public class Evento {

	private String tipo;
	private String descripcion;
	private String codigo;

	Evento(){
		this.tipo = null;
		this.descripcion = null;
		this.codigo = null;
	}

	// Getters
	public String getDescripcion() {
	    return descripcion;
	}
	public String getTipo() {
	    return tipo;
	}
	public String getCodigo() {
	    return codigo;
	}

	// Setters
	public void setTipo(String tipo) {
	    this.tipo = tipo;
	}
	public void setDescripcion(String descripcion) {
	    this.descripcion = descripcion;
	}
	public void setCodigo(String codigo) {
	    this.codigo = codigo;
	}

		@Override
	public String toString() {
		return "Evento [Tipo=" + tipo + ", descripcion=" + descripcion + ", codigo=" + codigo + "]";
	}
}