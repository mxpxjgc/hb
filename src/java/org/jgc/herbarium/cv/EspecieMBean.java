
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
import org.jgc.herbarium.be.Especie;
import org.jgc.herbarium.be.Genero;
import org.jgc.herbarium.be.Habito;
import org.jgc.herbarium.bl.EspecieBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class EspecieMBean {
    @ManagedProperty(value = "#{especieBL}")
    private EspecieBL especieBL;
    
    @ManagedProperty(value = "#{especie}")
    private Especie especie;
    
    private List<Especie> listaEspecies = new LinkedList<>();    
    private List<SelectItem> selectOneItemsEspecie;
    
    public void registrarEspecie() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getEspecieBL().registrar(getEspecie())) {
            @Override
            public void proceso() {
                especie = new Especie();
                listarEspecie();
            }
        });
    }
    
    public void actualizarEspecie(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarEspecie()");
        Especie temp = new Especie();
        String msg;
        temp = buscarId();
        temp.setDenominacion(this.getEspecie().getDenominacion());
        temp.setAutor(this.getEspecie().getAutor());
        temp.setNombreVulgar1(this.getEspecie().getNombreVulgar1());
        temp.setNombreVulgar2(this.getEspecie().getNombreVulgar2());
        temp.setNombreVulgar3(this.getEspecie().getNombreVulgar3());
        temp.setHabito(this.getEspecie().getHabito());
        temp.setDescripcion(this.getEspecie().getDescripcion());
        long res = especieBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarEspecie();
    }
    
    public void eliminarEspecie() {    
        System.out.println("Ingresa a eliminarFamilia()");
        Especie temp = new Especie();
        String msg;
        temp = buscarId();
        long res = especieBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarEspecie();
    }
    
    public Especie buscarId(){
        System.out.println("ID enviado: "+getEspecie().getIdespecie());
        return especieBL.buscar(getEspecie().getIdespecie());
    }

    @PostConstruct
    public void listarEspecie() {
        setListaEspecies(especieBL.listar(""));
    }
    
    public void limpiar() {
        this.especie.setIdespecie(Long.MIN_VALUE);        
        this.especie.setGenero(new Genero());        
        this.especie.setDenominacion("");
        this.especie.setAutor("");
        this.especie.setNombreVulgar1("");
        this.especie.setNombreVulgar2("");
        this.especie.setNombreVulgar3("");        
        this.especie.setHabito(new Habito());
        this.especie.setDescripcion("");        
    }

    public EspecieBL getEspecieBL() {
        return especieBL;
    }

    public void setEspecieBL(EspecieBL especieBL) {
        this.especieBL = especieBL;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public List<Especie> getListaEspecies() {
        return listaEspecies;
    }

    public void setListaEspecies(List<Especie> listaEspecies) {
        this.listaEspecies = listaEspecies;
    }

    public List<SelectItem> getSelectOneItemsEspecie() {
        this.selectOneItemsEspecie = new LinkedList<SelectItem>();
        for (Especie oEspecie : listaEspecies) {
            this.setEspecie(oEspecie);
            SelectItem selectItem = new SelectItem(especie.getIdespecie(), especie.getDenominacion(), especie.getNombreVulgar1());
            this.selectOneItemsEspecie.add(selectItem);
        }        
        return selectOneItemsEspecie;
    }

    public void setSelectOneItemsEspecie(List<SelectItem> selectOneItemsEspecie) {
        this.selectOneItemsEspecie = selectOneItemsEspecie;
    }
}
