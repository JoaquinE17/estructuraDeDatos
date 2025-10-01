import java.util.Random;

public class Principal {

	public static void main(String[] args) {
		int cantidad = Helper.getInteger("* Introdusca la cantidad de elementos a cargar: ");
		Queue<Integer> colaOriginal = new Queue<Integer>(cantidad);
		cargarCola(colaOriginal, cantidad);
		System.out.println("  "+colaOriginal);

		Queue<Integer> colaModificada = new Queue<>(cantidad);
		int referencia = Helper.getInteger("* Inserte un valor referencia (maximo): ");
		System.out.println("  "+reubicarValores(colaOriginal,colaModificada,referencia,cantidad));

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
	public static Queue<Integer> reubicarValores(Queue<Integer> colaOriginal, Queue<Integer> colaModificada, int referencia, int cantidad){
		Queue<Integer> valoresMayores = new Queue<>(colaOriginal.size());
		int cantidadTotal = colaOriginal.size();
		for (int i=0; i<cantidadTotal; i++){
			if (colaOriginal.peek() > referencia){
				valoresMayores.add(colaOriginal.remove());
			}
		}
		return colaOriginal;
	}
	public static void separarValoresMenores(Queue<Integer> colaModificada, Queue<Integer> colaValoresMenores, int referencia){
		while (!colaModificada.isEmpty()){
			if (colaModificada.peek() < referencia)
				colaValoresMenores.add(colaModificada.peek());
			colaModificada.remove();
		}
	}
}