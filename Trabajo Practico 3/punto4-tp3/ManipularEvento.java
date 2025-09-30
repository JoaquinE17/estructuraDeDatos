public class ManipularEvento {

	public static void registrarEvento(Stack<Evento> pilaEventos, Evento evento){
		pilaEventos.push(evento);;
		System.out.println("* Evento cargado con exito");
	}

	public static void eliminarEventosDeTipo(Stack<Evento> pilaEventos, String tipo){
		Stack<Evento> pilaAuxiliar = new Stack<Evento>();
		Evento eventoAux = new Evento();
		boolean encontrado = false;
		while (!pilaEventos.empty()) {
			eventoAux = pilaEventos.pop();
			if(eventoAux.getTipo().equals(tipo)) {
				encontrado = true;
			}
			else
				pilaAuxiliar.push(eventoAux);
		}
		while (!pilaAuxiliar.empty()) {
			pilaEventos.push(pilaAuxiliar.pop());
		}
		if (encontrado)
			System.out.println("* Evento eliminado de la pila.");
		else
			System.out.println("* El tipo ingresado no se encuentra en la pila.");
	}

	public static Evento buscarEventosPorCodigo(Stack<Evento> pilaEventos, String codigo){
	    Stack<Evento> pilaAuxiliar = new Stack<Evento>();
	    Stack<Evento> pilaRespaldo = new Stack<Evento>();
	    Evento eventoEncontrado = null;

	    while (!pilaEventos.empty()) {
	        Evento evento = pilaEventos.pop();
	        pilaAuxiliar.push(evento);

	        if(evento.getCodigo().equals(codigo)) {
	            eventoEncontrado = evento;
	            break;
	        }
	    }
	    while (!pilaAuxiliar.empty()) {
	        pilaRespaldo.push(pilaAuxiliar.pop());
	    }
	    while (!pilaRespaldo.empty()) {
	        pilaEventos.push(pilaRespaldo.pop());
	    }

	    if (eventoEncontrado != null) {
	        System.out.println("* Evento encontrado.");
	    }
	    return eventoEncontrado;
	}

	public static int contarErrores(Stack<Evento> pilaEventos){
	    Stack<Evento> pilaAuxiliar = new Stack<Evento>();
	    Stack<Evento> pilaRespaldo = new Stack<Evento>();
	    int contador = 0;

	    while (!pilaEventos.empty()) {
	        Evento evento = pilaEventos.pop();
	        if(evento.getTipo().equals("ERROR")) {
	            contador++;
	        }
	        pilaAuxiliar.push(evento);
	    }
	    while (!pilaAuxiliar.empty()) {
	        pilaRespaldo.push(pilaAuxiliar.pop());
	    }
	    while (!pilaRespaldo.empty()) {
	        pilaEventos.push(pilaRespaldo.pop());
	    }

	    return contador;
	}
}