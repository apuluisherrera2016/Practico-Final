/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.controlador.beans.PerfilBean;
import aplicacion.modelo.dominio.Perfil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author candeluchi
 */
@ManagedBean
@ViewScoped
public class PerfilFormBean {
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    /**
     * Creates a new instance of PerfilFormBean
     */
    public PerfilFormBean() {
    }

    /**
     * @return the perfilBean
     */
    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    /**
     * @param perfilBean the perfilBean to set
     */
    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    public List<Perfil> obtenerPerfiles(){
        return (getPerfilBean().obtenerPerfiles());
    } 
    
    public void guardarPerfil(){
        perfilBean.agregarPerfil();
    }
    
}
