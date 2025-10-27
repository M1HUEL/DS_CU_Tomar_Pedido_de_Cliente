package src.tomarPedido;

/**
 *
 * @author José Antonio González Valle
 */
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    public void crearNuevoPedido() {
        System.out.println("El pedido se ha creado correctamente!");
    }
}
