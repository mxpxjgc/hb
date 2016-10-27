
package org.jgc.herbarium.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.jgc.herbarium.be.Persona;
import org.jgc.herbarium.be.Usuario;
import org.jgc.herbarium.bl.PersonaBL;
import org.jgc.herbarium.bl.UsuarioBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class UsuarioManagedBean {
    @ManagedProperty(value = "#{usuarioBL}")
    private UsuarioBL usuarioBL;
    
    @ManagedProperty(value = "#{usuario}")
    private Usuario usuario;
    
    private List<Usuario> listaUsuario = new LinkedList<>();
    private List<SelectItem> selectOneItemsUsuario;
    
    public void registrarUsuario() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getUsuarioBL().registrar(getUsuario())) {
            @Override
            public void proceso() {
                usuario = new Usuario();
                listarUsuario();
            }
        });
    }
    
    public void actualizarUsuario(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarUsuario()");
        Usuario temp = new Usuario();
        String msg;
        temp = buscarId();
        temp.setPersona(new Persona()); 
        temp.setUsuario(this.getUsuario().getUsuario()); 
        temp.setPassword(this.getUsuario().getPassword()); 
        temp.setFechaRegistro(this.getUsuario().getFechaRegistro()); 
        temp.setEstado(this.getUsuario().getEstado()); 
        long res = usuarioBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarUsuario();
    }
    
    public void eliminarUsuario() {    
        System.out.println("Ingresa a eliminarUsuario()");
        Usuario temp = new Usuario();
        String msg;
        temp = buscarId();
        long res = usuarioBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarUsuario();
    }
    
    public Usuario buscarId(){
        System.out.println("ID enviado: "+getUsuario().getIdusuario());
        return usuarioBL.buscar(getUsuario().getIdusuario());
    }

    @PostConstruct
    public void listarUsuario() {
        setListaUsuario(usuarioBL.listar());
    }
    
    public void limpiar() {
        this.usuario.setIdusuario(Long.MIN_VALUE);        
        this.usuario.setPersona(new Persona());
        this.usuario.setUsuario("");
        this.usuario.setPassword("");
        this.usuario.setFechaRegistro(null);
        this.usuario.setEstado(null);
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

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public List<SelectItem> getSelectOneItemsUsuario() {
        return selectOneItemsUsuario;
    }

    public void setSelectOneItemsUsuario(List<SelectItem> selectOneItemsUsuario) {
        this.selectOneItemsUsuario = selectOneItemsUsuario;
    }
}
