package src.tomarPedido;

/**
 *
 * @author José Antonio González Valle
 */
public class ControladorPedido {

    private ServicioPedido service;

    public ControladorPedido(ServicioPedido service) {
        this.service = service;
    }

    public void crearNuevoPedido() {
        System.out.println("El pedido se ha creado correctamente!");
    }
}
