
package org.jgc.herbarium.cv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.jgc.herbarium.be.Rol;
import org.jgc.herbarium.be.Usuario;
import org.jgc.herbarium.be.UsuarioRol;
import org.jgc.herbarium.bl.UsuarioRolBL;

@ManagedBean
@ViewScoped
public class UsuarioRolMBean {
    @ManagedProperty(value = "#{usuarioRolBL}")
    private UsuarioRolBL usuarioRolBL;
    
    @ManagedProperty(value = "#{usuarioRol}")
    private UsuarioRol usuarioRol;
    
    public void registrar() {
        long resUR = getUsuarioRolBL().registrar(getUsuarioRol());
    }
    
    public void limpiar() {
        this.usuarioRol.setIdusuariorol(Long.MIN_VALUE);        
        this.usuarioRol.setUsuario(new Usuario());
        this.usuarioRol.setRol(new Rol());
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
}
