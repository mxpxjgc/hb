package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1

import org.springframework.stereotype.Component;




/**
 * ColectaPersona generated by hbm2java
 */
@Component
public class ColectaPersona  implements java.io.Serializable {


     private Long idcolectapersona;
     private Colecta colecta;
     private Persona persona;
     private Long tipo;
     private Integer numeroColecta;

    public ColectaPersona() {
    }

    public ColectaPersona(Colecta colecta, Persona persona, Long tipo, Integer numeroColecta) {
       this.colecta = colecta;
       this.persona = persona;
       this.tipo = tipo;
       this.numeroColecta = numeroColecta;
    }
   
    public Long getIdcolectapersona() {
        return this.idcolectapersona;
    }
    
    public void setIdcolectapersona(Long idcolectapersona) {
        this.idcolectapersona = idcolectapersona;
    }
    public Colecta getColecta() {
        return this.colecta;
    }
    
    public void setColecta(Colecta colecta) {
        this.colecta = colecta;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Long getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Long tipo) {
        this.tipo = tipo;
    }
    public Integer getNumeroColecta() {
        return this.numeroColecta;
    }
    
    public void setNumeroColecta(Integer numeroColecta) {
        this.numeroColecta = numeroColecta;
    }




}

