import java.time.LocalDate; 
import java.util.Scanner;


public class Main{
	public static void main(String[] args){
		Licencia licencia1 = new Licencia();
		Scanner scan = new Scanner(System.in);
		
		LocalDate fechaInicio = LocalDate.of(2025,8,25);
		LocalDate fechaFinal = LocalDate.of(2025,7,22);
		
		licencia1.setFechaIni(fechaInicio);
		licencia1.setFechaFin(fechaFinal);
		licencia1.validacionAux(fechaInicio,fechaFinal);

		System.out.println(licencia1);

		int dia, mes, anio;
		System.out.println(">_Consultar vigencia de licencia:");
		System.out.print(" Ingrese anio: ");
		anio = scan.nextInt();		
		System.out.print(" Ingrese mes: ");
		mes = scan.nextInt();
		System.out.print(" Ingrese dia: ");
		dia = scan.nextInt();
		LocalDate fechaConsulta = LocalDate.of(anio,mes,dia);
		System.out.println("\n * Usted introdujo: " + fechaConsulta + "\n");
		System.out.println(">_Estado de vigencia: "+licencia1.licenciaVigente(fechaConsulta));

		//int dia2, mes2, anio2;
		//System.out.println(">_Consultar dias de vigencia:");
		//System.out.print(" Ingrese anio: ");
		//anio2 = scan.nextInt();		
		//System.out.print(" Ingrese mes: ");
		//mes2 = scan.nextInt();
		//System.out.print(" Ingrese dia: ");
		//dia2 = scan.nextInt();
		//fechaConsulta = LocalDate.of(anio2,mes2,dia2);
		licencia1.diasRestantes(fechaConsulta);

	}
}
