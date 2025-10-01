import java.util.ArrayList;
import java.util.Random;

public class Principal {

	private static String[] dnis = new String[]{"12345678A","23456789B","34567890C","45678901D","56789012E","67890123F","78901234G"};

   private static String[] motivos = new String[]{"Deposito de dinero","Solicitud de prestamo","Apertura de cuenta","Consulta de saldo","Retiro de efectivo"};

	public static void main(String[] args) {
		Queue<Ingreso> registro = new Queue<>();
		
		System.out.println("REGISTRO DE INGRESO");
		
		cargarColaOriginal(registro);		
		System.out.println("- - -\n"+registro+"\n- - -");
		
		System.out.println("# Registros no autorizados: ");
		System.out.println("- - -\n"+accesoFallido(registro)+"\n- - -");

		System.out.println("# Cantidad de un motivo de ingreso particular:");
		while (true){
			String motivo = Helper.getString(" > Ingrese un motivo: ");
			if (validarExistencia(motivos,motivo)){
				System.out.println("- - -\n"+"El motivo \""+motivo+"\" a registrado "+cantidadMotivo(registro, motivo)+" ingresos.\n- - -");
				break;
			}
			else
				System.out.println("* ERROR: Ingreso invalido. Vuelva a intentarlo.");
		}
		
		System.out.println("# Verificar ingreso autorizado segun el DNI:");
		while (true) {
			String dni = Helper.getString(" > Ingrese un numero de DNI: ");
			if (validarExistencia(dnis, dni)){
				System.out.println("- - -\n"+"La solicitud de la persona con DNI \""+dni+"\" a sido: "+(ingresoAutorizado(registro, dni)?"Aceptado.":"Denegado.")+"\n- - -");	
				break;
			}
			else
				System.out.println("* ERROR: Ingreso invalido. Vuelva a intentarlo.");
		}
	}	
	
	public static Queue<Ingreso> accesoFallido(Queue<Ingreso> registro){
		Queue<Ingreso> colaAux = new Queue<Ingreso>();

		for (int i=0; i<registro.size(); i++){
			if (registro.peek().getAutorizado()==false){
				colaAux.add(registro.peek());
			}
			registro.add(registro.remove());
		}
		return colaAux;
	}

	public static int cantidadMotivo(Queue<Ingreso> registro, String motivo){
		int contador = 0;
		for (int i=0; i<registro.size(); i++){
			if (registro.peek().getMotivoIngreso().equals(motivo)){
				contador++;
			}
			registro.add(registro.remove());
		}
		return contador;
	}

	public static boolean ingresoAutorizado(Queue<Ingreso> registro, String dni){
		boolean autorizado = false;
		for (int i=0; i<registro.size(); i++){
			if (registro.peek().getDni().equals(dni)){
				 autorizado = registro.peek().getAutorizado();
			}
			registro.add(registro.remove());
		}
		return autorizado;	
	}

	public static boolean validarExistencia(String[] lista, String pivot){
		boolean encontrado = false;
		for (String e : lista){
			if (e.equals(pivot))
				encontrado = true;
		}
		return encontrado;
	}

	public static void cargarColaOriginal(Queue<Ingreso> registro){
		Random rand = new Random(); 
		for (int i=0; i<dnis.length; i++){
			Ingreso ingreso = new Ingreso(dnis[i],motivos[rand.nextInt(motivos.length)],rand.nextBoolean(),rand.nextInt(8,19));
			registro.add(ingreso);
		}
	}
}