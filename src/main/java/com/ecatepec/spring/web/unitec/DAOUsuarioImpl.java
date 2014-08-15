/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;
import static com.ecatepec.spring.web.unitec.DAO.close;
import static com.ecatepec.spring.web.unitec.DAO.getSession;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
/**
 *
 * @author T107
 */
public class DAOUsuarioImpl extends  DAO{
  public void agregarUsuario(Usuario usuario) {
    begin();
    getSession().save(usuario);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Usuario> buscarTodosUsuario() {
        begin();
        Query q = getSession().createQuery("from usuario");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Usuario> usuarios = (ArrayList<Usuario>)q.list();
        commit();
        close();
         
return usuarios; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarUsuario(Usuario p){
            begin();
             getSession().delete(p);
            commit();
            close();
 }   
        /**
         * Este metodo busca un cliente por medio de su Id
         * @param id Este parametro es el Id del cliente que se quiere buscar
         * @return El tipo de retorno es el cliente buscado
         */
  public Usuario buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Usuario where id = :id");
        q.setInteger("id",id);
        Usuario p = (Usuario)q.uniqueResult();
        commit();
        close();
return p;  
   
  }  
}

