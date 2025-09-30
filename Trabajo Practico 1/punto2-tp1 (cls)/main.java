import java.util.Scanner;

public class main{
	public static void main(String[] args){
		cls limpiarPantalla = new cls(); // Solo Windows
		Scanner scan = new Scanner(System.in);
		var articulo = new producto("Notebook",1500.0, 20);
		boolean band = true;
		do{
			limpiarPantalla.clearScreen();
			System.out.println(">_Inventario actual");
			articulo.tostring();
			String opc = mostrarMenu();
			switch (opc){
				case "1":
					System.out.print("Cantidad a vender: ");
					int cant = scan.nextInt();
					double montog = articulo.vender(cant);
					System.out.println("Importe: "+montog);
	
					break;
				case "2":
					System.out.print("Cantidad a reponer: ");
					cant = scan.nextInt();
					articulo.reponer(cant);
					break;
				case "3":
					System.out.println("Saliendo");
					band = false;
					break;
				default:
					System.out.println("Valores incorrectos.");
	
			}
		} while(band);
		
	}

	public static String mostrarMenu(){
		Scanner scan = new Scanner(System.in);
		/* MENU */
		System.out.println("  [1] Vender\n  [2] Reponer\n  [3] Salir");
		System.out.print(">_Elija una opcion: ");
		String numero = scan.nextLine();
		return numero;
	}
}