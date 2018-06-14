/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;

import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Luis
 */
@ManagedBean
@SessionScoped
public class UsuarioFormBean {

    /**
     * Creates a new instance of UsuarioFormBean
     */
    
     private List<Usuario> lista= new ArrayList() ;
    private Usuario usuarioSeleccionado;

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }
    
    public UsuarioFormBean() {
    }

    public List<Usuario> getLista() {
        return lista;
    }

    public void setLista(List<Usuario> lista) {
        this.lista = lista;
    }
    public void listaUsuarios(){
      
         IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        lista = usuarioDAO.mostrarUsuarios();
       
    }
    public void actualizar()
    {
         IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        usuarioDAO.modificar(usuarioSeleccionado);
    }
    
    public void seleccionarUsuario(Usuario usuario){
        this.usuarioSeleccionado= usuario;
    }
    
}
