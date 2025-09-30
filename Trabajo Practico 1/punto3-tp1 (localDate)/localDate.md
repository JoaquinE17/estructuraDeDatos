### Creación de fechas
Método / Descripción
--------------------
***LocalDate.now()***	              Devuelve la fecha actual del sistema.
***LocalDate.of(año, mes, día)***	  Crea una fecha específica. Ej: LocalDate.of(2025, 8, 22).
***LocalDate.parse(String)***	      Convierte un String (formato "yyyy-MM-dd") a un LocalDate.

### Acceso a componentes de la fecha
Método / Descripción
-------------------
***getYear()***	        Devuelve el año (ej: 2025).
***getMonth()***	    Devuelve el mes como Month (ej: AUGUST).
***getMonthValue()***	Devuelve el mes como número (1 a 12).
***getDayOfMonth()***	Devuelve el día del mes (1 a 31).
***getDayOfWeek()***	Devuelve el día de la semana (ej: MONDAY).
***getDayOfYear()***	Devuelve el número de día en el año (1 a 365/366).

### Operaciones con fechas
Método / Descripción
-------------------
***plusDays(n)***	    Suma n días a la fecha.
***plusMonths(n)***	    Suma n meses.
***plusYears(n)***	    Suma n años.
***minusDays(n)***	    Resta n días.
***minusMonths(n)***	Resta n meses.
***minusYears(n)***	    Resta n años.

### Comparaciones y validaciones
Método / Descripción
-------------------
***isBefore(fecha)***	Devuelve true si es antes de la fecha dada.
***isAfter(fecha)***	Devuelve true si es después de la fecha dada.
***isEqual(fecha)***	Devuelve true si es la misma fecha.
***equals(Object)***	Compara si dos fechas son iguales (usando Object).

### Conversión y formato
Método / Descripción
--------------------
***toString()***	Devuelve la fecha en formato "yyyy-MM-dd".
***format(...)***	Permite aplicar un formato personalizado usando DateTimeFormatter.

Ejemplo:
--------
~~~java
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String fechaFormateada = fecha.format(formatter); // "22/08/2025"
~~~

Ejemplo práctico
----------------
~~~java
LocalDate hoy = LocalDate.now();
LocalDate cumple = LocalDate.of(2025, 8, 22);

if (hoy.isBefore(cumple)) {
    System.out.println("Aún falta para tu cumpleaños.");
}
~~~

## CHEAT SHEET (localDate) - Java
(Un cheat sheet es una hoja de referencia rápida con lo más importante de un tema.)
~~~java
/* Importacion */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/* Crear fechas */
LocalDate fechaActual = LocalDate.now();                  // Fecha actual
LocalDate fechaEspecifica = LocalDate.of(2025, 8, 22);    // Año, mes, día
LocalDate desdeTexto = LocalDate.parse("2025-08-22");     // Desde String ISO

/* Obtener partes de la fecha */
int año = fecha.getYear();            // 2025
int mes = fecha.getMonthValue();      // 8
int día = fecha.getDayOfMonth();      // 22
String díaSemana = fecha.getDayOfWeek().toString(); // FRIDAY
int díaAño = fecha.getDayOfYear();    // 234 (por ejemplo)

/* Operaciones con fechas */
fecha.plusDays(5);       // Suma 5 días
fecha.minusMonths(1);    // Resta 1 mes
fecha.plusYears(2);      // Suma 2 años

/* Comparar fechas */
fecha1.isBefore(fecha2);    // true si fecha1 < fecha2
fecha1.isAfter(fecha2);     // true si fecha1 > fecha2
fecha1.isEqual(fecha2);     // true si son iguales

/* Convercion y formato */
String texto = fecha.toString();  // "2025-08-22" (formato ISO)

DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String formateado = fecha.format(formato);  // "22/08/2025"

/* Util para condiciones */
if (fecha.equals(LocalDate.parse("2025-08-22"))) {
    System.out.println("Las fechas coinciden");
}
~~~