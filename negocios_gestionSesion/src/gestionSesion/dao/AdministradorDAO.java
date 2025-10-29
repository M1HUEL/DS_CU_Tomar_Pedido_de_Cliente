package gestionSesion.dao;

import gestionSesion.objetosNegocio.Administrador;

public class AdministradorDAO {

    public Administrador buscarPorNombre(String nombre) {
        return null;
    }

    public boolean validarCredenciales(String nombre, String contraseña) {
        Administrador administrador = buscarPorNombre(nombre);
        if (administrador == null) {
            return false;
        }

        return administrador.getContraseña().equals(contraseña);
    }
}
