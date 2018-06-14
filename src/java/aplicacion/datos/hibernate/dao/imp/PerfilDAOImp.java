/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IPerfilDAO;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author candeluchi
 */
public class PerfilDAOImp implements IPerfilDAO{

    @Override
    public List<Perfil> getPerfiles() {
        ArrayList<Perfil> perfiles = new ArrayList();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Perfil.class);
        if (!(criteria.list().isEmpty())){
             perfiles = (ArrayList<Perfil>)criteria.list();
        }
        return perfiles; 
    }

    @Override
    public void add(Perfil perfil) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        sesion.beginTransaction();
        //Usuario u = new Usuario();
        //u.setCodigo(1);
        sesion.save(perfil);
        sesion.getTransaction().commit();
        sesion.close();  
    }
    
}
