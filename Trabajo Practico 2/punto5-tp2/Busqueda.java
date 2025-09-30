class Busqueda{
	private int posicion;

	boolean validarExistecia(String codigo, Componente[] productos, int cantidad){
		this.posicion = -1;
		for (int i=0;i<cantidad;i++){
			if (productos[i].getCodigo().equals(codigo)){
				this.posicion = i;
				return true;
			}
		}
		return false;
	}

	int getPosicion(){
		return this.posicion;
	}	
	/*
	void modificar(Contacto contacto,String numNuevo, String correoNuevo){
		contacto.setNumTelefono(numNuevo);
		contacto.setCorreo(correoNuevo);
	}

	void eliminar(int posicion, ArrayList<Contacto> agendaTelefonica){
		agendaTelefonica.remove(posicion);
	}
	*/
}
