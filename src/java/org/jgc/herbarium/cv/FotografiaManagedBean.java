
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
import org.jgc.herbarium.be.Colecta;
import org.jgc.herbarium.be.Fotografia;
import org.jgc.herbarium.be.Persona;
import org.jgc.herbarium.bl.FotografiaBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class FotografiaManagedBean {
    @ManagedProperty(value = "#{fotografiaBL}")
    private FotografiaBL fotografiaBL;
    
    @ManagedProperty(value = "#{fotografia}")
    private Fotografia fotografia;
    
    private List<Fotografia> listaFotografia = new LinkedList<>();
    private List<SelectItem> selectOneItemFormacionFotografia;
    
    public void registrarFotografia() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getFotografiaBL().registrar(getFotografia())) {
            @Override
            public void proceso() {
                fotografia = new Fotografia();
                listarFotografia();
            }
        });
    }
    
    public void actualizarFotografia(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarUbigeo()");
        Fotografia temp = new Fotografia();
        String msg;
        temp = buscarId();
        temp.setColecta(this.getFotografia().getColecta());  
        temp.setPersona(this.getFotografia().getPersona());  
        temp.setFotografia(this.getFotografia().getFotografia());  
        temp.setDescripcion(this.getFotografia().getDescripcion());
        temp.setObservacion(this.getFotografia().getObservacion());
        long res = fotografiaBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarFotografia();
    }
    
    public void eliminarFotografia() {    
        System.out.println("Ingresa a eliminarFotografia()");
        Fotografia temp = new Fotografia();
        String msg;
        temp = buscarId();
        long res = fotografiaBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarFotografia();
    }
    
    public Fotografia buscarId(){
        System.out.println("ID enviado: "+getFotografia().getIdfotografia());
        return fotografiaBL.buscar(getFotografia().getIdfotografia());
    }

    @PostConstruct
    public void listarFotografia() {
        setListaFotografia(fotografiaBL.listar());
    }
    
    public void limpiar() {
        this.fotografia.setIdfotografia(Long.MIN_VALUE);        
        this.fotografia.setColecta(new Colecta());
        this.fotografia.setPersona(new Persona());
        this.fotografia.setFotografia(null);
        this.fotografia.setDescripcion("");
        this.fotografia.setObservacion("");
        this.fotografia.setEstado(null);
    }

    public FotografiaBL getFotografiaBL() {
        return fotografiaBL;
    }

    public void setFotografiaBL(FotografiaBL fotografiaBL) {
        this.fotografiaBL = fotografiaBL;
    }

    public Fotografia getFotografia() {
        return fotografia;
    }

    public void setFotografia(Fotografia fotografia) {
        this.fotografia = fotografia;
    }

    public List<Fotografia> getListaFotografia() {
        return listaFotografia;
    }

    public void setListaFotografia(List<Fotografia> listaFotografia) {
        this.listaFotografia = listaFotografia;
    }

    public List<SelectItem> getSelectOneItemFormacionFotografia() {
        return selectOneItemFormacionFotografia;
    }

    public void setSelectOneItemFormacionFotografia(List<SelectItem> selectOneItemFormacionFotografia) {
        this.selectOneItemFormacionFotografia = selectOneItemFormacionFotografia;
    }
    
}
