/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.tomarPedido;

import dto.PedidoDTO;
import dto.DetallePedidoDTO;
import java.sql.SQLException;
import java.util.List;

/**
 * Servicio encargado de procesar pedidos. Autor: José Antonio González Valle
 */
public class PedidoService {

    private PedidoDAO pedidoDAO;

    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void procesarPedido(PedidoDTO pedido, List<DetallePedidoDTO> detalles) throws SQLException {
        double total = 0;
        for (DetallePedidoDTO d : detalles) {
            total += d.getPrecioUnitario() * d.getCantidad();
        }
        pedido.setTotal(total);
        pedido.setEstado("En preparación");
        pedidoDAO.insertarPedido(pedido);
    }
}
