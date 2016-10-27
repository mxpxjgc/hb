/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.jgc.herbarium.be.Distrito;
import org.jgc.herbarium.be.Provincia;
import org.jgc.herbarium.bl.DistritoBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

/**
 *
 * @author PROFESIONAL
 */
@ManagedBean
@ViewScoped
public class DistritoMBean {
    @ManagedProperty(value = "#{distritoBL}")
    private DistritoBL distritoBL;

    @ManagedProperty(value = "#{distrito}")
    private Distrito distrito;

    private List<Distrito> listaDistrito = new LinkedList<>();
    private List<SelectItem> selectOneItemsDistrito;
    
    public DistritoMBean(){        
    }

    public void registrarDistrito() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getDistritoBL().registrar(getDistrito())) {
            @Override
            public void proceso() {
                distrito = new Distrito();
                listarDistrito();
            }
        });
    }
    
    public void actualizarDistrito(ActionEvent actionEvent) {
        Distrito temp = new Distrito();
        String msg;
        temp = buscarId();
        temp.setDenominacion(this.getDistrito().getDenominacion());
        temp.setProvincia(this.getDistrito().getProvincia());
        long res = distritoBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarDistrito();
    }
    
    public void eliminarDistrito() {    
        Distrito temp = new Distrito();
        String msg;
        temp = buscarId();
        long res = distritoBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarDistrito();
    }
    
    public Distrito buscarId(){
        return distritoBL.buscar(getDistrito().getIddistrito());
    }

    @PostConstruct
    public void listarDistrito() {
        setListaDistrito(distritoBL.listar(""));
    } 
    
    public void limpiar() {
        this.distrito.setIddistrito(Long.MIN_VALUE);        
        this.distrito.setProvincia(new Provincia());
        this.distrito.setDenominacion("");
    }

    public DistritoBL getDistritoBL() {
        return distritoBL;
    }

    public void setDistritoBL(DistritoBL distritoBL) {
        this.distritoBL = distritoBL;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
    }

    public List<Distrito> getListaDistrito() {
        return listaDistrito;
    }

    public void setListaDistrito(List<Distrito> listaDistrito) {
        this.listaDistrito = listaDistrito;
    }

    public List<SelectItem> getSelectOneItemsDistrito() {
        return selectOneItemsDistrito;
    }

    public void setSelectOneItemsDistrito(List<SelectItem> selectOneItemsDistrito) {
        this.selectOneItemsDistrito = selectOneItemsDistrito;
    }
    
}
