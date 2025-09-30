class Componente{
	private String codigo;
	private String nombre;
	private double precioUnitario;
	private int cantidadStock;
	
	Componente(){
		this.codigo = null;
		this.nombre = null;
		this.precioUnitario = 0.0;
		this.cantidadStock = 0;
	}
	
	void setCodigo(String codigo){
		this.codigo = codigo;
	}

	void setNombre(String nombre){
		this.nombre = nombre;
	}

	void setPrecio(double precio){
		this.precioUnitario = precio;
	}

	void setStock(int stockPlus){
		this.cantidadStock += stockPlus;
	}

	String getCodigo(){
		return this.codigo;
	}

	int getStock(){
		return this.cantidadStock;
	}

	double getPrecio(){
		return this.precioUnitario;
	}

	public String toString(){
		return ("  {Codigo: "+codigo+
			", Nombre: "+nombre+
			", Precio: "+precioUnitario+
			", Stock: "+cantidadStock+"}");
	}
}