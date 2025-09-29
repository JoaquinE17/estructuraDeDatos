public class Registro {

	private String usuario;
	private int cantidadPasos;
	private double caloriasQuemadas;
	private String tipoActividad;

	Registro() {
		this.usuario = null;
		this.cantidadPasos = 0;
		this.caloriasQuemadas = 0.0;
		this. tipoActividad = null;
	}

	Registro(String usuario, int cantidadPasos, double caloriasQuemadas, String tipoActividad) {
		this.usuario = usuario;
		this.cantidadPasos = cantidadPasos;
		this.caloriasQuemadas = caloriasQuemadas;
		this.tipoActividad = tipoActividad;
	}

	public String getUsuario() {
	    return usuario;
	}
	public int getCantidadPasos() {
	    return cantidadPasos;
	}
	public double getCaloriasQuemadas() {
	    return caloriasQuemadas;
	}
	public String getTipoActividad() {
	    return tipoActividad;
	}

	@Override
	public String toString() {
		return "[Usuario: "+usuario+
		", Cantidad de pasos: "+cantidadPasos+
		", Calorias quemadas: "+caloriasQuemadas+
		", Tipo de actividad: "+tipoActividad+"]";
	}
}


