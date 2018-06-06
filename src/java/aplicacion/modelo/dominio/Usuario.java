/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.io.Serializable;

/**
 *En esta clase definiremos los atrivutos de la clase usuario
 * 
 */
public class Usuario implements Serializable{
    private int codigo;
    private String nombre;
    private String password;
    private String tipoUsuario;
    private boolean estado;

    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario(int codigo, String nombre, String password, String tipoUsuario, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.estado = estado;
    }

    public Usuario() {
    }
    
}
