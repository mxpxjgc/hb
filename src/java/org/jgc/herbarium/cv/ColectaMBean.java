
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
import org.jgc.herbarium.be.Distrito;
import org.jgc.herbarium.be.Especie;
import org.jgc.herbarium.be.Formacion;
import org.jgc.herbarium.bl.ColectaBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class ColectaMBean {
    @ManagedProperty(value = "#{colectaBL}")
    private ColectaBL colectaBL;
    
    @ManagedProperty(value = "#{colecta}")
    private Colecta colecta;
    private List<Colecta> listaColectas = new LinkedList<>();
    private List<SelectItem> selectOneItemsColecta;
    
    public ColectaMBean(){
        
    }
    public void registrarColecta() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getColectaBL().registrar(getColecta())) {
            @Override
            public void proceso() {
                colecta = new Colecta();
                listarColecta();
            }
        });
    }
    
    public void actualizarColecta(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarColecta()");
        Colecta temp = new Colecta();
        String msg;
        temp = buscarId();
        temp.setEspecie(this.getColecta().getEspecie());
        temp.setDistrito(this.getColecta().getDistrito());
        temp.setLocalidad(this.getColecta().getLocalidad());
        temp.setZonaUtm(this.getColecta().getZonaUtm());
        temp.setCoordenada1Utm(this.getColecta().getCoordenada1Utm());
        temp.setCoordenada2Utm(this.getColecta().getCoordenada2Utm());
        temp.setCoordenada2Utm(this.getColecta().getCoordenada2Utm());
        temp.setLatitud(this.getColecta().getLatitud());
        temp.setLongitud(this.getColecta().getLongitud());
        temp.setAltitud(this.getColecta().getAltitud());
        temp.setFechaColecta(this.getColecta().getFechaColecta());
        temp.setFormacion(this.getColecta().getFormacion());
        temp.setDescripcion(this.getColecta().getDescripcion());
        temp.setObservacion(this.getColecta().getObservacion());
        long res = colectaBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarColecta();
    }
    
    public void eliminarColecta() {    
        System.out.println("Ingresa a eliminarColecta()");
        Colecta temp = new Colecta();
        String msg;
        temp = buscarId();
        long res = colectaBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarColecta();
    }
    
    public Colecta buscarId(){
        System.out.println("ID enviado: "+getColecta().getIdcolecta());
        return colectaBL.buscar(getColecta().getIdcolecta());
    }
    
    @PostConstruct
    public void listarColecta() {
        setListaColectas(colectaBL.listar());
    }
    
    public void limpiar() {
        this.colecta.setIdcolecta(Long.MIN_VALUE);     
        this.colecta.setEspecie(new Especie());
        this.colecta.setDistrito(new Distrito());
        this.colecta.setLocalidad("");
        this.colecta.setZonaUtm("");
        this.colecta.setCoordenada1Utm("");
        this.colecta.setCoordenada2Utm("");
        this.colecta.setLatitud(null);
        this.colecta.setLongitud(null);
        this.colecta.setAltitud(null);
        this.colecta.setFechaColecta(null);
        this.colecta.setFechaColecta(null);
        this.colecta.setFormacion(new Formacion());
        this.colecta.setDescripcion("");
        this.colecta.setObservacion("");
    }

    public ColectaBL getColectaBL() {
        return colectaBL;
    }

    public void setColectaBL(ColectaBL colectaBL) {
        this.colectaBL = colectaBL;
    }

    public Colecta getColecta() {
        return colecta;
    }

    public void setColecta(Colecta colecta) {
        this.colecta = colecta;
    }

    public List<Colecta> getListaColectas() {
        return listaColectas;
    }

    public void setListaColectas(List<Colecta> listaColectas) {
        this.listaColectas = listaColectas;
    }

    public List<SelectItem> getSelectOneItemsColecta() {
        this.selectOneItemsColecta= new LinkedList<SelectItem>();
        for (Colecta oColecta : listaColectas) {
            this.setColecta(oColecta);
            SelectItem selectItem = new SelectItem(colecta.getIdcolecta(), colecta.getDescripcion(), colecta.getObservacion());
            this.selectOneItemsColecta.add(selectItem);
        }        
        return selectOneItemsColecta;
    }

    public void setSelectOneItemsColecta(List<SelectItem> selectOneItemsColecta) {
        this.selectOneItemsColecta = selectOneItemsColecta;
    }
    
}
