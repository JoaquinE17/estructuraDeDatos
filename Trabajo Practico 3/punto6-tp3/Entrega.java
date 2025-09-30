/*  Entrega ==> ENTREGA  */

import java.util.ArrayList;

class Entrega{
	private String destinatario;
	private int piso;
	private boolean fueEntregado;
	private ArrayList<String> destinatarios = new ArrayList<>();
	private ArrayList<Integer> pisos = new ArrayList<>();

	Entrega(){
		this.destinatario = null;
		this.piso = 0;
		this.fueEntregado = false;
	}

	void setDestinatario(String destinatario){
		this.destinatario = destinatario;
	}
	void setPiso(int piso){
		this.piso = piso;
	}
	void setFueEntregado(boolean fueEntregado){
		this.fueEntregado = fueEntregado;
	}
	String getDestinatario(){
		return this.destinatario;
	}
	boolean getFueEntregado(){
		return this.fueEntregado;
	}
	int getPiso(){
		return this.piso;
	}

	@Override
	public String toString(){
		return "[destinatario: "+destinatario+
		", Piso: "+piso+
		", Entregado?: "+fueEntregado+"]\n";
	}

	// Cargar entrega
	void cargarEntrega(Stack<Entrega> pila, Entrega nuevaEntrega){
		this.destinatarios.add(nuevaEntrega.getDestinatario());
		this.pisos.add(nuevaEntrega.getPiso());
		pila.push(nuevaEntrega);
	}

	// Marcar como entregado
	void marcarComoEntregado(Stack<Entrega> pila, String destinatario) {
        boolean encontrado = false;
		Stack<Entrega> pilaAux = new Stack<Entrega>();
		while (!pila.empty()){
		  	if (pila.peek().getDestinatario().equals(destinatario)){
		   		pila.peek().setFueEntregado(true);
               	encontrado = true;
		   	}
		   	pilaAux.push(pila.peek());
		   	pila.pop();
		}
		while (!pilaAux.empty()) {
		   	pila.push(pilaAux.peek());
		   	pilaAux.pop();
		}
		if (encontrado) 
            System.out.println("* El estado de la entrega a sido cambiado con exito.");
        else
        	System.out.println("* El destinatario ingresado no corresponde a ninguna entrega.");
	}

	// Obtener pendiente por piso
	void getPendientePorPiso(Stack<Entrega> pila, int piso){
		Stack<Entrega> pilaAux = new Stack<Entrega>();
		Stack<Entrega> pilaPendientes = new Stack<Entrega>();
		int contador = 0;
		while (!pila.empty()) {
			if (pila.peek().getPiso()==piso && pila.peek().fueEntregado==false){
				pilaPendientes.push(pila.peek());
				contador++;
			}
			pilaAux.push(pila.peek());
			pila.pop();
		}
		while (!pilaAux.empty()) {
		   	pila.push(pilaAux.peek());
		   	pilaAux.pop();
		}
		if (contador > 0) {
            System.out.println("* Las entregas pendientes en el piso " + piso + " son: " + contador);
            System.out.println(pilaPendientes);
        } 
        else 
            System.out.println("* El piso ingresado no corresponde a ninguna entrega pendiente.");
	}

	// Eliminar articulos entregados
	void vaciarEntregas(Stack<Entrega> pila){
		Stack<Entrega> pilaAux = new Stack<Entrega>();
		while (!pila.empty()){
			if (!(pila.peek().getFueEntregado()))
				pilaAux.push(pila.peek());
			pila.pop();
		}
		while (!pilaAux.empty()){
			pila.push(pilaAux.peek());
			pilaAux.pop();
		}
		System.out.println("* Los elementos entregados fueron removidos.");

	}
}