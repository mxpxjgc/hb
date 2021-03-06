package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Habito generated by hbm2java
 */
@Component
public class Habito  implements java.io.Serializable {


     private Long idhabito;
     private String nombrehabito;
     private Boolean estado;
     private Set especies = new HashSet(0);

    public Habito() {
    }

    public Habito(String nombrehabito, Boolean estado, Set especies) {
       this.nombrehabito = nombrehabito;
       this.estado = estado;
       this.especies = especies;
    }
   
    public Long getIdhabito() {
        return this.idhabito;
    }
    
    public void setIdhabito(Long idhabito) {
        this.idhabito = idhabito;
    }
    public String getNombrehabito() {
        return this.nombrehabito;
    }
    
    public void setNombrehabito(String nombrehabito) {
        this.nombrehabito = nombrehabito;
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


