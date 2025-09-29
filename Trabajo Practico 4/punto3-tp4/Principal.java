public class Principal {
	private static String[] palabras = new String[]{"perro","lampreado","nido","trueno","ave","silla","mesa","gorra","mochila"};

	public static void main(String[] args) {

		System.out.println("# Cola sin prosesar:");
		Queue<String> colaOriginal = new Queue<String>();
		cargarCola(colaOriginal);
		System.out.println("  "+colaOriginal);

		System.out.println("\n# Cola procesada (dividida segun su tamaño):");
		Queue<String> colaCorta = new Queue<String>();
		Queue<String> colaMediana = new Queue<String>();
		Queue<String> colaLarga = new Queue<String>();
		dividirPorLongitud(colaOriginal,colaCorta,colaMediana,colaLarga);
		System.out.println(" * Palabras cortas: "+colaCorta);
		System.out.println("   - Cantidad de palabras cortas: "+colaCorta.toArray().length);
		System.out.println("   - Palabra mas larga (cantidad de letras): "+palabraLarga(colaCorta.toArray()));
		System.out.println("   - Frase reconstruida: \""+reconstruirFrase(colaCorta)+"\"");
		System.out.println(" * Palabras medianas: "+colaMediana);
		System.out.println("   - La cantidad de palabras cortas es: "+colaMediana.toArray().length);
		System.out.println("   - La palabra mas larga (cantidad de letras) es: "+palabraLarga(colaMediana.toArray()));
		System.out.println("   - Frase reconstruida: \""+reconstruirFrase(colaMediana)+"\"");
		System.out.println(" * Palabras largas: "+colaLarga);
		System.out.println("   - La cantidad de palabras cortas es: "+colaLarga.toArray().length);
		System.out.println("   - La palabra mas larga (cantidad de letras) es: "+palabraLarga(colaLarga.toArray()));
		System.out.println("   - Frase reconstruida: \""+reconstruirFrase(colaLarga)+"\"");
	}
	public static void cargarCola(Queue<String> colaOriginal){
		for (String p : palabras){
			colaOriginal.add(p);
		}
	}

	public static void dividirPorLongitud(Queue<String> colaOriginal,Queue<String> colaCorta,Queue<String> colaMediana,Queue<String> colaLarga){
		while (!colaOriginal.isEmpty()) {
			switch (longitud(colaOriginal.peek())) {
				case "corta":
					colaCorta.add(colaOriginal.pool());
					break;
				case "mediana":
					colaMediana.add(colaOriginal.pool());
					break;
				case "larga":
					colaLarga.add(colaOriginal.pool());
					break;
				default:
					colaOriginal.remove();
					break;
			}
		}
	}
	public static String longitud(String palabra){
		if (palabra.length()>=1 && palabra.length()<=3)
			return "corta";
		else{
			if (palabra.length()>=4 && palabra.length()<=6)
				return "mediana";
			else
				return "larga";
		}
	}

	// Trabajar con 'Programacion Generica' y 'Casteo'
	public static String palabraLarga(Object[] objects){
		Object masLarga="";
		for (Object p : objects){
			if (((String) p).length()>(((String) masLarga).length())){
				masLarga = p;
			}
		}
		return (String) masLarga;
	}

	public static String reconstruirFrase(Queue<String> cola){
		String frase = "";
		String espacio = " ";
		while (!cola.isEmpty()) {
			frase += cola.pool();
			if (!cola.isEmpty())
				frase += espacio;
		}
		return frase;
	}
}