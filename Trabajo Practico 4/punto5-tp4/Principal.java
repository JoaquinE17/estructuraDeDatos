import java.util.ArrayList;
import java.util.Random;

public class Principal {
	private static String[] usuarios = {"Lucia","Mateo","Valentina","Santiago","Martina","Thiago","Camila","Benjamin","Sofia","Julian"};
	private static String[] tiposActividades = {"Caminar","Correr","Bicicleta"};

	public static void main(String[] args) {
		System.out.println("REGISTRO DE ACTIVIDADES FISICAS:");

		// Cargar la cola
		System.out.println("# La cola de registros es la siguiente:");
		Queue<Registro> colaRegistros = new Queue<>();
		cargarCola(colaRegistros);
		System.out.println("- - -\n"+colaRegistros+"\n- - -");

		// Consultar calorias quemadas(calQue) ([solicitar]: tipo de actividad)
		System.out.println("# Consultar calorias quemadas apartir de un tipo de actividad:");
		String actividad = seleccionActividad();
		System.out.println(" > El total de calorias perdidas en la actividad \""+actividad+"\" es: "+calQue(colaRegistros,actividad));
	
		// Usuario con mas pasos acumulados(paCu)
		System.out.println("# Consultar usuario con mayor cantidad de pasos acumulados:");
		Registro usuario = paCu(colaRegistros);
		System.out.println(" > El usuario con mas pasos acumulados es: "+ usuario.getUsuario());
		System.out.println("- - -\n"+usuario+"\n- - -");

		// Contar cuántas actividades registró un usuario determinado (actReg)
		System.out.println("# Consultar cuantas actividaddes registro un usuario:");
		System.out.println(" > Los nombres validos son: "+mostrarUsuarios(colaRegistros));
		String persona = Helper.getString(" > Ingrese un nombre de usuario valido: ");
		System.out.println(" > El usuario "+persona+actReg(colaRegistros,persona));
		
		
	}
	public static void cargarCola(Queue<Registro> colaRegistros){
		Random rand = new Random();
		for (int i=0;i<usuarios.length;i++){
			double caloriasQuemadas = Math.round(rand.nextDouble(5, 50) * 100.0) / 100.0;
			Registro persona = new Registro(usuarios[rand.nextInt(10)],rand.nextInt(10,100),caloriasQuemadas,tiposActividades[rand.nextInt(3)]);
			colaRegistros.add(persona);
		}
	}
	public static String seleccionActividad(){
		System.out.println(" TIPOS DE ACTIVIDADES:\n  [1] Caminar\n  [2] Correr\n  [3] Bicicleta");
		boolean bandera = false;
		do {
			int opcion = Helper.getInteger("* Inserte el tipo correspondiente: ");
			if (opcion>0 && opcion<=3){
				bandera = true;
				switch (opcion) {
					case 1:
						return "Caminar";
					case 2:
						return "Correr";
					default:
						return "Bicicleta";
				}
			}
			else {
				System.out.println("* Los valores permitidos son (1,2,3).");	
			}
		}while(!bandera);
		return null;
	}
	public static void resturarColaOriginal(Queue<Registro> colaRespaldo, Queue<Registro> colaOriginal){
		while (!colaRespaldo.isEmpty()) {
			colaOriginal.add(colaRespaldo.pool());
		}
	}

	public static double calQue(Queue<Registro> colaRegistros, String actividadElegida){
		Queue<Registro> colaRespaldo = new Queue<>();
		double caloriasQuemadas = 0;
		while (!colaRegistros.isEmpty()){
			if (colaRegistros.peek().getTipoActividad().equals(actividadElegida))
				caloriasQuemadas += colaRegistros.peek().getCaloriasQuemadas();
			colaRespaldo.add(colaRegistros.pool());
		}
		resturarColaOriginal(colaRespaldo,colaRegistros);
		return caloriasQuemadas;
	}

	public static Registro paCu(Queue<Registro> colaRegistros){
		Queue<Registro> colaRespaldo = new Queue<>();
		Registro max = new Registro();
		while (!colaRegistros.isEmpty()) {
			if (colaRegistros.peek().getCantidadPasos()>max.getCantidadPasos())
				max = colaRegistros.peek();
			colaRespaldo.add(colaRegistros.pool());
		}
		resturarColaOriginal(colaRespaldo, colaRegistros);
		return max;
	}

	public static ArrayList<String> mostrarUsuarios(Queue<Registro> colaRegistro){
		Queue<Registro> colaRespaldo = new Queue<>(colaRegistro.size());
		ArrayList<String> usuarios = new ArrayList<>();
		while (!colaRegistro.isEmpty()) {
			if (!usuarios.contains(colaRegistro.peek().getUsuario()))
				usuarios.add(colaRegistro.peek().getUsuario());
			colaRespaldo.add(colaRegistro.pool());
		}
		resturarColaOriginal(colaRespaldo, colaRegistro);
		return usuarios;
	}

	public static String actReg(Queue<Registro> colaRegistro,String persona){
		Queue<Registro> colaRespaldo = new Queue<>();
		String cadena = " no se encuentra dentro de los nombres validos.";
		int contador = 0;
		boolean bandera = false;
		while (!colaRegistro.isEmpty()) {
			if (colaRegistro.peek().getUsuario().equals(persona)){
				contador++;
				bandera = true;
			}
			colaRespaldo.add(colaRegistro.pool());
		}
		resturarColaOriginal(colaRespaldo, colaRegistro);
		if (!bandera)
			return cadena;
		else
			if (contador==1)
				cadena = " registro "+contador+" actividad.";	
			else			
				cadena = " registro "+contador+" actividades.";
			return cadena;
	}
}