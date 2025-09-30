
public class Pedidos {
    private int codigoPedido;
    private int estado;
    private int posicion;
    /*
    Pedidos(){
        this.codigoPedido = 0;
        this.estado = 0;
        this.posicion = -1;
    }
    */
    Pedidos(int codigoPedido, int estado, int posicion){
        this.codigoPedido = codigoPedido;
        this.estado = estado;
        this.posicion = posicion;
    }

    String getEstado(){
        String[] estados = new String[]{"Desconocido","Pendiente", "Procesando", "Enviado","Entregado"};
        return estados[this.estado];
    }

    int getNumEstado(){
        return this.estado;
    }

    int getCodigo(){
        return codigoPedido;
    }

    int getPosicion(){
        return posicion;
    }

    void mostrar(){
        System.out.println("  Codigo de pedido: "+ codigoPedido+". Estado: "+getEstado());
    }
}
