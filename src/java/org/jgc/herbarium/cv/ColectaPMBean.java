
package org.jgc.herbarium.cv;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.view.ViewScoped;
import org.jgc.herbarium.be.Colecta;
import org.jgc.herbarium.be.ColectaPersona;
import org.jgc.herbarium.be.Persona;
import org.jgc.herbarium.bl.ColectaPersonaBL;

@ManagedBean
@ViewScoped
public class ColectaPMBean {
    @ManagedProperty(value = "#{colectaPersonaBL}")
    private ColectaPersonaBL colectaPersonaBL;
    
    @ManagedProperty(value = "#{coletaPersona}")
    private ColectaPersona colectaPersona;
    
    public void registrar() {
        long resUR = getColectaPersonaBL().registrar(getColectaPersona());
    }
    
    public void limpiar() {
        this.colectaPersona.setIdcolectapersona(Long.MIN_VALUE);        
        this.colectaPersona.setColecta(new Colecta());
        this.colectaPersona.setPersona(new Persona());
        this.colectaPersona.setTipo(null);
        this.colectaPersona.setNumeroColecta(null);
    }

    public ColectaPersonaBL getColectaPersonaBL() {
        return colectaPersonaBL;
    }

    public void setColectaPersonaBL(ColectaPersonaBL colectaPersonaBL) {
        this.colectaPersonaBL = colectaPersonaBL;
    }

    public ColectaPersona getColectaPersona() {
        return colectaPersona;
    }

    public void setColectaPersona(ColectaPersona colectaPersona) {
        this.colectaPersona = colectaPersona;
    }
    
    
}
