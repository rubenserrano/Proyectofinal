/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ecatepec.spring.web.unitec;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author T107
 */
@Entity
@Table(name = "datos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datos.findAll", query = "SELECT d FROM Datos d"),
    @NamedQuery(name = "Datos.findByIdDatos", query = "SELECT d FROM Datos d WHERE d.idDatos = :idDatos"),
    @NamedQuery(name = "Datos.findByAPaterno", query = "SELECT d FROM Datos d WHERE d.aPaterno = :aPaterno"),
    @NamedQuery(name = "Datos.findByAMaterno", query = "SELECT d FROM Datos d WHERE d.aMaterno = :aMaterno")})
public class Datos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_datos")
    private Integer idDatos;
    @Size(max = 80)
    @Column(name = "aPaterno")
    private String aPaterno;
    @Size(max = 80)
    @Column(name = "aMaterno")
    private String aMaterno;
    @JoinColumn(name = "id_nomina", referencedColumnName = "id_nomina")
    @ManyToOne
    private Nomina idNomina;

    public Datos() {
    }

    public Datos(Integer idDatos) {
        this.idDatos = idDatos;
    }

    public Integer getIdDatos() {
        return idDatos;
    }

    public void setIdDatos(Integer idDatos) {
        this.idDatos = idDatos;
    }

    public String getAPaterno() {
        return aPaterno;
    }

    public void setAPaterno(String aPaterno) {
        this.aPaterno = aPaterno;
    }

    public String getAMaterno() {
        return aMaterno;
    }

    public void setAMaterno(String aMaterno) {
        this.aMaterno = aMaterno;
    }

    public Nomina getIdNomina() {
        return idNomina;
    }

    public void setIdNomina(Nomina idNomina) {
        this.idNomina = idNomina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDatos != null ? idDatos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datos)) {
            return false;
        }
        Datos other = (Datos) object;
        if ((this.idDatos == null && other.idDatos != null) || (this.idDatos != null && !this.idDatos.equals(other.idDatos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ecatepec.spring.web.unitec.Datos[ idDatos=" + idDatos + " ]";
    }

    public Datos(String aPaterno, String aMaterno) {
        this.aPaterno = aPaterno;
        this.aMaterno = aMaterno;
    }
    
}
