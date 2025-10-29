package tomarPedido;

import tomarPedido.objetosNegocio.Pedido;

/**
 *
 * @author José Antonio González Valle
 */
public class ControladorPedido {

    private ServicioPedido servicio;

    public ControladorPedido(ServicioPedido servicio) {
        this.servicio = servicio;
    }

    public void crearPedido(Pedido pedido) {
        try {
            servicio.crearPedido(pedido);
            System.out.println("Pedido creado con éxito! Monto: " + servicio.calcularMontoTotal(pedido));
        } catch (Exception e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    public void mostrarPedido(int id) {
        Pedido pedido = servicio.buscarPedido(id);
        if (pedido != null) {
            System.out.println("Pedido de " + pedido.getCliente() + " con monto: " + pedido.getMonto());
        } else {
            System.out.println("Pedido no encontrado");
        }
    }
}
