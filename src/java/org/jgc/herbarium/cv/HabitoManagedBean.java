
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
import org.jgc.herbarium.be.Habito;
import org.jgc.herbarium.bl.HabitoBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class HabitoManagedBean {
    @ManagedProperty(value = "#{habitoBL}")
    private HabitoBL habitoBL;
    
    @ManagedProperty(value = "#{habito}")
    private Habito habito;
    private List<Habito> listaHabito= new LinkedList<>();
    private List<SelectItem> selectOneItemsHabito;
    
    public void registrarHabito() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getHabitoBL().registrar(getHabito())) {
            @Override
            public void proceso() {
                habito = new Habito();
                listarHabito();
            }
        });
    }
    
    public void actualizarHabito(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarHabito()");
        Habito temp = new Habito();
        String msg;
        temp = buscarId();
        temp.setNombrehabito(this.getHabito().getNombrehabito());        
        long res = habitoBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarHabito();
    }
    
    public void eliminarHabito() {    
        System.out.println("Ingresa a eliminarHabito()");
        Habito temp = new Habito();
        String msg;
        temp = buscarId();
        long res = habitoBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarHabito();
    }
    
    public Habito buscarId(){
        System.out.println("ID enviado: "+getHabito().getIdhabito());
        return habitoBL.buscar(getHabito().getIdhabito());
    }

    @PostConstruct
    public void listarHabito() {
        setListaHabito(habitoBL.listar());
    }
    
    public void limpiar() {
        this.habito.setIdhabito(Long.MIN_VALUE);        
        this.habito.setNombrehabito("");
        this.habito.setEstado(null);
    }

    public HabitoBL getHabitoBL() {
        return habitoBL;
    }

    public void setHabitoBL(HabitoBL habitoBL) {
        this.habitoBL = habitoBL;
    }

    public Habito getHabito() {
        return habito;
    }

    public void setHabito(Habito habito) {
        this.habito = habito;
    }

    public List<Habito> getListaHabito() {
        return listaHabito;
    }

    public void setListaHabito(List<Habito> listaHabito) {
        this.listaHabito = listaHabito;
    }

    public List<SelectItem> getSelectOneItemsHabito() {
        this.selectOneItemsHabito = new LinkedList<SelectItem>();
        for (Habito oHabito : listaHabito) {
            this.setHabito(oHabito);
            SelectItem selectItem = new SelectItem(habito.getIdhabito(), habito.getNombrehabito());
            this.selectOneItemsHabito.add(selectItem);
        }        
        return selectOneItemsHabito;
    }

    public void setSelectOneItemsHabito(List<SelectItem> selectOneItemsHabito) {
        this.selectOneItemsHabito = selectOneItemsHabito;
    }
    
    
}
