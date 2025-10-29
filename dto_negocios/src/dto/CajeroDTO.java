/*
 * CajeroDTO.java
 *
 */
package dto;

/**
 *
 * @author Miguel Ángel Sánchez Sotelo
 */
public class CajeroDTO {

    private int id;
    private String nombre;
    private String contraseña;
    private String turno;
    private String telefono;

    public CajeroDTO() {
    }

    public CajeroDTO(int id, String nombre, String contraseña, String turno, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.turno = turno;
        this.telefono = telefono;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "CajeroDTO{" + "id=" + id + ", nombre=" + nombre + ", contrase\u00f1a=" + contraseña + ", turno=" + turno + ", telefono=" + telefono + '}';
    }

}
