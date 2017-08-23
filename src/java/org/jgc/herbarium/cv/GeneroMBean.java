
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
import javax.servlet.http.HttpSession;
import org.jgc.herbarium.be.Familia;
import org.jgc.herbarium.be.Genero;
import org.jgc.herbarium.bl.GeneroBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class GeneroMBean {
    @ManagedProperty(value = "#{generoBL}")
    private GeneroBL generoBL;

    @ManagedProperty(value = "#{genero}")
    private Genero genero;

    private List<Genero> listaGenero = new LinkedList<>();
    private List<SelectItem> selectOneItemsGenero;

    public GeneroMBean(){        
    }

    public void registrarGenero() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getGeneroBL().registrar(getGenero())) {
            @Override
            public void proceso() {
                genero = new Genero();
                listarGenero();
            }
        });
    }
    
    public void actualizarGenero(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarGenero()");
        Genero temp = new Genero();
        String msg;
        temp = buscarId();
        temp.setDenominacion(this.getGenero().getDenominacion());
        temp.setAbreviatura(this.getGenero().getAbreviatura());
        long res = generoBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", null));
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarGenero();
    }
    
    public void eliminarGenero() {    
        System.out.println("Ingresa a eliminarGenero()");
        Genero temp = new Genero();
        String msg;
        temp = buscarId();
        long res = generoBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarGenero();
    }
    
    public List<SelectItem> getSelectOneItemsGenero() {
        this.selectOneItemsGenero = new LinkedList<SelectItem>();
        for (Genero oGenero : listaGenero) {
            this.setGenero(oGenero);
            SelectItem selectItem = new SelectItem(genero.getIdgenero(), genero.getDenominacion());
            this.selectOneItemsGenero.add(selectItem);
        }        
        return selectOneItemsGenero;
    }
    
    public Genero buscarId(){
        System.out.println("ID enviado: "+getGenero().getIdgenero());
        return generoBL.buscar(getGenero().getIdgenero());
    }

    @PostConstruct
    public void listarGenero() {
        //setListaGenero(generoBL.listar(""));
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        if(httpSession.getAttribute("idFamilia") != null){
            setListaGenero(generoBL.listarxIDFamilia(Long.parseLong(httpSession.getAttribute("idFamilia").toString())));
        }else{
            setListaGenero(generoBL.listar(""));
        }  
    }

    public GeneroBL getGeneroBL() {
        return generoBL;
    }

    public void setGeneroBL(GeneroBL generoBL) {
        this.generoBL = generoBL;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Genero> getListaGenero() {
        return listaGenero;
    }

    public void setListaGenero(List<Genero> listaGenero) {
        this.listaGenero = listaGenero;
    }

    public void limpiar() {
        this.genero.setIdgenero(Long.MIN_VALUE);        
        this.genero.setFamilia(new Familia());        
        this.genero.setAbreviatura("");
        this.genero.setDenominacion("");
    }
}
