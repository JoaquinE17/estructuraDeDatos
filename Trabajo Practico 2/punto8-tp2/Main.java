import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
class Main{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		System.out.print("Inserte la cantidad total de estudiantes:");
		int filas = scan.nextInt();
		System.out.print("Inserte la cantidad total de materias:");
		int columnas = scan.nextInt();
		
		int[][] matriz = new int[filas][columnas];
		for(int i=0; i<filas; i++){
			for(int j=0; j<columnas; j++){
				matriz[i][j]=random.nextInt(11);
			}
		}
		for (int[] n : matriz){
			for (int e : n){
				System.out.print(" "+e+" ");
			}
			System.out.println();
		}

		// Calcular y mostrar el promedio de cada estudiante
		System.out.println("\nEl promedio de cada estudiante es:");
		for(int i=0; i<filas; i++){
			int aux = 0;
			for(int j=0; j<columnas; j++){
				aux += matriz[i][j];
			}
			System.out.println(" El promedio del estudiante "+(i+1)+" es: "+(aux/columnas));
		}

		// Calcular y mostrar el promedio de cada asignatura
		System.out.println("\nEl promedio de cada asignatura es:");
		for(int i=0; i<columnas; i++){
			int aux = 0;
			for(int j=0; j<filas; j++){
				aux += matriz[j][i];
			}
			System.out.println(" El promedio del asignatura "+(i+1)+" es: "+(aux/filas));
		}

		// Mostrar calificacion (alta y baja). Mostrar fila y columna
		int min=0,max=0;
		for (int[] n : matriz){
			for (int e : n){
				if (e>max)
					max=e;
				else 
					min=e;
			}
		}
		System.out.println("\nLa nota maxima es '"+max+"':");
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				if (matriz[i][j]==max)
					System.out.println(" Se encuentra en la cordenada: [fila: "+(i+1)+", columna: "+(j+1)+"]");
			}			
		}
		System.out.println("La nota minima es '"+min+"':");
		for (int i=0;i<filas;i++) {
			for (int j=0;j<columnas;j++) {
				if (matriz[i][j]==min)
					System.out.println(" Se encuentra en la cordenada: [fila: "+(i+1)+", columna: "+(j+1)+"]");
			}			
		}

		// Cantidad de estudiantes (nota >= 6) en todas las asignaturas
		int contador = 0;
		for (int[] n : matriz){
			boolean bandera = true;
			for (int e : n){
				if (e<6)
					bandera = false;
			}
			if (bandera==true)
				contador++;
		}
		System.out.println("\nLa cantidad de estudiante, con nota mayor o igual a 6, en todas las columnas son: "+contador);

		// Cantidad de estudiantes que aprobaron una asignatura (elegida por el usuario)
		System.out.print("\nIntrodusca un numero de columna: ");
		int columnaElegida = scan.nextInt();
		if (columnaElegida<=columnas){
			contador=0;
			for (int i=0;i<filas;i++) {
				if (matriz[i][columnaElegida-1] >= 6)
					contador++;
			}
			System.out.println("La cantidad de estudiantes, con nota mayor o igual a 6, en la columna seleccionada es: "+contador);
		}
		else 
			System.out.println("El valor ingresado es invalido.");

		// Crear un arreglo con las mayores notas obtenidas
		ArrayList<Integer> arreglo = new ArrayList<Integer>();
		for (int[] n : matriz){
			for (int e : n){
				if (e>=6 && !arreglo.contains(e))
					arreglo.add(e);
			}
		}
		System.out.print("\nLas mayores notas obtenidas por los alumnos son: {");
		for (int n : arreglo){
			System.out.print(n+",");
		}
		System.out.println("}");

		for (int i=0;i<filas;i++) {
			ArrayList<Integer> arreglo2 = new ArrayList<Integer>();
			for (int j=0;j<columnas;j++){
				if (matriz[i][j] >=6 && !arreglo2.contains(matriz[i][j]))
					arreglo2.add(matriz[i][j]);
			}
			System.out.print("  Estudiante "+(i+1)+": {");
			for (int n : arreglo2){
				System.out.print(n+",");
			}
			System.out.println("}");
		}
	}
}