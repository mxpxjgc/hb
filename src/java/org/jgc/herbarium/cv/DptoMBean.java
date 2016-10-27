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
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import org.jgc.herbarium.be.Departamento;
import org.jgc.herbarium.bl.DepartamentoBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

/**
 *
 * @author PROFESIONAL
 */
@ManagedBean
@SessionScoped
public class DptoMBean {

    @ManagedProperty(value = "#{departamentoBL}")
    private DepartamentoBL departamentoBL;

    @ManagedProperty(value = "#{departamento}")
    private Departamento departamento;
    
    private UIData depDataTable;
    private Departamento depSelected;

    private List<Departamento> listaDepartamento = new LinkedList<>();
    private List<SelectItem> selectOneItemsDepartamento;

    public DptoMBean() {

    }

    public void registrarDepartamento() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getDepartamentoBL().registrar(getDepartamento())) {
            @Override
            public void proceso() {
                departamento = new Departamento();
                listarDepartamento();
            }
        });
    }

    public void actualizarDepartamento(ActionEvent actionEvent) {
        Departamento temp = new Departamento();
        String msg;
        temp = buscarId();
        temp.setDenominacion(this.getDepartamento().getDenominacion());
        long res = departamentoBL.actualizar(temp);
        if (res == 0) {
            msg = "Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarDepartamento();
    }

    public void eliminarDepartamento() {
        Departamento temp = new Departamento();
        String msg;
        temp = buscarId();
        long res = departamentoBL.eliminar(temp);
        if (res == 0) {
            msg = "Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        } else {
            msg = "Error al eliminar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarDepartamento();
    }

    public Departamento buscarId() {
        return departamentoBL.buscar(getDepartamento().getIddepartamento());
    }

    @PostConstruct
    public void listarDepartamento() {
        setListaDepartamento(departamentoBL.listar());
    }

    public void limpiar() {
        this.departamento.setIddepartamento(Long.MIN_VALUE);
        this.departamento.setDenominacion("");
    }

    public DepartamentoBL getDepartamentoBL() {
        return departamentoBL;
    }

    public void setDepartamentoBL(DepartamentoBL departamentoBL) {
        this.departamentoBL = departamentoBL;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getListaDepartamento() {
        return listaDepartamento;
    }

    public void setListaDepartamento(List<Departamento> listaDepartamento) {
        this.listaDepartamento = listaDepartamento;
    }

    public List<SelectItem> getSelectOneItemsDepartamento() {
        this.selectOneItemsDepartamento = new LinkedList<SelectItem>();
        for (Departamento oDep : listaDepartamento) {
            this.setDepartamento(oDep);
            SelectItem selectItem = new SelectItem(departamento.getIddepartamento(), departamento.getDenominacion());
            this.selectOneItemsDepartamento.add(selectItem);
        }
        return selectOneItemsDepartamento;
    }

    public void setSelectOneItemsDepartamento(List<SelectItem> selectOneItemsDepartamento) {
        this.selectOneItemsDepartamento = selectOneItemsDepartamento;
    }

    public UIData getDepDataTable() {
        return depDataTable;
    }

    public void setDepDataTable(UIData depDataTable) {
        this.depDataTable = depDataTable;
    }

    public Departamento getDepSelected() {
        return depSelected;
    }

    public void setDepSelected(Departamento depSelected) {
        this.depSelected = depSelected;
    }
}
