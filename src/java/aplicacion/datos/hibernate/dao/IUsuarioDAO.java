/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Usuario;
import java.util.List;

/**
 *
 * @author candeluchi
 */
public interface IUsuarioDAO {
        /**
     * Valida la existencia de un usuario
     * @param nombreUsuario
     * @param password
     * @return null si no existe. 
     */
 Usuario validarUsuario(String nombreUsuario, String password);
 Usuario validarUsuarioAdmin();
 Usuario validarUsuarioSupervisor();
 Usuario validarUsuarioFinal();
    void modificar(Usuario usuario);
    Usuario obtenerUsuario(String nombreUsuario);
    void agregarUsuario(Usuario nuevoUsuario);
    void eliminarUsuario(Usuario usuario);
    
    List <Usuario> mostrarUsuarios();
}
