/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.jgc.herbarium.be.Departamento;
import org.jgc.herbarium.be.Provincia;
import org.jgc.herbarium.bl.ProvinciaBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

/**
 *
 * @author PROFESIONAL
 */
@ManagedBean
@SessionScoped
public class ProvinciaManagedBean {

    @ManagedProperty(value = "#{provinciaBL}")
    private ProvinciaBL provinciaBL;

    @ManagedProperty(value = "#{provincia}")
    private Provincia provincia;

    @ManagedProperty(value = "#{departamentoManagedBean}")
    private DptoMBean departamentoMB;

    private List<Provincia> listaProvincia = new LinkedList<>();
    private List<SelectItem> selectOneItemsProvincia;

    public ProvinciaManagedBean() {

    }

    public void registrarProvincia() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getProvinciaBL().registrar(getProvincia())) {
            @Override
            public void proceso() {
                provincia = new Provincia();
                listarProvincia();
            }
        });
    }

    public void actualizarProvincia(ActionEvent actionEvent) {
        Provincia temp = new Provincia();
        String msg;
        temp = buscarId();
        temp.setDepartamento(this.getProvincia().getDepartamento());
        temp.setDenominacion(this.getProvincia().getDenominacion());
        long res = provinciaBL.actualizar(temp);
        if (res == 0) {
            msg = "Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarProvincia();
    }

    public void eliminarProvincia() {
        Provincia temp = new Provincia();
        String msg;
        temp = buscarId();
        long res = provinciaBL.eliminar(temp);
        if (res == 0) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarProvincia();
    }

    public Provincia buscarId() {
        return provinciaBL.buscar(getProvincia().getIdprovincia());
    }

    @PostConstruct
    public void listarProvincia() {
        System.out.println("ID departamento: " + recuperarID());
        setListaProvincia(getProvinciaBL().listar(recuperarID()));
    }

    public long recuperarID() {
        System.out.println("Entra a Recuperar ID");
        //FacesContext context = FacesContext.getCurrentInstance();
        //return (long) context.getExternalContext().getSessionMap().get("idDepSession");
        Departamento dep = (Departamento)departamentoMB.getDepSelected();
        return dep.getIddepartamento();
    }

    public void limpiar() {
        this.provincia.setIdprovincia(Long.MIN_VALUE);
        this.provincia.setDenominacion("");
    }

    public ProvinciaBL getProvinciaBL() {
        return provinciaBL;
    }

    public void setProvinciaBL(ProvinciaBL provinciaBL) {
        this.provinciaBL = provinciaBL;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Provincia> getListaProvincia() {
        return listaProvincia;
    }

    public void setListaProvincia(List<Provincia> listaProvincia) {
        this.listaProvincia = listaProvincia;
    }

    public List<SelectItem> getSelectOneItemsProvincia() {
        this.selectOneItemsProvincia = new LinkedList<SelectItem>();
        for (Provincia oProv : listaProvincia) {
            this.setProvincia(oProv);
            SelectItem selectItem = new SelectItem(provincia.getIdprovincia(), provincia.getDenominacion());
            this.selectOneItemsProvincia.add(selectItem);
        }
        return selectOneItemsProvincia;
    }

    public void setSelectOneItemsProvincia(List<SelectItem> selectOneItemsProvincia) {
        this.selectOneItemsProvincia = selectOneItemsProvincia;
    }

    public DptoMBean getDepartamentoMB() {
        return departamentoMB;
    }

    public void setDepartamentoMB(DptoMBean departamentoMB) {
        this.departamentoMB = departamentoMB;
    }

}
