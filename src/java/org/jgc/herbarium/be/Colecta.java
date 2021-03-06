package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Colecta generated by hbm2java
 */
@Component
public class Colecta  implements java.io.Serializable {


     private Long idcolecta;
     private Distrito distrito;
     private Especie especie;
     private Formacion formacion;
     private String localidad;
     private String zonaUtm;
     private String coordenada1Utm;
     private String coordenada2Utm;
     private Serializable latitud;
     private Serializable longitud;
     private Integer altitud;
     private Date fechaColecta;
     private String descripcion;
     private String observacion;
     private Set colectaPersonas = new HashSet(0);
     private Set ejemplars = new HashSet(0);
     private Set fotografias = new HashSet(0);

    public Colecta() {
        this.idcolecta = null;
        this.especie = new Especie();
        this.distrito = new Distrito();
        this.formacion = new Formacion();
    }

	
    public Colecta(Distrito distrito, Especie especie) {
        this.distrito = distrito;
        this.especie = especie;
    }
    public Colecta(Distrito distrito, Especie especie, Formacion formacion, String localidad, String zonaUtm, String coordenada1Utm, String coordenada2Utm, Serializable latitud, Serializable longitud, Integer altitud, Date fechaColecta, String descripcion, String observacion, Set colectaPersonas, Set ejemplars, Set fotografias) {
       this.distrito = distrito;
       this.especie = especie;
       this.formacion = formacion;
       this.localidad = localidad;
       this.zonaUtm = zonaUtm;
       this.coordenada1Utm = coordenada1Utm;
       this.coordenada2Utm = coordenada2Utm;
       this.latitud = latitud;
       this.longitud = longitud;
       this.altitud = altitud;
       this.fechaColecta = fechaColecta;
       this.descripcion = descripcion;
       this.observacion = observacion;
       this.colectaPersonas = colectaPersonas;
       this.ejemplars = ejemplars;
       this.fotografias = fotografias;
    }
   
    public Long getIdcolecta() {
        return this.idcolecta;
    }
    
    public void setIdcolecta(Long idcolecta) {
        this.idcolecta = idcolecta;
    }
    public Distrito getDistrito() {
        return this.distrito;
    }
    
    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }
    public Especie getEspecie() {
        return this.especie;
    }
    
    public void setEspecie(Especie especie) {
        this.especie = especie;
    }
    public Formacion getFormacion() {
        return this.formacion;
    }
    
    public void setFormacion(Formacion formacion) {
        this.formacion = formacion;
    }
    public String getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public String getZonaUtm() {
        return this.zonaUtm;
    }
    
    public void setZonaUtm(String zonaUtm) {
        this.zonaUtm = zonaUtm;
    }
    public String getCoordenada1Utm() {
        return this.coordenada1Utm;
    }
    
    public void setCoordenada1Utm(String coordenada1Utm) {
        this.coordenada1Utm = coordenada1Utm;
    }
    public String getCoordenada2Utm() {
        return this.coordenada2Utm;
    }
    
    public void setCoordenada2Utm(String coordenada2Utm) {
        this.coordenada2Utm = coordenada2Utm;
    }
    public Serializable getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(Serializable latitud) {
        this.latitud = latitud;
    }
    public Serializable getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(Serializable longitud) {
        this.longitud = longitud;
    }
    public Integer getAltitud() {
        return this.altitud;
    }
    
    public void setAltitud(Integer altitud) {
        this.altitud = altitud;
    }
    public Date getFechaColecta() {
        return this.fechaColecta;
    }
    
    public void setFechaColecta(Date fechaColecta) {
        this.fechaColecta = fechaColecta;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Set getColectaPersonas() {
        return this.colectaPersonas;
    }
    
    public void setColectaPersonas(Set colectaPersonas) {
        this.colectaPersonas = colectaPersonas;
    }
    public Set getEjemplars() {
        return this.ejemplars;
    }
    
    public void setEjemplars(Set ejemplars) {
        this.ejemplars = ejemplars;
    }
    public Set getFotografias() {
        return this.fotografias;
    }
    
    public void setFotografias(Set fotografias) {
        this.fotografias = fotografias;
    }




}


