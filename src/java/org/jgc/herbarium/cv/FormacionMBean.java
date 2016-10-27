
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
import org.jgc.herbarium.be.Formacion;
import org.jgc.herbarium.bl.FormacionBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class FormacionMBean {
    @ManagedProperty(value = "#{formacionBL}")
    private FormacionBL formacionBL;
    
    @ManagedProperty(value = "#{formacion}")
    private Formacion formacion;
    private List<Formacion> listaFormacion = new LinkedList<>();
    private List<SelectItem> selectOneItemFormacion;
    
    public void registrarFormacionVegetal() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getFormacionBL().registrar(getFormacion())) {
            @Override
            public void proceso() {
                formacion = new Formacion();
                listarFormacionVegetal();
            }
        });
    }
    
    public void actualizarFormacionVegetal(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarFormacionVegetal()");
        Formacion temp = new Formacion();
        String msg;
        temp = buscarId();
        temp.setFormacionVegetal(this.getFormacion().getFormacionVegetal());  
        
        long res = formacionBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarFormacionVegetal();
    }
    
    public void eliminarFormacionVegetal() {    
        System.out.println("Ingresa a eliminarFormacionVegetal()");
        Formacion temp = new Formacion();
        String msg;
        temp = buscarId();
        long res = formacionBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarFormacionVegetal();
    }
    
    public Formacion buscarId(){
        System.out.println("ID enviado: "+getFormacion().getIdformacion());
        return formacionBL.buscar(getFormacion().getIdformacion());
    }

    @PostConstruct
    public void listarFormacionVegetal() {
        setListaFormacion(formacionBL.listar());
    }
    
    public void limpiar() {
        this.formacion.setIdformacion(Long.MIN_VALUE);        
        this.formacion.setFormacionVegetal("");
        this.formacion.setEstado(null);
    }

    public FormacionBL getFormacionBL() {
        return formacionBL;
    }

    public void setFormacionBL(FormacionBL formacionBL) {
        this.formacionBL = formacionBL;
    }

    public Formacion getFormacion() {
        return formacion;
    }

    public void setFormacion(Formacion formacion) {
        this.formacion = formacion;
    }

    public List<Formacion> getListaFormacion() {
        return listaFormacion;
    }

    public void setListaFormacion(List<Formacion> listaFormacion) {
        this.listaFormacion = listaFormacion;
    }

    public List<SelectItem> getSelectOneItemFormacion() {
        this.selectOneItemFormacion = new LinkedList<SelectItem>();
        for (Formacion oFormacion : listaFormacion) {
            this.setFormacion(oFormacion);
            SelectItem selectItem = new SelectItem(formacion.getIdformacion(), formacion.getFormacionVegetal());
            this.selectOneItemFormacion.add(selectItem);
        }        
        return selectOneItemFormacion;
    }

    public void setSelectOneItemFormacion(List<SelectItem> selectOneItemFormacionVegetal) {
        this.selectOneItemFormacion = selectOneItemFormacionVegetal;
    }
    
    
}
