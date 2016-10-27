
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
import org.jgc.herbarium.be.Rol;
import org.jgc.herbarium.bl.RolBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class RolMBean {
    @ManagedProperty(value = "#{rolBL}")
    private RolBL rolBL;
    
    @ManagedProperty(value = "#{rol}")
    private Rol rol;
    
    private List<Rol> listaRol = new LinkedList<>();
    private List<SelectItem> selectOneItemsRol;
    
    public void registrarRol() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getRolBL().registrar(getRol())) {
            @Override
            public void proceso() {
                rol = new Rol();
                listarRol();
            }
        });
    }
    
    public void actualizarRol(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarRol()");
        Rol temp = new Rol();
        String msg;
        temp = buscarId();
        temp.setNombreRol(this.getRol().getNombreRol()); 
        temp.setDescripcion(this.getRol().getDescripcion()); 
        temp.setEstado(this.getRol().getEstado()); 
        long res = rolBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarRol();
    }
    
    public void eliminarRol() {    
        System.out.println("Ingresa a eliminarRol()");
        Rol temp = new Rol();
        String msg;
        temp = buscarId();
        long res = rolBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarRol();
    }
    
    public Rol buscarId(){
        System.out.println("ID enviado: "+getRol().getIdrol());
        return rolBL.buscar(getRol().getIdrol());
    }

    @PostConstruct
    public void listarRol() {
        setListaRol(rolBL.listar());
    }
    
    public void limpiar() {
        this.rol.setIdrol(Long.MIN_VALUE);        
        this.rol.setNombreRol("");
        this.rol.setDescripcion("");
        this.rol.setEstado(null);
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

    public List<Rol> getListaRol() {
        return listaRol;
    }

    public void setListaRol(List<Rol> listaRol) {
        this.listaRol = listaRol;
    }

    public List<SelectItem> getSelectOneItemsRol() {
        return selectOneItemsRol;
    }

    public void setSelectOneItemsRol(List<SelectItem> selectOneItemsRol) {
        this.selectOneItemsRol = selectOneItemsRol;
    }
}
