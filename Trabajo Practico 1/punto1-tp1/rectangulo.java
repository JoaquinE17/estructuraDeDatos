public class rectangulo{
	/* Atributos */
	double ancho;
	double alto;

	/* Constructor */
	public rectangulo(){
		this.ancho=0.0;
		this.alto=0.0;
	}
	// Al momento de ejecutar este constructor ya se inicializan los valores, despues
	// de esto solo nesecitan ser seteados (setter) por ejemplo 'serAncho()'

	public rectangulo(double ancho, double alto){ // Ambito de las variables local al metodo
		this.ancho = ancho;
		this.alto = alto;
	}

	/* Getter y Setter*/
	// los metodos getter y setter es obligatorio su uso para esta materia, 
	//mas el mandado por el profe Peralta por el correo (helper)

	/* Metodos*/
	//public double area(double ancho, double alto){
	//	return ancho*alto;
	//}	   '-----.
	//			 v
	public double area(){
		return this.ancho * this.alto; // no necesita resibir parametros externos
	}

	public double perimetro(double ancho, double alto){
		return 2*(ancho+alto);
	}
}

/*  
[Firma] public double area(){
	[Implementacion] return ancho*alto;
}

Las clases con metodos estaticos no nececitan ser instanciados
Solo si la clase tiene un constructor es posible instanciar la clase en si.
*/