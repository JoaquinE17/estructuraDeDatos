import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		SumaTotal precioTotal = new SumaTotal();
		System.out.print("# Cuantos productos quiere ingresar: ");
		int cantidad =  scan.nextInt();
		scan.nextLine();
		Negocio[] limpieza = new Negocio[cantidad];
		Negocio[] precioDescuento = new Negocio[cantidad];
		System.out.println("# La cantidad de productos a agregar es: "+limpieza.length);
		for (int i=0; i<cantidad; i++){

			System.out.print("Ingrese nombre del producto: ");
			String producto = scan.nextLine();
			System.out.print("Ingrese precio del producto: ");
			double precio = scan.nextDouble();
			scan.nextLine();
			precioTotal.setSumaFinal(precio);
			limpieza[i] = new Negocio(producto,precio);

			double descuentoAplicado = limpieza[i].descuento(limpieza[i].getPrecio());
			precioDescuento[i]=new Negocio(producto,descuentoAplicado);
		}

		System.out.println("\n# Productos de la tienda:");
		for(Negocio n : limpieza)
			n.mostrar();

		System.out.println("\n# La suma total de todos los precios es: "+precioTotal.getSumaFinal());

		System.out.println("\n# Productos de la tienda (descuento aplicados):");
		// Antes de mostrar pedir al usuario que ingrese un valor pivot
		for(Negocio n : precioDescuento)
			n.mostrar(); // Si n supera pivot mostrarlo

		System.out.println("\n# Promedio de los productos de la tienda:"+limpieza[0].promedio(limpieza));

		System.out.print("\n# Inserte un precio referencia: ");
		double precioReferencia = scan.nextDouble();
		for(Negocio n : limpieza){
			if (n.getPrecio()<precioReferencia)
				n.mostrar();
		}
	}


	
}// Solo presentar los archivos '.java'