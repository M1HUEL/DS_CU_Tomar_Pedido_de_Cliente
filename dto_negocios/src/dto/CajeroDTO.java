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
    private String password;
    private String turno;
    private String telefono;

    public CajeroDTO() {
    }

    public CajeroDTO(int id, String nombre, String password, String turno, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "CajeroDTO{" + "id=" + id + ", nombre=" + nombre + ", password=" + password + ", turno=" + turno + ", telefono=" + telefono + '}';
    }

}
