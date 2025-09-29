import java.util.Random;

public class Principal {

	public static String[] ciudades = new String[]{"Rosario","Moron", "Liniers","La Boca","Salta","S.S. de Jujuy","C.A.B.A.","Lanus"};
	public static String[] tipos = new String[]{"Tormenta","Viento","Granizo"};
	public static int contadorAlertas = 0;

	public static void main(String[] args) {
		
		System.out.println("SERVICIO METEOROLOGICO:");

		// Cargar la cola con 'n'(cantidad) de Alertas
		int cantidad = Helper.getInteger("# Inserte la cantidad de alertas a cargar en la cola: ");
		Queue<Alerta> colaAlertasOriginal = new Queue<>(cantidad);
		int ctrl = 0;
		while (ctrl<cantidad) {
			// Cargas aleatorias posibles: 8 (ciudades.length)
			cargaAleatoria(colaAlertasOriginal);
			ctrl++;
		}
		System.out.println(" > Cola original cargada con exito.");
		System.out.println("- - -\n"+colaAlertasOriginal+"\n- - -");

		// Inciso [a] - Crear una cola con un 'Tipo de alerta' determinado
		System.out.println("# Seleccione un tipo de alerta:");
		Queue<Alerta> colaTipoElegido = new Queue<>(cantidad);
		String tipoAlerta = tipo();
		System.out.println(" > Nueva cola creada: [Tipo de alerta] -> \""+tipoAlerta+"\".");
		separarTipoElegido(colaAlertasOriginal,colaTipoElegido,tipoAlerta);
		System.out.println("- - -\n"+colaTipoElegido+"\n- - -");

		// Inciso [b] - Calcular nivel promedio de 'Serevidad' (colaAlertaOriginal)
		System.out.println("# El promedio de serevidad (cola original) es: "+promedio(colaAlertasOriginal));

		// Inciso [c] - Identificar existencia de alerta nivel 5
		System.out.println("# La existencia de una amenaza critica de nivel 5 es: "+amenazaCritica(colaAlertasOriginal));

		// Inciso [d] - Crear arreglo ciudades afectadas (nivel 5 y 4)
		System.out.println("# Las ciudades bajo amenaza nivel 4 y 5 son:");
		System.out.print("  [");
		for (String city : ciudadesAmenazadas(colaAlertasOriginal)){
			if (city != null)
			System.out.print(city+",");
		}
		System.out.println("]");
	}
	public static void cargaAleatoria(Queue<Alerta> colaAlertasOriginal){
		Random rand = new Random();
		if (contadorAlertas < ciudades.length){
			Alerta alerta = new Alerta(ciudades[contadorAlertas],tipos[rand.nextInt(0,3)],rand.nextInt(1,6));
			colaAlertasOriginal.add(alerta);
			contadorAlertas++;
		}
		else{
			Alerta alerta = new Alerta(ciudad(),tipo(),nivelSerevidad());
			colaAlertasOriginal.add(alerta);
		}
	}
	public static String ciudad(){
		String ciudad = Helper.getString("* Ingrese el nombre de la ciudad: ");
		return ciudad;
	}
	public static int nivelSerevidad(){
		System.out.println(" NIVELES DE SEREVIDAD:\n  [1] Bajo\n  [2] Medio-Bajo\n  [3] Medio\n  [4] Medio-Alto\n  [5] Alto");
		int opcion = Helper.getInteger("* Inserte el nivel correspondiente: ");
		boolean bandera = false;
		while (!bandera){
			if (opcion>0 && opcion<=5){
				bandera = true;
				return opcion;
			}
		}
		return 1;
	}
	public static String tipo(){
		System.out.println(" TIPOS DE ALERTAS:\n  [1] Tormenta\n  [2] Viento\n  [3] Granizo");
		boolean bandera = false;
		do {
			int opcion = Helper.getInteger("* Inserte el tipo correspondiente: ");
			if (opcion>0 && opcion<=3){
				bandera = true;
				switch (opcion) {
					case 1:
						return "Tormenta";
					case 2:
						return "Viento";
					default:
						return "Granizo";
				}
			}
			else {
				System.out.println("* Los valores permitidos son (1,2,3).");	
			}
		}while(!bandera);
		return null;	
	}

	public static void separarTipoElegido(Queue<Alerta> colaAlertasOriginal, Queue<Alerta> colaTipoElegido, String tipoAlerta){
		Queue<Alerta> colaRespaldo = new Queue<>(colaAlertasOriginal.size());
		while (!colaAlertasOriginal.isEmpty()) {
			if (colaAlertasOriginal.peek().getTipo().equals(tipoAlerta))
				colaTipoElegido.add(colaAlertasOriginal.peek());
			colaRespaldo.add(colaAlertasOriginal.pool());
		}
		while (!colaRespaldo.isEmpty()) {
			colaAlertasOriginal.add(colaRespaldo.pool());
		}
	}

	public static double promedio(Queue<Alerta> colaAlertaOriginal){
		Queue<Alerta> colaRespaldo = new Queue<>(colaAlertaOriginal.size());
		double sumaTotal = 0;
		while (!colaAlertaOriginal.isEmpty()) {
			sumaTotal += colaAlertaOriginal.peek().getNivelDeSerevidad();
			colaRespaldo.add(colaAlertaOriginal.pool());
		}	
		while (!colaRespaldo.isEmpty()) {
			colaAlertaOriginal.add(colaRespaldo.pool());
		}
		return sumaTotal/(double) colaAlertaOriginal.size();
	}

	public static boolean amenazaCritica(Queue<Alerta> colaAlertaOriginal){
		Queue<Alerta> colaRespaldo1 = new Queue<>(colaAlertaOriginal.size());
		boolean existencia = false;
		while (!colaAlertaOriginal.isEmpty()) {
			if (colaAlertaOriginal.peek().getNivelDeSerevidad()==5)
				existencia = true;
			colaRespaldo1.add(colaAlertaOriginal.pool());

		}
		while (!colaRespaldo1.isEmpty()) {
			colaAlertaOriginal.add(colaRespaldo1.pool());
		}
		return existencia;
	}

	public static String[] ciudadesAmenazadas(Queue<Alerta> colaAlertasOriginal){
		String[] amenazas = new String[colaAlertasOriginal.size()];

		int i = 0;
		while (!colaAlertasOriginal.isEmpty()) {
			if (colaAlertasOriginal.peek().getNivelDeSerevidad()>=4){
				amenazas[i]=colaAlertasOriginal.peek().getCiudad();
				i++;
			}
			colaAlertasOriginal.remove();
		}
		return amenazas;
	}	
}