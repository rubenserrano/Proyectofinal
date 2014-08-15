/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;

import static com.ecatepec.spring.web.unitec.DAO.begin;
import java.util.ArrayList;
import org.hibernate.Query;

/**
 *
 * @author T107
 */
public class DAONominaImpl extends DAO{
     public void agregarNomina(Nomina nomina) {
   begin();
    getSession().save(nomina);
    commit();
    close();
    
    }
 
       /**
        * Este metodo obtiene todos los registros de la tabla cliente 
        * @return Este metodo nos regresa todos los clientes
        */
    public ArrayList<Nomina> buscarTodosNomina() {
        begin();
        Query q = getSession().createQuery("from Nomina");
      //  Criteria c=getSession().createCriteria(Alumno.class);
        ArrayList<Nomina> nominas = (ArrayList<Nomina>)q.list();
        commit();
        close();
         
return nominas; 
        
      
    }
    /**
     * Este metodo borra un cliente
     * @param p Se le debe pasar un parametro de tipo cliente para ser borrado
     */
 public void borrarNomina(Nomina p){
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
  public Nomina buscarPorId(int id){
      begin();
     Query q = getSession().createQuery("from Nomina where id = :id");
        q.setInteger("id",id);
        Nomina p = (Nomina)q.uniqueResult();
        commit();
        close();
return p;  
    
}
}
