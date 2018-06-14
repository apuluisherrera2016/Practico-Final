/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;
import java.util.List;

/**
 *
 * @author candeluchi
 */
public interface IPerfilDAO {
    public List<Perfil> getPerfiles();
    public void add(Perfil perfil);    
}
