import java.util.Scanner;

public class main{
	public static void main(String[] args){
		valores datos = ingresoDatos();
		System.out.println("####  Calcule el area del rectangulo  ####");
		
		double ancho = datos.ancho;
		double alto = datos.alto;

		var calculo = new rectangulo(ancho,alto);
		double areac = calculo.area(ancho,alto);
		double perimetroc = calculo.perimetro(ancho,alto);
		System.out.println("El area del rectangulo es: " + areac);
		System.out.println("El perimetro del rectangulo es: " + perimetroc);			
	}

	public static class valores{
		public double ancho;
		public double alto;
	}

	public static valores ingresoDatos(){
		valores datosEntrada = new valores();
		Scanner scan = new Scanner(System.in);
		do{
			System.out.print("Ingrese el ancho del rectangulo: ");
			datosEntrada.ancho = scan.nextDouble();
			System.out.print("Ingrese el alto del rectangulo: ");
			datosEntrada.alto = scan.nextDouble();
		}while (!validar(datosEntrada.ancho,datosEntrada.alto)); // bubcle finaliza con FALSE
		return datosEntrada;
	}

	public static boolean validar(double ancho,double alto){
		if (ancho > 0.0 || alto > 0.0) {
			return true;
        }
        return false;

	}
}