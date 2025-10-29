package gestionSesion.dao;

import gestionSesion.objetosNegocio.Cajero;

public class CajeroDAO {

    public Cajero buscarPorNombre(String nombre) {
        return null;
    }

    public boolean validarCredenciales(String nombre, String contraseña) {
        Cajero cajero = buscarPorNombre(nombre);
        if (cajero == null) {
            return false;
        }

        return cajero.getContraseña().equals(contraseña);
    }

}
