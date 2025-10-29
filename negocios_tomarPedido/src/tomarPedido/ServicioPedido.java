package tomarPedido;

import tomarPedido.dao.PedidoDAO;
import tomarPedido.objetosNegocio.Complemento;
import tomarPedido.objetosNegocio.Ingrediente;
import tomarPedido.objetosNegocio.Pedido;

/**
 *
 * @author Luis Francisco Salido Varela
 */
public class ServicioPedido {

    private PedidoDAO pedidoDAO;

    public ServicioPedido(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void crearPedido(Pedido pedido) {
        if (pedido.getIngredientes().isEmpty()) {
            throw new IllegalArgumentException("El pedido debe tener al menos un ingrediente");
        }
        pedidoDAO.crear(pedido);
    }

    public double calcularMontoTotal(Pedido pedido) {
        double total = 0;
        for (Ingrediente i : pedido.getIngredientes()) {
            total += i.getPrecio();
        }
        for (Complemento c : pedido.getComplementos()) {
            total += c.getPrecio();
        }
        return total;
    }

    public Pedido buscarPedido(int id) {
        return pedidoDAO.buscarPorId(id);
    }
}
