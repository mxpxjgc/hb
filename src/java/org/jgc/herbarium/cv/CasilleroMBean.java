
package org.jgc.herbarium.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.jgc.herbarium.be.Casillero;
import org.jgc.herbarium.be.Gabinete;
import org.jgc.herbarium.bl.CasilleroBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class CasilleroMBean {
    @ManagedProperty(value = "#{casilleroBL}")
    private CasilleroBL casilleroBL;
    
    @ManagedProperty(value = "#{casillero}")
    private Casillero casillero;
    
    private List<Casillero> listaCasilleros = new LinkedList<>();
    private List<SelectItem> selectOneItemsCasillero;
    
    public CasilleroMBean() {
    }    

    public void registrarCasillero() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getCasilleroBL().registrar(getCasillero())) {
            @Override
            public void proceso() {
                casillero = new Casillero();
                listarCasilleros();
            }
        });
    }

    @PostConstruct
    public void listarCasilleros() {
        setListaCasilleros(casilleroBL.listar(""));
    }    

    public void actualizarCasillero() {
        Casillero temp = new Casillero();
        String msg;
        temp = buscarId();
        temp.setGabinete(this.getCasillero().getGabinete());
        temp.setNumero(this.getCasillero().getNumero());
        temp.setDescripcion(this.getCasillero().getDescripcion());        
        long res = getCasilleroBL().actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarCasilleros();
    }
    
    public void eliminarCasillero() {
        Casillero temp = new Casillero();
        String msg;
        temp = buscarId();
        long res = getCasilleroBL().eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
              
        listarCasilleros();
    }
    
    public Casillero buscarId(){
        return casilleroBL.buscar(getCasillero().getIdcasillero());
    }
    
    public void limpiar(){
        this.casillero.setIdcasillero(null);
        this.casillero.setGabinete(new Gabinete());
        this.casillero.setNumero(null);
        this.casillero.setDescripcion("");
    }   

    public CasilleroBL getCasilleroBL() {
        return casilleroBL;
    }

    public void setCasilleroBL(CasilleroBL casilleroBL) {
        this.casilleroBL = casilleroBL;
    }

    public Casillero getCasillero() {
        return casillero;
    }

    public void setCasillero(Casillero casillero) {
        this.casillero = casillero;
    }

    public List<Casillero> getListaCasilleros() {
        return listaCasilleros;
    }

    public void setListaCasilleros(List<Casillero> listaCasilleros) {
        this.listaCasilleros = listaCasilleros;
    }

    public List<SelectItem> getSelectOneItemsCasillero() {
        this.selectOneItemsCasillero = new LinkedList<SelectItem>();
        for (Casillero oCasillero : listaCasilleros) {
            this.setCasillero(oCasillero);
            SelectItem selectItem = new SelectItem(casillero.getIdcasillero(), casillero.getNumero().toString());
            this.selectOneItemsCasillero.add(selectItem);
        }
        return selectOneItemsCasillero;
    }

    public void setSelectOneItemsCasillero(List<SelectItem> selectOneItemsCasillero) {
        this.selectOneItemsCasillero = selectOneItemsCasillero;
    }

}
