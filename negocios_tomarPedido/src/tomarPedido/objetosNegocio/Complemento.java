package tomarPedido.objetosNegocio;

public class Complemento {

    private int id;
    private String nombre;
    private double precio;

    public Complemento() {
    }

    public Complemento(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Complemento{" + "id=" + id + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

}
