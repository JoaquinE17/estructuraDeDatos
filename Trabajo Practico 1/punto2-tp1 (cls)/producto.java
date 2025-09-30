public class producto{
	String nombre;
	double precio;
	int stock;

	public producto(){
		this.nombre = "Desconocido";
		this.precio = 0.0;
		this.stock = 0;
	}

	public producto(String nombre, double precio,int stock){
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}

	public double vender(int cantidad){
		if (this.stock>=cantidad){
			this.stock -= cantidad;
			double montoTotal = cantidad*this.precio;
			return montoTotal;
		}
		System.out.println("Sin stock.");
		return 0.0;
	}

	public void reponer(int cantidad){
		System.out.println("Stock repuesto.");
		this.stock += cantidad; 
	}

	public void tostring(){
		System.out.println("\t* "+nombre+" | $ "+precio+" | "+stock+" Productos");
	}

}