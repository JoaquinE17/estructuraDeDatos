import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Principal{
	public static Scanner scan = new Scanner(System.in);
	public static Random random = new Random();

	public static String[] nombres = {"ana","juan","maria","diego","leo"};
	public static int[] pisos = {4,4,3,4,4};
	public static boolean[] entregado = {true,false};
	public static int indice = -1; // Utilizacion: cargaDatosEntrega()
	public static ArrayList<String> opciones = new ArrayList<>();

	public static void main(String[] args) {
		Stack<Entrega> pila = new Stack<Entrega>();
		// Menu
		boolean banderaSalir = false;
		while (!banderaSalir) {
			Entrega nuevaEntrega = new Entrega();
			LimpiarPantalla.limpiar();
			String eleccion = opcionElegida();
			if (eleccion.equals("1")){
				cargarDatosEntrega(nuevaEntrega);
				nuevaEntrega.cargarEntrega(pila, nuevaEntrega);
				System.out.print("* Datos cargados: "+nuevaEntrega);
				scan.nextLine();
			}
			else{
				if (pila.empty() && opciones.contains(eleccion)){ // [true]: Controla que no muestre el mensaje con una opcion invalida (>5 ó !=q)
					System.out.println("* La pila esta vacia.");
					scan.nextLine();
				}
				else{
					switch (eleccion) {
						case "2":
							System.out.print("Inserte nombre del destinatario: ");
							String destinatario = scan.nextLine();
							nuevaEntrega.marcarComoEntregado(pila, destinatario);
							scan.nextLine();
							break;
						case "3":
							System.out.print("Inserte numero de piso: ");
							int piso = scan.nextInt();
							scan.nextLine();
							nuevaEntrega.getPendientePorPiso(pila,piso);
							scan.nextLine();
							break;
						case "4":
							nuevaEntrega.vaciarEntregas(pila);
							scan.nextLine();
							break;
						case "5":
							System.out.println(pila);
							scan.nextLine();
							break;
						case "q":
							System.out.println("Saliendo del programa...");
							banderaSalir = true;
							break;		
						default:
							System.out.println("El valor ingresado no corresponde a ninguna de las opciones.");
							scan.nextLine();
					}
				}
			}
		}
	}
	// Interaccion con el usuario
	public static String mostrarMenu(){
		return "MENU:\n"+
		" [1] Agregar nueva entrega\n"+ 
		" [2] Marcar elementos entregados\n"+
		" [3] Obtener pendientes por piso\n"+
		" [4] Quitar elementos entregados\n"+
		" [5] Ver contenido de la pila\n"+
		" [q] Finalizar programa";
	}
	public static String opcionElegida(){
			System.out.println(mostrarMenu());
			System.out.print("Opcion elegida: ");
			return (scan.nextLine());
	}
	// Carga de datos
	public static void cargarDatosEntrega(Entrega nuevaEntrega){
		indice++;
		if (indice<nombres.length){
			nuevaEntrega.setDestinatario(nombres[indice]);
			nuevaEntrega.setPiso(pisos[indice]);
			nuevaEntrega.setFueEntregado(entregado[random.nextInt(2)]);
		}
		else{
			cargaManualDatos(nuevaEntrega);
		}
	}
	public static void cargaManualDatos(Entrega nuevaEntrega){
		System.out.print("Inserte nombre del destinatario: ");
		nuevaEntrega.setDestinatario(scan.nextLine());
		System.out.print("Inserte numero de piso: ");
		nuevaEntrega.setPiso(scan.nextInt());
		scan.nextLine();
		System.out.print("Seleccione estado de entrega:\n [1] Entregado\n [2] Pendiente\nEleccion: ");
		String opcion = scan.nextLine();
		if (opcion.equals("1")){
			nuevaEntrega.setFueEntregado(true);
			System.out.println("* Marcado como entregado.");
		}
		else{
			nuevaEntrega.setFueEntregado(false);
			System.out.println("* Marcado como pendiente.");
		}
	}
	public static void extraerOpciones() {
	    Pattern pattern = Pattern.compile("\\[(.*?)]"); // busca lo que está entre [ ]
	    Matcher matcher = pattern.matcher(mostrarMenu());
        while (matcher.find()) {
            opciones.add(matcher.group(1)); // group(1) = lo que está entre los corchetes
        }	
	}
}