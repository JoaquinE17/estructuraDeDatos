import java.util.Random;

public class Principal {
	private final static int MAX = 20;
	private static double acumulador;// Utilizado para sacar el promedio y mostrar la suma total

	public static void main(String[] args) {
		Stack<Integer> pilaOriginal = new Stack<Integer>(MAX);// [MAX]: Para modificar 'defaultDimencion' de la clase 'Stack' (dada por catedra)
		cargaNumerosAleatorios(pilaOriginal);
		System.out.println("* Pila original [cargada]:");
		System.out.println(pilaOriginal);

		Stack<Integer> pilaRespaldo  = new Stack<Integer>(MAX);
		Stack<Integer> pilaNumerosPares = new Stack<Integer>(MAX);
		Stack<Integer> pilaNumerosImpares = new Stack<Integer>(MAX);
		separarParesImpares(pilaOriginal,pilaNumerosPares,pilaNumerosImpares,pilaRespaldo);
		System.out.println("\n* Pila con valores pares:");
		System.out.println(pilaNumerosPares);
		System.out.println("-> El promedio de los numeros pares es: "+promedio(pilaNumerosPares));
		System.out.println("-> La suma total de los numeros pares es: "+acumulador);

		System.out.println("\n* Pila con valores impares:");
		System.out.println(pilaNumerosImpares);
		
		System.out.println("-> El promedio de los numeros impares es: "+promedio(pilaNumerosImpares));
		System.out.println("-> La suma total de los numeros impares es: "+acumulador);
		// mostrar promedio de impares
		
		System.out.println("\n* Pila original [sin modificaciones]:");
		restaurarPila(pilaRespaldo,pilaOriginal);
		System.out.println(pilaOriginal);
	}

	public static void cargaNumerosAleatorios(Stack<Integer> pilaOriginal){
		Random rand = new Random();
		for (int i=0; i<MAX; i++)
			pilaOriginal.push(rand.nextInt(10, 100));
	}	
	public static void separarParesImpares(Stack<Integer> pilaOriginal,Stack<Integer> pilaNumerosPares,Stack<Integer> pilaNumerosImares,Stack<Integer> pilaRespaldo){
		Stack<Integer> pilaAux = new Stack<>(MAX);
		while (!pilaOriginal.empty()) {
			pilaAux.push(pilaOriginal.pop());
		}
		while (!pilaAux.empty()) {
			if (pilaAux.peek()%2==0)
				pilaNumerosPares.push(pilaAux.peek());
			else
				pilaNumerosImares.push(pilaAux.peek());
			pilaRespaldo.push(pilaAux.pop());
		}
	}
	public static double promedio(Stack<Integer> pilaNumeros){
		double contador = 0;
		acumulador = 0;
		while (!pilaNumeros.empty()) {
			acumulador+=pilaNumeros.pop();
			contador++;
		}
		return acumulador/contador;
	}
	public static void restaurarPila(Stack<Integer> pilaRespaldo,Stack<Integer> pilaOriginal){
		Stack<Integer> pilaAux = new Stack<>(MAX);
		while (!pilaRespaldo.empty()) {
			pilaAux.push(pilaRespaldo.pop());
		}
		while (!pilaAux.empty()) {
			pilaOriginal.push(pilaAux.pop());
		}
	}
}