package src.tomarPedido;

/**
 *
 * @author Luis Francisco Salido Varela
 */
public class PedidoService {

    private PedidoDAO pedidoDAO;

    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void procesarPedido() {
        System.out.println("El pedido se está procesando!");
    }
}
