/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.cv;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.jgc.herbarium.be.Rol;
import org.jgc.herbarium.be.Usuario;
import org.jgc.herbarium.be.UsuarioRol;
import org.jgc.herbarium.bl.RolBL;
import org.jgc.herbarium.bl.UsuarioBL;
import org.jgc.herbarium.bl.UsuarioRolBL;

/**
 *
 * @author JorgeLuis
 */
@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;

    @ManagedProperty(value = "#{usuarioRolBL}")
    private UsuarioRolBL usuarioRolBL;
   
    @ManagedProperty(value = "#{usuarioRol}")
    private UsuarioRol usuarioRol;

    @ManagedProperty(value = "#{rolBL}")
    private RolBL rolBL;
    
    @ManagedProperty(value = "#{rol}")
    private Rol rol;

    private String nombreUsuario;
    private String password;

    public LoginController() {
        HttpSession sesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        sesion.setMaxInactiveInterval(5000);
    }

    public String login() {
        String url = "";
        //Obtenemos los datos del usuario
        Usuario temp = getUsuarioBL().buscar(this.getNombreUsuario());
        //Obtenemos los datos del usuario vinculado al rol
        usuarioRol = getUsuarioRolBL().buscar("" + temp.getIdusuario());
        //Obtenemos el rol del usuario que ingresa, para establecer las paginas de acceso
        rol = getRolBL().buscar("" + getUsuarioRol().getRol().getIdrol());
        if (temp != null) {
            if (temp.getPassword().equals(this.getPassword())) {
                HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                httpSession.setAttribute("nombreUsuario", this.nombreUsuario);
                //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", "Bienvenido " + temp.getNombreUsuario());
                //FacesContext.getCurrentInstance().addMessage(null, message);
                switch (rol.getNombreRol()) {
                    case "Administrador":
                        url = "/page/inicioUsuario";
                        break;
                    case "Colector":
                        url = "/page/inicioUsuario";
                        break;
                    case "Registrador":
                        url = "/page/inicioComision";
                        break;                   
                }
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario y/o contraseña incorrectos");
                FacesContext.getCurrentInstance().addMessage(null, message);
                url = "/page/login";
            }
        } else {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de acceso", "Usuario y/o contraseña incorrectos");
            FacesContext.getCurrentInstance().addMessage(null, message);
            url = "/page/login";
        }
        return url;
    }

    public String cerrarSesion() {
        this.nombreUsuario = null;
        this.password = null;
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSession.invalidate();
        return "/page/login";
    }

    public String irRegistrarse() {
        return "registrarUsuario";
    }

    public UsuarioBL getUsuarioBL() {
        return usuarioBL;
    }

    public void setUsuarioBL(UsuarioBL usuarioBL) {
        this.usuarioBL = usuarioBL;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRolBL getUsuarioRolBL() {
        return usuarioRolBL;
    }

    public void setUsuarioRolBL(UsuarioRolBL usuarioRolBL) {
        this.usuarioRolBL = usuarioRolBL;
    }

    public UsuarioRol getUsuarioRol() {
        return usuarioRol;
    }

    public void setUsuarioRol(UsuarioRol usuarioRol) {
        this.usuarioRol = usuarioRol;
    }

    public RolBL getRolBL() {
        return rolBL;
    }

    public void setRolBL(RolBL rolBL) {
        this.rolBL = rolBL;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
