/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.dato.hibernate.dao.imp;
import aplicacion.modelo.util.HibernateUtil;
import aplicacion.dato.hibernate.dao.UsuarioDAO;
import aplicacion.modelo.dominio.Usuario;
import java.io.Serializable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author luis
 */
public class UsuarioDAOImp implements Serializable, UsuarioDAO{

    @Override
    public boolean validar(String nombre, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombre", nombre));
        criteria.add(Restrictions.like("password", password));
        boolean esValido = true;
        if(criteria.list().isEmpty()){
            esValido = false;
        }
        session.close();
        return esValido;
    }
    
}