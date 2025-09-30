import java.util.ArrayList;
class Busqueda{
	private int posicion;

	boolean validarExistecia(String nombre, ArrayList<Contacto> agendaTelefonica){
		this.posicion = -1;
		for (Contacto n : agendaTelefonica){
			if (n.getNombre().equals(nombre)){
				this.posicion = agendaTelefonica.indexOf(n);
				return true;
			}
		}
		return false;
	}

	int getPosicion(){
		return this.posicion;
	}	

	void modificar(Contacto contacto,String numNuevo, String correoNuevo){
		contacto.setNumTelefono(numNuevo);
		contacto.setCorreo(correoNuevo);
	}

	void eliminar(int posicion, ArrayList<Contacto> agendaTelefonica){
		agendaTelefonica.remove(posicion);
	}
}
