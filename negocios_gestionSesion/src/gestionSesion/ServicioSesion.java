package gestionSesion;

import gestionSesion.dao.AdministradorDAO;
import gestionSesion.dao.CajeroDAO;

public class ServicioSesion {

    private CajeroDAO cajeroDAO;
    private AdministradorDAO administradorDAO;

    public ServicioSesion(CajeroDAO cajeroDAO, AdministradorDAO administradorDAO) {
        this.cajeroDAO = cajeroDAO;
        this.administradorDAO = administradorDAO;
    }

    public String iniciarSesion(String username, String password) {
        if (username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Usuario y contraseña no pueden estar vacíos");
        }

        if (cajeroDAO.validarCredenciales(username, password)) {
            return "CAJERO";
        }

        if (administradorDAO.validarCredenciales(username, password)) {
            return "ADMIN";
        }

        System.out.println("Usuario o contraseña incorrectos");
        return null;
    }

    public void cerrarSesion(String username) {
        System.out.println("Sesión cerrada para: " + username);
    }
}
