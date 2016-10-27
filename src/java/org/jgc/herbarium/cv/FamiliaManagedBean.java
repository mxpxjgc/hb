package org.jgc.herbarium.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.jgc.herbarium.be.Familia;
import org.jgc.herbarium.bl.FamiliaBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@RequestScoped
public class FamiliaManagedBean {

    @ManagedProperty(value = "#{familiaBL}")
    private FamiliaBL familiaBL;

    @ManagedProperty(value = "#{familia}")
    private Familia familia;

    private List<Familia> listaFamilia = new LinkedList<>();
    private List<SelectItem> selectOneItemsFamilia;

    public FamiliaManagedBean(){        
    }

    public void registrarFamilia() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getFamiliaBL().registrar(getFamilia())) {
            @Override
            public void proceso() {
                familia = new Familia();
                listarFamilia();
            }
        });
    }
    
    public void actualizarFamilia(ActionEvent actionEvent) {
        Familia temp = new Familia();
        String msg;
        temp = buscarId();
        temp.setDenominacion(this.getFamilia().getDenominacion());
        temp.setAbreviatura(this.getFamilia().getAbreviatura());
        long res = familiaBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            mostrarMensaje(msg);
        }else{
            msg="Error al actualizar el registro.";
            mostrarMensaje(msg);
        }
        listarFamilia();
    }
    
    public void eliminarFamilia() {    
        Familia temp = new Familia();
        String msg;
        temp = buscarId();
        long res = familiaBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            mostrarMensaje(msg);
        }else{
            msg="Error al eliminar el registro.";
            mostrarMensaje(msg);
        }              
        listarFamilia();
    }
    
    public List<SelectItem> getSelectOneItemsFamilia() {
        this.selectOneItemsFamilia = new LinkedList<SelectItem>();
        for (Familia oFamilia : listaFamilia) {
            this.setFamilia(oFamilia);
            SelectItem selectItem = new SelectItem(familia.getIdfamilia(), familia.getDenominacion());
            this.selectOneItemsFamilia.add(selectItem);
        }        
        return selectOneItemsFamilia;
    }
    
    public Familia buscarId(){
        System.out.println("ID enviado: "+getFamilia().getIdfamilia());
        return familiaBL.buscar(getFamilia().getIdfamilia());
    }

    @PostConstruct
    public void listarFamilia() {
        setListaFamilia(familiaBL.listar());
    }
    
    public void mostrarMensaje(String msg){
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public FamiliaBL getFamiliaBL() {
        return familiaBL;
    }

    public void setFamiliaBL(FamiliaBL familiaBL) {
        this.familiaBL = familiaBL;
    }

    public Familia getFamilia() {
        return familia;
    }

    public void setFamilia(Familia familia) {
        this.familia = familia;
    }

    public List<Familia> getListaFamilia() {
        return listaFamilia;
    }

    public void setListaFamilia(List<Familia> listaFamilia) {
        this.listaFamilia = listaFamilia;
    }

    public void limpiar() {
        this.familia.setIdfamilia(Long.MIN_VALUE);        
        this.familia.setAbreviatura("");
        this.familia.setDenominacion("");
    }
}
