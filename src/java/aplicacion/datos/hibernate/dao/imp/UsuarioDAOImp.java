/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author luis
 */
public class UsuarioDAOImp implements IUsuarioDAO{

    @Override
    public Usuario validarUsuario(String nombreUsuario, String password) {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        criteria.add(Restrictions.like("password", password));
        criteria.add(Restrictions.eq("estado", true));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;
    }
    
        @Override
    public Usuario validarUsuarioAdmin() {
        Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("tipoUsuario", "admin"));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;
    }

    @Override
    public Usuario validarUsuarioSupervisor() {
               Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("tipoUsuario", "supervisor"));
        criteria.add(Restrictions.like("tipoUsuario", "admin"));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;
    }

    @Override
    public Usuario validarUsuarioFinal() {
            Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("tipoUsuario", "final"));
        criteria.add(Restrictions.like("tipoUsuario", "admin"));
        criteria.add(Restrictions.like("tipoUsuario", "supervisor"));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;
    }

    @Override
    public void modificar(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(usuario);
        session.getTransaction().commit();
        
    }

    @Override
    public void agregarUsuario(Usuario nuevoUsuario) {
        nuevoUsuario.setEstado(true);
        Session session= null;          
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(nuevoUsuario);
        session.getTransaction().commit();
       session.close();
        
        /*
 *  } catch (Exeption e){
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally{
            if(session != null)
                session.close();
        }
 */ 
    }
    
    
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
    Usuario usuario = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Usuario.class);
        criteria.add(Restrictions.like("nombreUsuario", nombreUsuario));
        if(!criteria.list().isEmpty()){
            usuario = (Usuario)criteria.list().get(0);
        }
        return usuario;}

    
    
    @Override
    public void eliminarUsuario(Usuario usuario) {
       Session session = HibernateUtil.getSessionFactory().openSession();
       session.beginTransaction();
       session.delete(usuario);
       session.getTransaction().commit();
     
    }
    @Override
    public List <Usuario> mostrarUsuarios(){
        List <Usuario> listaUsuarios=null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Usuario");
        listaUsuarios =(List <Usuario>) query.list();
        return listaUsuarios;
    }


        
    }
