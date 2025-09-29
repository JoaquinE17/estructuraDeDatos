class Alerta {
	private String ciudad;
	private String tipo;
	private int nivelDeSerevidad;

	public Alerta() {
		this.ciudad = null;
		this.tipo = null;
		this.nivelDeSerevidad = 0;
	}

	public Alerta(String ciudad,String tipo,int nivelDeSerevidad) {
		this.ciudad = ciudad;
		this.tipo = tipo;
		this.nivelDeSerevidad = nivelDeSerevidad;
	}

	public String getCiudad() {
	    return ciudad;
	}
	public String getTipo() {
	    return tipo;
	}
	public int getNivelDeSerevidad() {
	    return nivelDeSerevidad;
	}

	@Override
	public String toString() {
	    return "[Ciudad: "+ciudad+
	    ", Tipo de alerta: "+tipo+
	    ", Nivel de Serevidad: "+nivelDeSerevidad+"]";
	}
}