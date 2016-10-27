package org.jgc.herbarium.be;
// Generated 03/10/2016 12:07:52 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Component;

/**
 * Usuario generated by hbm2java
 */
@Component
public class Usuario  implements java.io.Serializable {


     private Long idusuario;
     private Persona persona;
     private String usuario;
     private String password;
     private Date fechaRegistro;
     private Boolean estado;
     private Set usuarioRols = new HashSet(0);

    public Usuario() {
    }

	
    public Usuario(Persona persona) {
        this.persona = persona;
    }
    public Usuario(Persona persona, String usuario, String password, Date fechaRegistro, Boolean estado, Set usuarioRols) {
       this.persona = persona;
       this.usuario = usuario;
       this.password = password;
       this.fechaRegistro = fechaRegistro;
       this.estado = estado;
       this.usuarioRols = usuarioRols;
    }
   
    public Long getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }
    
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public Boolean getEstado() {
        return this.estado;
    }
    
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    public Set getUsuarioRols() {
        return this.usuarioRols;
    }
    
    public void setUsuarioRols(Set usuarioRols) {
        this.usuarioRols = usuarioRols;
    }




}

