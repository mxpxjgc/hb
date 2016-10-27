package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Familia generated by hbm2java
 */
@Component
public class Familia  implements java.io.Serializable {


     private Long idfamilia;
     private String denominacion;
     private String abreviatura;
     private Boolean estado;
     private Set generos = new HashSet(0);

    public Familia() {
    }

    public Familia(String denominacion, String abreviatura, Boolean estado, Set generos) {
       this.denominacion = denominacion;
       this.abreviatura = abreviatura;
       this.estado = estado;
       this.generos = generos;
    }
   
    public Long getIdfamilia() {
        return this.idfamilia;
    }
    
    public void setIdfamilia(Long idfamilia) {
        this.idfamilia = idfamilia;
    }
    public String getDenominacion() {
        return this.denominacion;
    }
    
    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getGeneros() {
        return this.generos;
    }
    
    public void setGeneros(Set generos) {
        this.generos = generos;
    }




}


