/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.forms;

import aplicacion.controlador.bean.UsuarioBean;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luis
 */
@ManagedBean
@SessionScoped
public class LoginFormBean implements Serializable{
    private String nombre;
    private String password;
    
    @ManagedProperty(value = "#{usuarioBean")
    private UsuarioBean usuarioBean;
    /**
     * Creates a new instance of LoginFormBean
     */
    public LoginFormBean() {
    }
    
    public void validar(){
        usuarioBean.getUsuario().setNombre(nombre);
        usuarioBean.getUsuario().setPassword(password);
        boolean esValido = usuarioBean.validar();
        if(esValido==true){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Es valido"));
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Es invalido"));
        }
    }

    /**
     * @return the usuarioBean
     */
    public UsuarioBean getUsuarioBean() {
        return usuarioBean;
    }

    /**
     * @param usuarioBean the usuarioBean to set
     */
    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
