import java.util.Scanner;

public class Principal {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Stack<Evento> pilaEventos = new Stack<>();
		boolean banderaSalir = false;
		while(!banderaSalir){
			LimpiarPantalla.limpiar();
			Evento evento = new Evento();
			switch (menuEleccion()) {
				case "1":
					cargarEvento(evento);
					ManipularEvento.registrarEvento(pilaEventos, evento);
					scan.nextLine();
					break;
				case "2":
					System.out.print("Inserte tipo de evento a eliminar: ");
					String tipo = tipoElegido();
					ManipularEvento.eliminarEventosDeTipo(pilaEventos, tipo);					
					scan.nextLine();
					break;
				case "3":
					System.out.print("Inserte codigo a buscar: ");
					String codigo = scan.nextLine();
					System.out.println(ManipularEvento.buscarEventosPorCodigo(pilaEventos, codigo));
					scan.nextLine();
					break;
				case "4":
					System.out.print("La cantidad de eventos 'ERROR' es: ");
					System.out.println(ManipularEvento.contarErrores(pilaEventos));
					scan.nextLine();
					break;
				case "5":
					System.out.println(pilaEventos);
					scan.nextLine();
					break;
				case "q":
					System.out.println("* Saliendo del programa.");
					banderaSalir = true;
					break;
				default:
					System.out.println("* El valor ingresado es invalido.");
					scan.nextLine();
			}

		}
	}
	public static String menu(){
		return "MENU:\n [1] Registrar evento\n"+
		" [2] Eliminar eventos de tipo\n"+
		" [3] Buscar evento por codigo\n"+
		" [4] Contar eventos de tipo error\n"+
		" [5] Ver contenido de la pila\n"+
		" [q] Salir";
	}
	public static String menuEleccion(){
		System.out.println(menu());
		System.out.print("Eleccion: ");
		return scan.nextLine();
	}
	public static void cargarEvento(Evento evento){
		evento.setTipo(tipoElegido());
		System.out.print("Ingrese un descripcion: ");
		evento.setDescripcion(scan.nextLine());
		System.out.print("Ingrese codigo: ");
		evento.setCodigo(scan.nextLine());
	}
	public static String tipoElegido(){
		System.out.print(" Tipo de evento\n  1.INFO\n  2.ADVERTENCIA\n  3.ERROR\n  q.CANCELAR OPERACION\n Eleccion: ");
        String opcion = scan.nextLine();
        switch (opcion) {
            case "1":
                return "INFO";
            case "2":
                return "ADVERTENCIA";
            case "3":
                return "ERROR";
            case "q":
            	System.out.println("* Operacion cancelada.");
            	return null;
            default:
            	System.out.println("* Opcion incorrecta.");
            	return "INFO";
        }
	}
}