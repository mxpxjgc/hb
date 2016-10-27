package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Genero generated by hbm2java
 */
@Component
public class Genero  implements java.io.Serializable {


     private Long idgenero;
     private Familia familia;
     private String denominacion;
     private String abreviatura;
     private Boolean estado;
     private Set especies = new HashSet(0);

    public Genero() {
        this.idgenero = null;
        this.familia = new Familia();
    }

	
    public Genero(Familia familia) {
        this.familia = familia;
    }
    public Genero(Familia familia, String denominacion, String abreviatura, Boolean estado, Set especies) {
       this.familia = familia;
       this.denominacion = denominacion;
       this.abreviatura = abreviatura;
       this.estado = estado;
       this.especies = especies;
    }
   
    public Long getIdgenero() {
        return this.idgenero;
    }
    
    public void setIdgenero(Long idgenero) {
        this.idgenero = idgenero;
    }
    public Familia getFamilia() {
        return this.familia;
    }
    
    public void setFamilia(Familia familia) {
        this.familia = familia;
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
    public Set getEspecies() {
        return this.especies;
    }
    
    public void setEspecies(Set especies) {
        this.especies = especies;
    }




}


