import java.time.LocalDate; 
import java.time.YearMonth;

public class Licencia{
	/* Atributos */
	final private int numeroIdentificacion;
	private String tipoLicencia;
	private LocalDate fechaEmicion;
	private LocalDate fechaVencimiento;

	/* Constructores */
	public Licencia(){
		this.numeroIdentificacion = 000;
		this.tipoLicencia = "A definir";
		this.fechaEmicion = LocalDate.now(); // Fecha actual
		this.fechaVencimiento = this.fechaEmicion.plusMonths(1); // Un mes despues
	}	

	public Licencia(int numeroIdentificacion,String tipoLicencia,LocalDate fechaEmicion, LocalDate fechaVencimiento){
		this.numeroIdentificacion = numeroIdentificacion;
		this.tipoLicencia = tipoLicencia;
		this.fechaEmicion = fechaEmicion;
		this.fechaVencimiento = fechaVencimiento;
	}
	
	/* Setters */
	public void setFechaIni(LocalDate fechaInit){
		this.fechaEmicion = fechaInit;
	}

	public void setFechaFin(LocalDate fechaFin){
		this.fechaVencimiento = fechaFin;
	}

	/* Metodos */
	@Override
	public String toString(){
		// Como quiero que se vea el objeto como texto. Se ejecuta automaticamente al hacer un 'system.out.println(<objeto instanciado>)'
		return "Licencia\n{"+"ID : "+numeroIdentificacion+
		", Tipo : "+tipoLicencia+
		", Fecha Emicion : "+fechaEmicion+
		", Fecha Vencimiento : "+fechaVencimiento+"}";
	}

	public void validacionAux(LocalDate fechaEmicion, LocalDate fechaVencimiento){ // Valida el mes
		if (fechaEmicion.isAfter(fechaVencimiento)){
			this.fechaEmicion = LocalDate.now(); // Reseteacsi y solo si el valor de emicion (mes) es mayor al de vencimiento (mes)
			this.fechaVencimiento = this.fechaEmicion.plusMonths(1);
		}
	}

	public boolean licenciaVigente(LocalDate fechaConsulta){ // Controla que fechaConsulta se encuentre entre emicion y vencimiento
		return ( fechaConsulta.isAfter(fechaEmicion) && fechaConsulta.isBefore(fechaVencimiento) );
	}

	public void diasRestantes(LocalDate fechaConsulta){// Calcula los dias posterior al vencimiento y anterior al vencimiento
		int diasMes = fechaEmicion.lengthOfMonth(); 
		int diaEmicion = fechaEmicion.getDayOfMonth();
		int diaConsulta = fechaConsulta.getDayOfMonth();
		int resultado = diasMes + diaEmicion - diaConsulta;
		System.out.println("("+diasMes+"+"+diaEmicion+") - "+diaConsulta + " = Faltan "+resultado+" dias");

		System.out.println("("+fechaConsulta+" + "+resultado+" dias)" + " = "+ fechaConsulta.plusDays(resultado));

	}
}

/*
Modificar Java LocalDate (Java 8)
Para modificar la fecha con Java 8 necesitaremos usar los métodos [plus] y [minus] 
añadiéndole al final Year , Days etc. Esto nos generará un nuevo objeto que nos 
permite gestionar las modificaciones realizadas de forma sencilla.
~~~java
import java.time.LocalDate;

public class ModificarFecha {

    public static void main(String[] args) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);

        // Sumar días a la fecha actual
        LocalDate fechaSumaDias = fechaActual.plusDays(5);
        System.out.println("Fecha después de sumar 5 días: " + fechaSumaDias);

        // Restar meses a la fecha actual
        LocalDate fechaRestaMeses = fechaActual.minusMonths(2);
        System.out.println("Fecha después de restar 2 meses: " + fechaRestaMeses);

        // Sumar años a la fecha actual
        LocalDate fechaSumaAnios = fechaActual.plusYears(3);
        System.out.println("Fecha después de sumar 3 años: " + fechaSumaAnios);
    }
}
~~~
Creación de fechas
| Método                        | Descripción                                                      |
| ----------------------------- | ---------------------------------------------------------------- |
| `LocalDate.now()`             | Devuelve la fecha actual del sistema.                            |
| `LocalDate.of(año, mes, día)` | Crea una fecha específica. Ej: `LocalDate.of(2025, 8, 22)`.      |
| `LocalDate.parse(String)`     | Convierte un `String` (formato `"yyyy-MM-dd"`) a un `LocalDate`. |


*/