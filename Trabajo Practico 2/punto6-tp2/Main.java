import java.util.ArrayList;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
		ArrayList<Contacto> agendaTelefonica = new ArrayList<Contacto>();
		Busqueda buscar = new Busqueda();
		Scanner scan = new Scanner(System.in);
		boolean valido = false, salir = false;
		while(salir == false){
			// Agregar contactos (validar: no se repita nombres)
			Contacto nuevoContacto = new Contacto();
			System.out.println("Agregar contacto a la agenda telefonica: ");
			System.out.print("  Inserte nombre: ");
			String name = scan.nextLine();
			nuevoContacto.setNombre(name,agendaTelefonica);
			System.out.print("  Inserte numero de telefono: ");
			String numberPhone = scan.nextLine();
			System.out.print("  Inserte correo: ");
			String email = scan.nextLine();
			if (nuevoContacto.getNombre() != null){
				nuevoContacto.setNumTelefono(numberPhone);
				nuevoContacto.setCorreo(email);
				agendaTelefonica.add(nuevoContacto);
			}
			else 
				System.out.println("Error al agregar contacto.\n  * El nombre '"+name+"' ya existe en la agenda telefonica.");
			System.out.print("Continuar agregando (si/no): ");
			String continuar = scan.nextLine();
			if (continuar.equals("no"))
				salir = true;
		}
		System.out.println("\nLos contactos existentes son: ");
		for (Contacto n:agendaTelefonica)
				System.out.println(n.toString());

		// Buscar y mostrar
		System.out.println("\nBuscar contacto por nombre: ");
		System.out.print("  Inserte nombre: ");
		String name = scan.nextLine();
		if (buscar.validarExistecia(name,agendaTelefonica))
			System.out.println(agendaTelefonica.get(buscar.getPosicion()));
		else
			System.out.println("  * Contacto no encontrado.");

		// Buscar y modificar
		System.out.println("\nModificar contacto: ");
		System.out.print("  Inserte nombre: ");
		name = scan.nextLine();
		if (buscar.validarExistecia(name,agendaTelefonica)){
			System.out.println(agendaTelefonica.get(buscar.getPosicion()));
			System.out.print("  Inserte nuevo numero: ");
			String numNuevo = scan.nextLine();
			System.out.print("  Inserte nuevo correo: ");
			String correoNuevo = scan.nextLine();
			buscar.modificar(agendaTelefonica.get(buscar.getPosicion()),numNuevo,correoNuevo);
			System.out.println("Contacto modificado: ");
			System.out.println(agendaTelefonica.get(buscar.getPosicion()));		
		}
		else
			System.out.println("  * No se realizaron cambios. Contacto no encontrado.");
		
		// Buscar y eliminar
		System.out.println("\nEliminar contacto por nombre: ");
		System.out.print("  Inserte nombre: ");
		name = scan.nextLine();
		if (buscar.validarExistecia(name,agendaTelefonica)){
			System.out.println(agendaTelefonica.get(buscar.getPosicion()));
			buscar.eliminar(buscar.getPosicion(),agendaTelefonica);
			System.out.println("  * Contacto eliminado");
		}
		else
			System.out.println("  * No se pudo eliminar. Contacto no encontrado.");
		
		// Mostrar lista de contactos actualizada
		System.out.println("\nLa lista de contacto actualizada es:");
		for (Contacto n:agendaTelefonica)
				System.out.println(n.toString());

		/*
		for (String arg: args)
			System.out.println(arg);
		*/
	}

}