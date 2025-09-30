public class Negocio{
	/* Atributos */
	String producto;
	double precio;

	public Negocio(String producto, double precio){
		this.producto = producto;
		this.precio = precio;
	}

	public void mostrar(){
		System.out.println("Producto: "+producto+" - Precio: "+precio);
	}

	double getPrecio(){
		return precio;
	}

	double descuento(double precio){
		return precio-=precio*0.15;
	}

	double promedio(Negocio[] arreglo){
		double sumaPrecios = 0;
		int cantidadProductos = arreglo.length;
		for(Negocio precioUnitario : arreglo)
			sumaPrecios += precioUnitario.getPrecio();
		return sumaPrecios/cantidadProductos; 
	}
}