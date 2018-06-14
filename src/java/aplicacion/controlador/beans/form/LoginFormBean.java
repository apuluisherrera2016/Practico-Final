/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans.form;


import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.dao.imp.UsuarioDAOImp;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * grupo 5
 */
@ManagedBean
@ViewScoped
public class LoginFormBean implements Serializable{

    /**
     * Definicion de atributos de la clase
     */
    
    private String nombreUsuario;
    private String password;
    private String nuevoNombreUsuario;
    private String nuevoPasswordUsuario;
    private boolean nuevoEstadoUsuario;
    
    /**
     * Metodo que agrega un objeto en la base de datos, no recive ningun parametro 
     */
    public void registrarUsuarioFinal(){
       Usuario nuevoUsuario= new Usuario();
       nuevoUsuario.setNombreUsuario(nuevoNombreUsuario);
       nuevoUsuario.setPassword(nuevoPasswordUsuario);
       nuevoUsuario.setTipoUsuario("final");
       
       IUsuarioDAO iusuarioDAO = new UsuarioDAOImp();
       iusuarioDAO.agregarUsuario(nuevoUsuario);
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario registrado", "Usuario registrado exitosamente");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);

    }
    
    
 boolean validarUsuarioAdmin(){
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        Usuario usuario = usuarioDAO.validarUsuarioAdmin();
        if(usuario!=null){
            return true;  
        }else{
       return false;
        }
 }
 boolean validarUsuarioSupervisor(){
             IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        Usuario usuario = usuarioDAO.validarUsuarioSupervisor();
        if(usuario!=null){
            return true;  
        }else{
       return false;
        }
 }
 boolean validarUsuarioFinal(){
             IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        Usuario usuario = usuarioDAO.validarUsuarioFinal();
        if(usuario!=null){
            return true;  
        }else{
       return false;
        }
 }
    
    
    
    public String validarUsuario(){
  //este metodo realiza la validacion  de usuario , no recibe ningun parametro
        String resultado = null;
        IUsuarioDAO usuarioDAO = new UsuarioDAOImp();
        Usuario usuario = usuarioDAO.validarUsuario(nombreUsuario, password);
        
        if(usuario!=null){
            
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario válido", "Usuario válido");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioValidado", usuario);
            
            if(usuario.getTipoUsuario().equals("admin"))
               resultado = "admin?faces-redirect=true";
            else
            {
                if(usuario.getTipoUsuario().equals("final"))
                 resultado = "final?faces-redirect=true";
                else
                {
                    if(usuario.getTipoUsuario().equals("supervisor"))
                     resultado= "menu";
                    else
                        resultado = "login";
                        
                }
                    
            }
            
            
        }else{
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Credenciales Inválidas", "Credenciales Inválidas");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        return resultado;
    }
    
    public String getNombreUsuarioValidado(){
        //este metodo retorna el nombre del usuario logueado
        Usuario usuario = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado");
        return usuario.getNombreUsuario();
    }
    
    public String cerrarSesion(){
        //este metodo cierra la session y reedireccciona a la pagina de logeo
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Sesión Cerrada", "Sesión Cerrada");
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        
        String resultado = "login?faces-redirect=true";
        return resultado;
    }
    
    public boolean verificarSesion(){
        //este metodo verifica la session 
        boolean sesionValida = false;
        if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioValidado")!=null){
            sesionValida=true;
        }
        return sesionValida;
    }
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginFormBean() {
       
    }

    /**
     * @return the nombreUsuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * @param nombreUsuario the nombreUsuario to set
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public String getNuevoNombreUsuario() {
        return nuevoNombreUsuario;
    }

    public void setNuevoNombreUsuario(String nuevoNombreUsuario) {
        this.nuevoNombreUsuario = nuevoNombreUsuario;
    }

    public String getNuevoPasswordUsuario() {
        return nuevoPasswordUsuario;
    }

    public void setNuevoPasswordUsuario(String nuevoPasswordUsuario) {
        this.nuevoPasswordUsuario = nuevoPasswordUsuario;
    }

    public boolean isnEstado() {
        return nuevoEstadoUsuario;
    }

    public void setnEstado(boolean nEstado) {
        this.nuevoEstadoUsuario = nEstado;
    }

    
    
}
