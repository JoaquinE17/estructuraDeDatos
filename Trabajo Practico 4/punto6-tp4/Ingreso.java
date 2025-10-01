
class Ingreso{
	private String dni;
	private String motivoIngreso;
	private boolean autorizado;
	private int hora;

	public Ingreso() {
		this.dni = null;
		this.motivoIngreso = null;
		this.autorizado = false;
		this.hora = 0;
	}

	public Ingreso(String dni, String motivoIngreso, boolean autorizado,int hora) {
		this.dni = dni;
		this.motivoIngreso = motivoIngreso;
		this.autorizado = autorizado;
		this.hora = hora;
	}

	public String getDni() {
		return this.dni;
	}

	public String getMotivoIngreso() {
		return this.motivoIngreso;
	}
	
	public boolean getAutorizado() {
		return this.autorizado;
	}
	
	public int getHora() {
		return this.hora;
	}

	@Override
	public String toString() {
		return "Ingreso [DNI: " + dni + ", Motivo: " + motivoIngreso + ", Autorizado: " + autorizado + ", Hora: "
				+ hora + ((hora>12)?" pm":" am")+ "]";
	}
	
	

	
	
}