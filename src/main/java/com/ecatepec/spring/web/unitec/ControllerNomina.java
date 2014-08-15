/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author ruben
 */
@Controller
@RequestMapping("/")
public class ControllerNomina {
    @RequestMapping(value = "/nomina/{saldo}",method = RequestMethod.GET,headers = {"Accep=text/html"})
   public @ResponseBody String mensajito(@PathVariable Float saldo){
           DAONominaImpl d= new DAONominaImpl();
           d.agregarNomina(new Nomina(saldo));
           return "Usuario guardado con exito";
}
}
