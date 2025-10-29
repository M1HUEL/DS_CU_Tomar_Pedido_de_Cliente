package tomarPedido;

import tomarPedido.dao.PedidoDAO;

/**
 *
 * @author Luis Francisco Salido Varela
 */
public class ServicioPedido {

    private PedidoDAO pedidoDAO;

    public ServicioPedido(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void procesarPedido() {
        System.out.println("El pedido se está procesando!");
    }
}
