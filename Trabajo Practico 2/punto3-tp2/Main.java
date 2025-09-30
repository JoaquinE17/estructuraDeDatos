import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingrese cuantos pedidos quiere gestionar: ");
        int cantidadPedidos = scan.nextInt();
        Pedidos[] pedidos = new Pedidos[cantidadPedidos];
        for (int i=0; i<cantidadPedidos; i++){
            System.out.println(" Pedido Nro"+(i+1)+":");
            System.out.print("  Inserte codigo: ");
            int codigo = scan.nextInt();
            System.out.print("  Inserte estado (1.Pendiente,2.Procesando,3.Enviado,4.Entregado): ");
            int estado = scan.nextInt();
            pedidos[i] = new Pedidos(codigo,estado,i);
        }
        // Buscar: Codigo de pedido (retornar estado y posicion)
        System.out.print("Ingrese codigo a buscar: ");
        int buscarCodigo = scan.nextInt();
        System.out.println(" Buscando codigo: "+buscarCodigo);
        int contador = 0;
        for(Pedidos n : pedidos){
            contador++;
            if (n.getCodigo()==buscarCodigo) {
                System.out.println("  Estado: " + n.getEstado() + ". Posicion en el arreglo: " + n.getPosicion());
                contador--;
                break;
            }
        }
        if (contador==cantidadPedidos)
            System.out.println("  No se encontraron coincidencias para el codigo de pedido ingresado.");

        // Obtener cantidad de pedidos: (referencia: Estado)
        System.out.print("Ingrese estado a buscar (1.Pendiente,2.Procesando,3.Enviado,4.Entregado): ");
        int buscarEstado = scan.nextInt();
        String cadenaEstado = new String[]{"Pendiente","Procesando","Enviado","Entregado"}[buscarEstado-1];
        System.out.println(" Buscando estado: "+cadenaEstado);
        int coincidencias = 0;
        for (Pedidos n : pedidos){
            if(n.getEstado().equals(cadenaEstado))
                coincidencias++;
        }
        if (coincidencias>0)
            System.out.println("  Los pedidios con estado "+cadenaEstado+" son: "+coincidencias);
        else
            System.out.println("  No se encontraron coincidencias para el estado de pedido ingresado.");

        // Solicitar estado y devolver un arreglo (codigo de pedido correspondiente al estado)
        System.out.print("Ingrese estado a buscar (1.Pendiente,2.Procesando,3.Enviado,4.Entregado): ");
        buscarEstado = scan.nextInt();
        cadenaEstado = new String[]{"Pendiente","Procesando","Enviado","Entregado"}[buscarEstado-1];
        System.out.println(" Buscando estado: "+cadenaEstado);
        ArrayList<Integer> coincidenciaEstado = new ArrayList<Integer>();
        for (Pedidos n : pedidos){
            if(n.getEstado().equals(cadenaEstado))
                coincidenciaEstado.add(n.getCodigo());
        }
        if (!coincidenciaEstado.isEmpty())
            System.out.println("  Los pedidios con estado "+cadenaEstado+" son: "+coincidenciaEstado);
        else
            System.out.println("  No se encontraron coincidencias para el estado de pedido ingresado.");

        // Reorganizar Arreglo y mostrar
        for (int j=0; j<cantidadPedidos; j++){
            for (int k=j+1; k<cantidadPedidos;k++){
                if (pedidos[j].getNumEstado()>pedidos[k].getNumEstado()){
                    Pedidos aux = pedidos[j];
                    pedidos[j] = pedidos[k];
                    pedidos[k] = aux;
                }
            }
        }
        System.out.println("El orden de los productos segun importancia es la siguiente:");
        for (Pedidos n : pedidos){
            n.mostrar();
        }
    }
}