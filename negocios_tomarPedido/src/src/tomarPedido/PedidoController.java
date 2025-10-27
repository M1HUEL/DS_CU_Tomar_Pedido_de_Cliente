/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * PedidoController.java
 *
 */
package src.tomarPedido;

import dto.PedidoDTO;
import dto.DetallePedidoDTO;
import service.PedidoService;

import java.sql.SQLException;
import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones de pedidos. Autor: José
 * Antonio González Valle
 */
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }

    /**
     * Crea un nuevo pedido, delegando el procesamiento al servicio.
     *
     * @param pedido Objeto PedidoDTO con la información del pedido
     * @param detalles Lista de DetallePedidoDTO con los platillos del pedido
     */
    public void crearNuevoPedido(PedidoDTO pedido, List<DetallePedidoDTO> detalles) {
        try {
            service.procesarPedido(pedido, detalles);
            System.out.println("Pedido registrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al registrar el pedido: " + e.getMessage());
        }
    }

    /**
     * Actualiza el estado de un pedido.
     *
     * @param pedido PedidoDTO a actualizar
     * @param nuevoEstado Nuevo estado del pedido
     */
    public void actualizarEstadoPedido(PedidoDTO pedido, String nuevoEstado) {
        pedido.setEstado(nuevoEstado);
        try {
            service.getPedidoDAO().actualizarPedido(pedido);
            System.out.println("Estado del pedido actualizado a: " + nuevoEstado);
        } catch (SQLException e) {
            System.err.println("Error al actualizar el estado: " + e.getMessage());
        }
    }
}
