package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Ejemplar generated by hbm2java
 */
@Component
public class Ejemplar  implements java.io.Serializable {


     private Long idejemplar;
     private Casillero casillero;
     private Colecta colecta;
     private Date fechaRegistro;
     private Integer numeroEjemplar;
     private String observacion;
     private Boolean estado;
     private Set imagens = new HashSet(0);

    public Ejemplar() {
    }

	
    public Ejemplar(Casillero casillero, Colecta colecta) {
        this.casillero = casillero;
        this.colecta = colecta;
    }
    public Ejemplar(Casillero casillero, Colecta colecta, Date fechaRegistro, Integer numeroEjemplar, String observacion, Boolean estado, Set imagens) {
       this.casillero = casillero;
       this.colecta = colecta;
       this.fechaRegistro = fechaRegistro;
       this.numeroEjemplar = numeroEjemplar;
       this.observacion = observacion;
       this.estado = estado;
       this.imagens = imagens;
    }
   
    public Long getIdejemplar() {
        return this.idejemplar;
    }
    
    public void setIdejemplar(Long idejemplar) {
        this.idejemplar = idejemplar;
    }
    public Casillero getCasillero() {
        return this.casillero;
    }
    
    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }
    public Colecta getColecta() {
        return this.colecta;
    }
    
    public void setColecta(Colecta colecta) {
        this.colecta = colecta;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Integer getNumeroEjemplar() {
        return this.numeroEjemplar;
    }
    
    public void setNumeroEjemplar(Integer numeroEjemplar) {
        this.numeroEjemplar = numeroEjemplar;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getImagens() {
        return this.imagens;
    }
    
    public void setImagens(Set imagens) {
        this.imagens = imagens;
    }




}


