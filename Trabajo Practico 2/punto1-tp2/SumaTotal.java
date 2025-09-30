class SumaTotal{
	double precioProducto;
	private double sumaTotal=0;

	void setSumaFinal(double precioProducto){
		sumaTotal+=precioProducto;
	}

	double getSumaFinal(){
		return sumaTotal;
	}
}