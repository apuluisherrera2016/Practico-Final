/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

import java.util.Date;

/**
 *
 * @author Luis
 */
public class Perfil {
    private int codigo;
    private String nombre;
    private String apellido;
    private int dni;
    private Date fechaNac;
    private String email;
    private int usuario;

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Perfil() {
    }

    public Perfil(int codigo, String nombre, String apellido, int dni, Date fechaNac, String email, int usuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.email = email;
        this.usuario = usuario;
    }
    
    
}

