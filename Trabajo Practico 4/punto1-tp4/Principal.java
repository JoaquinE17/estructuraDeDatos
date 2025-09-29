import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		int cantidad = Helper.getInteger("* Introdusca la cantidad de elementos a cargar: ");
		Queue<Integer> colaOriginal = new Queue<Integer>(cantidad);
		cargarCola(colaOriginal, cantidad);
		System.out.println("  "+colaOriginal);

		Queue<Integer> colaModificada = new Queue<>(cantidad);
		int referencia = Helper.getInteger("* Inserte un valor referencia (maximo): ");
		reubicarValores(colaOriginal,colaModificada,referencia,cantidad);
		System.out.println("  "+colaModificada);

		Queue<Integer> colaValoresMenores = new Queue<>(cantidad);
		separarValoresMenores(colaModificada, colaValoresMenores, referencia);
		System.out.println("* La cola con los valores inferiores a "+referencia+" es:");
		System.out.println("  "+colaValoresMenores);

	}

	public static void cargarCola(Queue<Integer> colaOriginal, int cantidad){
		Random rand = new Random();
		for (int i=0; i<cantidad; i++){
			colaOriginal.add(rand.nextInt(10,100));
		}
	}
	public static void reubicarValores(Queue<Integer> colaOriginal, Queue<Integer> colaModificada, int referencia, int cantidad){
		Queue<Integer> colaMenor = new Queue<>(cantidad);
		Queue<Integer> colaMayor = new Queue<>(cantidad);
		while (!colaOriginal.isEmpty()) {
			if (colaOriginal.peek() < referencia){
				colaMenor.add(colaOriginal.pool());
			}
			else
				colaMayor.add(colaOriginal.pool());
		}
		while (!colaMenor.isEmpty()) {
			colaModificada.add(colaMenor.pool());
		}
		while (!colaMayor.isEmpty()) {
			colaModificada.add(colaMayor.pool());
		}
	}
	public static void separarValoresMenores(Queue<Integer> colaModificada, Queue<Integer> colaValoresMenores, int referencia){
		while (!colaModificada.isEmpty()){
			if (colaModificada.peek() < referencia)
				colaValoresMenores.add(colaModificada.peek());
			colaModificada.remove();
		}
	}
}