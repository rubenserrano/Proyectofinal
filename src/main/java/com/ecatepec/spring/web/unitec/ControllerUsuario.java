/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author T107
 */
@Controller
@RequestMapping("/")

public class ControllerUsuario {
    @RequestMapping(value="/usuario/{nombre}/{sueldo}",method =RequestMethod.GET,headers = {"Accept=text/html"} )
 public @ResponseBody String mensajito(@PathVariable String nombre, @PathVariable Float sueldo){
           DAOUsuarioImpl d= new DAOUsuarioImpl();
           d.agregarUsuario(new Usuario(nombre, sueldo));
           return "Usuario guardado con exito";
    }
 
  @RequestMapping(value="/usuario", method=RequestMethod.GET, headers={"Accept=application/json"})
    public @ResponseBody String metodo2()throws Exception {
        DAOUsuarioImpl d=new DAOUsuarioImpl();
        ObjectMapper maper=new ObjectMapper();
            
        return maper.writeValueAsString(d.buscarTodosUsuario());
    }
    }
