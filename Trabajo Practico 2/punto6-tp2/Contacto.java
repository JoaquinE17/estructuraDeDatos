import java.util.ArrayList;
class Contacto{

	/* Atributos */
	private String nombre;
	private String numTelefono;
	private String correo;

	/* Constructor */
	Contacto(){
		this.nombre = null;
		this.numTelefono = null;
		this.correo = null;
	}

	/* Setters */
	void setNombre(String name, ArrayList<Contacto> agendaTelefonica){
		int contador = 0;
		for (Contacto n : agendaTelefonica){
			if (n.getNombre().equals(name))
				contador++;
		}
		if (contador==0){
			this.nombre = name;
		}
	}

	void setNumTelefono(String numTelefono){
		this.numTelefono = numTelefono;
	}

	void setCorreo(String correo){
		this.correo = correo;
	}

	/* Getters */
	String getNombre(){
		return this.nombre;
	}

	String getNumTelefono(){
		return this.numTelefono;
	}

	String getCorreo(){
		return this.correo;
	}

	public String toString(){
		return (" {Nombre: "+nombre+
			", Nro.Telefono: "+numTelefono+
			", Correo: "+correo+"}");
	}
}