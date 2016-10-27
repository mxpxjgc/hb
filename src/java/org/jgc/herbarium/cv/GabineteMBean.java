
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
import org.jgc.herbarium.be.Gabinete;
import org.jgc.herbarium.bl.GabineteBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class GabineteMBean {
    @ManagedProperty(value = "#{gabineteBL}")
    private GabineteBL gabineteBL;
    
    @ManagedProperty(value = "#{gabinete}")
    private Gabinete gabinete;
    
    private List<Gabinete> listaGabinetes = new LinkedList<>();    
    private List<SelectItem> selectOneItemsGabinete;
    
    public void registrarGabinete() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getGabineteBL().registrar(getGabinete())) {
            @Override
            public void proceso() {
                gabinete = new Gabinete();
                listarGabinete();
            }
        });
    }
    
    public void actualizarGabinete(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarEspecie()");
        Gabinete temp = new Gabinete();
        String msg;
        temp = buscarId();
        temp.setNombre(this.getGabinete().getNombre());
        temp.setCodigo(this.getGabinete().getCodigo());
        temp.setDescripcion(this.getGabinete().getDescripcion());       
        long res = gabineteBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarGabinete();
    }
    
    public void eliminarGabinete() {    
        System.out.println("Ingresa a eliminarFamilia()");
        Gabinete temp = new Gabinete();
        String msg;
        temp = buscarId();
        long res = gabineteBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarGabinete();
    }
    
    public Gabinete buscarId(){
        System.out.println("ID enviado: "+getGabinete().getIdgabinete());
        return gabineteBL.buscar(getGabinete().getIdgabinete());
    }

    @PostConstruct
    public void listarGabinete() {
        setListaGabinetes(gabineteBL.listar());
    }
    
    public void limpiar() {
        this.gabinete.setIdgabinete(Long.MIN_VALUE);        
        this.gabinete.setNombre("");  
        this.gabinete.setCodigo("");  
        this.gabinete.setDescripcion("");  
    }

    public GabineteBL getGabineteBL() {
        return gabineteBL;
    }

    public void setGabineteBL(GabineteBL gabineteBL) {
        this.gabineteBL = gabineteBL;
    }

    public Gabinete getGabinete() {
        return gabinete;
    }

    public void setGabinete(Gabinete gabinete) {
        this.gabinete = gabinete;
    }

    public List<Gabinete> getListaGabinetes() {
        return listaGabinetes;
    }

    public void setListaGabinetes(List<Gabinete> listaGabinetes) {
        this.listaGabinetes = listaGabinetes;
    }

    public List<SelectItem> getSelectOneItemsGabinete() {
        this.selectOneItemsGabinete = new LinkedList<SelectItem>();
        for (Gabinete oGabinete : listaGabinetes) {
            this.setGabinete(oGabinete);
            SelectItem selectItem = new SelectItem(gabinete.getIdgabinete(), gabinete.getCodigo(), gabinete.getNombre());
            this.selectOneItemsGabinete.add(selectItem);
        }        
        return selectOneItemsGabinete;
    }

    public void setSelectOneItemsGabinete(List<SelectItem> selectOneItemsGabinete) {
        this.selectOneItemsGabinete = selectOneItemsGabinete;
    }
}
