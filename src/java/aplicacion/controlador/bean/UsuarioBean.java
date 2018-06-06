/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.bean;

import aplicacion.dato.hibernate.dao.UsuarioDAO;
import aplicacion.dato.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable{
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;
    
    
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
    }

    @PostConstruct
    public void init(){
        usuario = new Usuario();
        usuarioDAO = new UsuarioDAOImp();
    }
    
    public boolean validar(){
        return usuarioDAO.validar(usuario.getNombre(), usuario.getPassword());
    }
    
    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuarioDAO
     */
    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    /**
     * @param usuarioDAO the usuarioDAO to set
     */
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    
}


