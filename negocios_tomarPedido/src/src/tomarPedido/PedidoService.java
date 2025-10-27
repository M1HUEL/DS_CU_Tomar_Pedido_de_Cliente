/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.tomarPedido;

import dto.PedidoDTO;
import dto.DetallePedidoDTO;
import dao.PedidoDAO;

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

    /**
     * Procesa un pedido: calcula total, asigna estado y lo guarda en la base de
     * datos.
     *
     * @param pedido Objeto PedidoDTO que contiene los datos del pedido
     * @param detalles Lista de DetallePedidoDTO con los platillos y cantidades
     * @throws SQLException si ocurre un error al insertar el pedido
     */
    public void procesarPedido(PedidoDTO pedido, List<DetallePedidoDTO> detalles) throws SQLException {
        double total = 0;

        // Calcula el total sumando cantidad * precioUnitario de cada detalle
        for (DetallePedidoDTO detalle : detalles) {
            total += detalle.getCantidad() * detalle.getPrecioUnitario();
        }

        // Asigna total y estado
        pedido.setTotal(total);
        pedido.setEstado("En preparación");
        pedido.setDetalles(detalles);

        // Guarda el pedido usando el DAO
        pedidoDAO.insertarPedido(pedido);

        System.out.println("Pedido procesado correctamente. Total: $" + total);
    }

    /**
     * Devuelve el DAO para operaciones adicionales desde el controlador.
     */
    public PedidoDAO getPedidoDAO() {
        return this.pedidoDAO;
    }
}
