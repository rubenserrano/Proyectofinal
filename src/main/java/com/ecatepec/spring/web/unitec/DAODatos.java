/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;

import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author ruben
 */
public class DAODatos extends DAO{
    
    public void agregarDato(Datos dato) {
   begin();
    getSession().save(dato);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Datos> buscarTodosDatos() {
        begin();
        Query q = getSession().createQuery("from Datos");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Datos> datos = (ArrayList<Datos>)q.list();
        commit();
        close();
         
return datos; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarDatos(Datos p){
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
  public Datos buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Datos where id = :id");
        q.setInteger("id",id);
        Datos p = (Datos)q.uniqueResult();
        commit();
        close();
return p;  
    
}
    
}
