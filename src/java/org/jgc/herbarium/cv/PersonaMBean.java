
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
import org.jgc.herbarium.be.Persona;
import org.jgc.herbarium.bl.PersonaBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class PersonaMBean {
    @ManagedProperty(value = "#{personaBL}")
    private PersonaBL personaBL;
    
    @ManagedProperty(value = "#{persona}")
    private Persona persona;
    
    private List<Persona> listaPersona = new LinkedList<>();
    private List<SelectItem> selectOneItemsPersona;
    
    public void registrarPersona() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getPersonaBL().registrar(getPersona())) {
            @Override
            public void proceso() {
                persona = new Persona();
                listarPersona();
            }
        });
    }
    
    public void actualizarPersona(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarPersona()");
        Persona temp = new Persona();
        String msg;
        temp = buscarId();
        temp.setNombres(this.getPersona().getNombres()); 
        temp.setApPaterno(this.getPersona().getApPaterno()); 
        temp.setApMaterno(this.getPersona().getApMaterno()); 
        temp.setDni(this.getPersona().getDni()); 
        temp.setSexo(this.getPersona().getSexo()); 
        temp.setTelefono(this.getPersona().getTelefono()); 
        temp.setCelular1(this.getPersona().getCelular1()); 
        temp.setCelular2(this.getPersona().getCelular2()); 
        temp.setCorreo(this.getPersona().getCorreo()); 
        temp.setEstado(this.getPersona().getEstado()); 
        long res = personaBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarPersona();
    }
    
    public void eliminarPersona() {    
        System.out.println("Ingresa a actualizarPersona()");
        Persona temp = new Persona();
        String msg;
        temp = buscarId();
        long res = personaBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarPersona();
    }
    
    public Persona buscarId(){
        System.out.println("ID enviado: "+getPersona().getIdpersona());
        return personaBL.buscar(getPersona().getIdpersona());
    }

    @PostConstruct
    public void listarPersona() {
        setListaPersona(personaBL.listar());
    }
    
    public void limpiar() {
        this.persona.setIdpersona(Long.MIN_VALUE);        
        this.persona.setNombres("");
        this.persona.setApPaterno("");
        this.persona.setApMaterno("");
        this.persona.setDni("");
        this.persona.setSexo(null);
        this.persona.setTelefono(null);
        this.persona.setCelular1("");
        this.persona.setCelular2("");
        this.persona.setCorreo("");
        this.persona.setEstado(null);
    }

    public PersonaBL getPersonaBL() {
        return personaBL;
    }

    public void setPersonaBL(PersonaBL personaBL) {
        this.personaBL = personaBL;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public void setListaPersona(List<Persona> listaPersona) {
        this.listaPersona = listaPersona;
    }

    public List<SelectItem> getSelectOneItemsPersona() {
        this.selectOneItemsPersona = new LinkedList<SelectItem>();
        for (Persona oPersona : listaPersona) {
            this.setPersona(oPersona);
            SelectItem selectItem = new SelectItem(persona.getIdpersona(), persona.getApPaterno()+ " " +persona.getApMaterno()+" " + persona.getNombres());
            this.selectOneItemsPersona.add(selectItem);
        }        
        return selectOneItemsPersona;
    }

    public void setSelectOneItemsPersona(List<SelectItem> selectOneItemsPersona) {
        this.selectOneItemsPersona = selectOneItemsPersona;
    }
    
}
