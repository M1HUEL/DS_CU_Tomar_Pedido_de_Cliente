package tomarPedido.objetosNegocio;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private int id;
    private String cliente;
    private double monto;
    private List<Ingrediente> ingredientes = new ArrayList<>();
    private List<Complemento> complementos = new ArrayList<>();
    private String comentario;

    public Pedido() {
    }

    public Pedido(int id, String cliente, double monto, String comentario) {
        this.id = id;
        this.cliente = cliente;
        this.monto = monto;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public List<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public List<Complemento> getComplementos() {
        return complementos;
    }

    public void setComplementos(List<Complemento> complementos) {
        this.complementos = complementos;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", cliente=" + cliente + ", monto=" + monto + ", ingredientes=" + ingredientes + ", complementos=" + complementos + ", comentario=" + comentario + '}';
    }

}
