package gestionSesion;

public class ControladorSesion {

    private ServicioSesion servicio;

    public ControladorSesion(ServicioSesion servicioSesion) {
        this.servicio = servicioSesion;
    }

    public String iniciarSesion(String username, String password) {
        String rol = servicio.iniciarSesion(username, password);

        if (rol != null) {
            System.out.println("Bienvenido, " + username + " (" + rol + ")");
        } else {
            System.out.println("Usuario o contraseña incorrectos");
        }

        return rol;
    }

    public void cerrarSesion(String username, String rol) {
        servicio.cerrarSesion(username);
    }

}
