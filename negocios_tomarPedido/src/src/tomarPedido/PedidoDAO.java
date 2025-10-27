/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.tomarPedido;

import dto.PedidoDTO;
import dto.DetallePedidoDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para operaciones sobre pedidos. Autor: José Antonio González Valle
 */
public class PedidoDAO {

    private Connection conn;

    public PedidoDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     * Inserta un pedido y sus detalles en la base de datos. Asume las tablas: -
     * pedido (id, id_cajero, fecha, total, estado) - detalle_pedido (id,
     * id_pedido, nombre_platillo, cantidad, precio_unitario)
     *
     * @param pedido PedidoDTO con sus detalles en pedido.getDetalles()
     * @throws SQLException si ocurre un error en la BD
     */
    public void insertarPedido(PedidoDTO pedido) throws SQLException {
        String sqlPedido = "INSERT INTO pedido (id_cajero, fecha, total, estado) VALUES (?, ?, ?, ?)";

        // Desactivamos el auto-commit para hacer la inserción como transacción
        boolean previousAutoCommit = conn.getAutoCommit();
        conn.setAutoCommit(false);

        try (PreparedStatement psPedido = conn.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
            psPedido.setInt(1, pedido.getIdCajero());
            psPedido.setString(2, pedido.getFecha());
            psPedido.setDouble(3, pedido.getTotal());
            psPedido.setString(4, pedido.getEstado());

            int affectedRows = psPedido.executeUpdate();
            if (affectedRows == 0) {
                conn.rollback();
                throw new SQLException("No se pudo insertar el pedido, no se afectaron filas.");
            }

            // Obtener id generado
            try (ResultSet rsKeys = psPedido.getGeneratedKeys()) {
                if (rsKeys.next()) {
                    int generatedId = rsKeys.getInt(1);
                    pedido.setId(generatedId);
                } else {
                    conn.rollback();
                    throw new SQLException("No se pudo obtener el ID generado del pedido.");
                }
            }

            // Insertar detalles si existen
            if (pedido.getDetalles() != null && !pedido.getDetalles().isEmpty()) {
                insertarDetalles(pedido.getId(), pedido.getDetalles());
            }

            // commit de la transacción
            conn.commit();
        } catch (SQLException ex) {
            conn.rollback();
            throw ex;
        } finally {
            // Restaurar auto-commit al estado previo
            conn.setAutoCommit(previousAutoCommit);
        }
    }

    /**
     * Inserta los detalles de un pedido en la tabla detalle_pedido.
     *
     * @param idPedido id del pedido padre
     * @param detalles lista de DetallePedidoDTO
     * @throws SQLException si ocurre un error en la BD
     */
    private void insertarDetalles(int idPedido, List<DetallePedidoDTO> detalles) throws SQLException {
        String sqlDetalle = "INSERT INTO detalle_pedido (id_pedido, nombre_platillo, cantidad, precio_unitario) VALUES (?, ?, ?, ?)";

        try (PreparedStatement psDetalle = conn.prepareStatement(sqlDetalle)) {
            for (DetallePedidoDTO d : detalles) {
                psDetalle.setInt(1, idPedido);
                psDetalle.setString(2, d.getNombrePlatillo());
                psDetalle.setInt(3, d.getCantidad());
                psDetalle.setDouble(4, d.getPrecioUnitario());
                psDetalle.addBatch();
            }
            psDetalle.executeBatch();
        }
    }

    /**
     * Actualiza el pedido (estado y total principalmente).
     *
     * @param pedido PedidoDTO con id y nuevos valores
     * @throws SQLException si ocurre un error en la BD
     */
    public void actualizarPedido(PedidoDTO pedido) throws SQLException {
        String sql = "UPDATE pedido SET estado = ?, total = ? WHERE id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pedido.getEstado());
            ps.setDouble(2, pedido.getTotal());
            ps.setInt(3, pedido.getId());

            int rows = ps.executeUpdate();
            if (rows == 0) {
                throw new SQLException("No se encontró el pedido con id = " + pedido.getId());
            }
        }
    }

    /**
     * Obtiene un pedido por su id (incluye detalles).
     *
     * @param id id del pedido
     * @return PedidoDTO con sus detalles o null si no existe
     * @throws SQLException si ocurre un error en la BD
     */
    public PedidoDTO obtenerPedidoPorId(int id) throws SQLException {
        String sqlPedido = "SELECT id, id_cajero, fecha, total, estado FROM pedido WHERE id = ?";
        String sqlDetalles = "SELECT id, id_pedido, nombre_platillo, cantidad, precio_unitario FROM detalle_pedido WHERE id_pedido = ?";

        try (PreparedStatement psPedido = conn.prepareStatement(sqlPedido)) {
            psPedido.setInt(1, id);
            try (ResultSet rs = psPedido.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                PedidoDTO pedido = new PedidoDTO();
                pedido.setId(rs.getInt("id"));
                pedido.setIdCajero(rs.getInt("id_cajero"));
                pedido.setFecha(rs.getString("fecha"));
                pedido.setTotal(rs.getDouble("total"));
                pedido.setEstado(rs.getString("estado"));

                // Obtener detalles
                try (PreparedStatement psDet = conn.prepareStatement(sqlDetalles)) {
                    psDet.setInt(1, id);
                    try (ResultSet rsDet = psDet.executeQuery()) {
                        List<DetallePedidoDTO> detalles = new ArrayList<>();
                        while (rsDet.next()) {
                            DetallePedidoDTO d = new DetallePedidoDTO();
                            d.setId(rsDet.getInt("id"));
                            d.setIdPedido(rsDet.getInt("id_pedido"));
                            d.setNombrePlatillo(rsDet.getString("nombre_platillo"));
                            d.setCantidad(rsDet.getInt("cantidad"));
                            d.setPrecioUnitario(rsDet.getDouble("precio_unitario"));
                            detalles.add(d);
                        }
                        pedido.setDetalles(detalles);
                    }
                }
                return pedido;
            }
        }
    }

    // --- Puedes añadir más métodos útiles según necesites ---
    // listarPedidos(), eliminarPedido(), actualizarDetalle(), buscarPorFecha(), etc.
}
