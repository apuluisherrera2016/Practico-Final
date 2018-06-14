/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.controlador.beans;
import aplicacion.modelo.dominio.Usuario;
import aplicacion.datos.hibernate.dao.imp.PerfilDAOImp;
import aplicacion.modelo.dominio.Perfil;
import java.util.List;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author candeluchi
 */
@ManagedBean
@ViewScoped
public class PerfilBean {
    private Perfil perfil;
    /**
     * Creates a new instance of PerfilBean
     */
    public PerfilBean() {
        perfil = new Perfil();
    }

    /**
     * @return the perfil
     */
    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public List<Perfil> obtenerPerfiles(){
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        return perfilDAOImp.getPerfiles();
    }
    
    public void agregarPerfil(){
        System.out.println(this.perfil.getUsuario().getNombreUsuario());
        PerfilDAOImp perfilDAOImp = new PerfilDAOImp();
        this.perfil.setDireccion("asdfasdf");
        this.perfil.setDni("24234");
        this.perfil.setEmail("alfredo@hotmail.com");
        this.perfil.setFechaNac(new Date());
        this.perfil.setTelefono("43234243");
        perfilDAOImp.add(this.perfil);
    }
}
