/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dato.hibernate.dao;

/**
 *
 * @author Luis
 */
public interface UsuarioDAO {
    boolean validar(String nombre, String password);
}
