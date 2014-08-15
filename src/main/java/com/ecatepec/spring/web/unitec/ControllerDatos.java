/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;

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
public class ControllerDatos {
    @RequestMapping(value="/Datos/{APaterno}/{AMaterno}",method = RequestMethod.GET,headers = {"Accep=text/html"})
 public @ResponseBody String mensajito(@PathVariable String APaterno, @PathVariable String AMaterno){
           DAODatos d= new DAODatos();
           d.agregarDato(new Datos(APaterno, AMaterno));
           return "Usuario guardado con exito";
    }
}
