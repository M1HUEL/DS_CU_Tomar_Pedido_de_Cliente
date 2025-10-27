/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dto;

import java.util.List;

/**
 * Data Transfer Object para representar un pedido.
 * Incluye la información del pedido y su detalle.
 * Autor: [José Antonio González Valle]
 */
public class PedidoDTO {

    private int id;
    private int idCajero;
    private String fecha; // Podría ser Date si prefieres manejar fechas
    private double total;
    private String estado;
    private List<DetallePedidoDTO> detalles; // Lista de detalles del pedido

    public PedidoDTO() {
    }

    public PedidoDTO(int id, int idCajero, String fecha, double total, String estado, List<DetallePedidoDTO> detalles) {
        this.id = id;
        this.idCajero = idCajero;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.detalles = detalles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCajero() {
        return idCajero;
    }

    public void setIdCajero(int idCajero) {
        this.idCajero = idCajero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetallePedidoDTO> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedidoDTO> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "id=" + id +
                ", idCajero=" + idCajero +
                ", fecha=" + fecha +
                ", total=" + total +
                ", estado=" + estado +
                ", detalles=" + detalles +
                '}';
    }
}
