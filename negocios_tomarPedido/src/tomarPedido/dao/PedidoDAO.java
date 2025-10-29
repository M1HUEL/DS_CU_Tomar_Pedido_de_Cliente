package src.tomarPedido;

/**
 *
 * @author Diego Ernesto Reynaga Avilez
 */
public class PedidoDAO {

    private String conn;

    public PedidoDAO(String conn) {
        this.conn = conn;
    }

    public void insertarPedido() {
        System.out.println("El pedido se ha ingresado!");
    }
}
