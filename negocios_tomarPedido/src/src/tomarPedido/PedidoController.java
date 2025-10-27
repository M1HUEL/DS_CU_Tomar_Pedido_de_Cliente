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

    public void crearNuevoPedido(PedidoDTO pedido, List<DetallePedidoDTO> detalles) {
        try {
            service.procesarPedido(pedido, detalles);
            System.out.println("Pedido registrado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al registrar el pedido: " + e.getMessage());
        }
    }
}
