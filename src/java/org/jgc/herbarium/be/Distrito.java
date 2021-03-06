package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Distrito generated by hbm2java
 */
@Component
public class Distrito  implements java.io.Serializable {


     private Long iddistrito;
     private Provincia provincia;
     private Integer codDistrito;
     private String denominacion;
     private Set colectas = new HashSet(0);

    public Distrito() {        
        this.iddistrito = null;
        this.provincia = new Provincia();    
    }

	
    public Distrito(Provincia provincia) {
        this.provincia = provincia;
    }
    public Distrito(Provincia provincia, Integer codDistrito, String denominacion, Set colectas) {
       this.provincia = provincia;
       this.codDistrito = codDistrito;
       this.denominacion = denominacion;
       this.colectas = colectas;
    }
   
    public Long getIddistrito() {
        return this.iddistrito;
    }
    
    public void setIddistrito(Long iddistrito) {
        this.iddistrito = iddistrito;
    }
    public Provincia getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    public Integer getCodDistrito() {
        return this.codDistrito;
    }
    
    public void setCodDistrito(Integer codDistrito) {
        this.codDistrito = codDistrito;
    }
    public String getDenominacion() {
        return this.denominacion;
    }
    
    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
    public Set getColectas() {
        return this.colectas;
    }
    
    public void setColectas(Set colectas) {
        this.colectas = colectas;
    }




}


