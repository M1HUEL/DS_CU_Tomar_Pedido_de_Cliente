/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * DetallePedidoDTO.java
 *
 */
package dto;

/**
 * Data Transfer Object para representar el detalle de un pedido.
 * Incluye información sobre el platillo, cantidad y precio unitario.
 * Autor: [José Antonio González Valle]
 */
public class DetallePedidoDTO {

    private int id;
    private int idPedido;
    private String nombrePlatillo;
    private int cantidad;
    private double precioUnitario;

    public DetallePedidoDTO() {
    }

    public DetallePedidoDTO(int id, int idPedido, String nombrePlatillo, int cantidad, double precioUnitario) {
        this.id = id;
        this.idPedido = idPedido;
        this.nombrePlatillo = nombrePlatillo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombrePlatillo() {
        return nombrePlatillo;
    }

    public void setNombrePlatillo(String nombrePlatillo) {
        this.nombrePlatillo = nombrePlatillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "DetallePedidoDTO{" +
                "id=" + id +
                ", idPedido=" + idPedido +
                ", nombrePlatillo='" + nombrePlatillo + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                '}';
    }
}
