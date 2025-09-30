import java.util.Scanner;
class Main{	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		//Busqueda buscar = new Busqueda();
		System.out.print("Introdusca la cantidad de componentes con las que va a trabajar: ");
		int cantidad = scan.nextInt();
		scan.nextLine();
		Componente[] productos = new Componente[cantidad];

		// Carga del arreglo ([.] Adicional: No permitir productos repetidos)
		for (int i=0;i<cantidad;i++){
			System.out.println("Producto: "+(i+1));
			productos[i] = new Componente();
			System.out.print("  Introdusca el codigo del producto: ");
			String code = scan.nextLine();
			productos[i].setCodigo(code);
			System.out.print("  Introdusca el nombre del producto: ");
			String name = scan.nextLine();
			productos[i].setNombre(name);
			System.out.print("  Introdusca el precio del producto: ");
			double price = scan.nextDouble();
			productos[i].setPrecio(price);
			System.out.print("  Introdusca el stock del producto: ");
			int stock = scan.nextInt();
			productos[i].setStock(stock);
			scan.nextLine();
		}
		System.out.println("* Lista de productos:");
		for (Componente n : productos){
			System.out.println(n);
		}

		// Actualizar Stock (sumar y restar)
		actualizarStock(productos,cantidad);
		System.out.println("* Lista de productos:");
		for (Componente n : productos){
			System.out.println(n);
		}

		// Stock total diponible
		System.out.println("\nEl stock total disponible es: "+stockDisponible(productos));

		// Recaudacion total
		System.out.println("\nLa recaudacion total, vediendose todos los productos, es: "+ventaTotal(productos));
		
		// Mostrar componente con el menor stock
		System.out.println("\nEl producto de menor stock disponible es: ");
		String codeStockMin = menorStock(productos);
		for (int i=0; i<cantidad; i++){
			if (productos[i].getCodigo().equals(codeStockMin)){
				System.out.println(" Producto: "+(i+1)+"\n  "+productos[i]);
				break;
			}
		}

		// Listar productos menor a un stock dado
		System.out.print("\nIntrodusca un valor de stock como referencia: ");
		int pivot = scan.nextInt();
		System.out.println(" Estos productos son los que requieren ser reabastecidos:");
		for (Componente n : productos){
			if (n.getStock()<pivot)
				System.out.println(n);
		}
	}
	
	public static void actualizarStock(Componente[] productos, int cantidad){
		Scanner scan = new Scanner(System.in);
		Busqueda buscar = new Busqueda();
		System.out.println("\nModificar Stock:");
		System.out.print(" Introdusca el codigo del producto: ");
		String codeModify = scan.nextLine();
		if (buscar.validarExistecia(codeModify,productos,cantidad)){
			System.out.print("  1.Aumentar\n  2.Reducir\n Seleccione una: ");
			try{
				int eleccion = scan.nextInt();
				switch(eleccion){
					case 1:
						System.out.print("Introdusca el Stock a aumentar: ");
						int sumarStock = scan.nextInt();
						productos[buscar.getPosicion()].setStock(sumarStock);
						break;
					case 2:
						System.out.print("Introdusca el Stock a reducir: ");
						int restarStock = scan.nextInt();
						productos[buscar.getPosicion()].setStock((restarStock*-1));
						break;
					default:
						System.out.println("Error: Valor ingresado incorrecto.");
				}
			}
			catch(Exception e){
				System.out.println("Error inesperado.");
			}
		}
		else 
			System.out.println("Producto no encontrado.");
	}

	public static int stockDisponible(Componente[] productos){
		int stockTotal=0;
		for (Componente n : productos){
			stockTotal += n.getStock();
		}
		return stockTotal;
	}

	public static double ventaTotal(Componente[] productos){
		int recaudacion = 0;
		for (Componente n : productos){
			recaudacion += (n.getStock() * n.getPrecio());// Convertir int a double para mayor presicion
		}
		return recaudacion;
	}

	public static String menorStock(Componente[] productos){
		int min = productos[0].getStock();
		String code = productos[0].getCodigo();
		for (Componente n : productos){
			if (n.getStock()<=min){
				min = n.getStock(); 
				code = n.getCodigo();
			}
		}
		return code;
	}
}