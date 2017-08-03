package org.jgc.herbarium.cv;

import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.jgc.herbarium.be.Departamento;
import org.jgc.herbarium.be.Distrito;
import org.jgc.herbarium.be.Provincia;
import org.jgc.herbarium.bl.DepartamentoBL;
import org.jgc.herbarium.bl.DistritoBL;
import org.jgc.herbarium.bl.ProvinciaBL;

/**
 *
 * @author JSULCAG
 */
@ManagedBean
@ViewScoped
public class UbigeoMBean {

    @ManagedProperty(value = "#{departamentoBL}")
    private DepartamentoBL departamentoBL;
    @ManagedProperty(value = "#{departamento}")
    private Departamento departamento;
    @ManagedProperty(value = "#{provinciaBL}")
    private ProvinciaBL provinciaBL;
    @ManagedProperty(value = "#{provincia}")
    private Provincia provincia;
    @ManagedProperty(value = "#{distritoBL}")
    private DistritoBL distritoBL;
    @ManagedProperty(value = "#{distrito}")
    private Distrito distrito;
    private List<Departamento> listaDepartamento = new LinkedList<>();
    private List<SelectItem> selectOneItemsDepartamento;
    private List<Provincia> listaProvincia = new LinkedList<>();
    private List<SelectItem> selectOneItemsProvincia;
    private List<Distrito> listaDistrito = new LinkedList<>();
    private List<SelectItem> selectOneItemsDistrito;

    public UbigeoMBean() {
    }

    //Metodos

    @PostConstruct
    public void listarDepartamento() {
        setListaDepartamento(departamentoBL.listar());
    }

    public void listarProvincias() {
        if (distrito.getProvincia().getDepartamento() != null) {
            System.out.println("id depa " + distrito.getProvincia().getDepartamento().getIddepartamento());
            long id = distrito.getProvincia().getDepartamento().getIddepartamento();
            setListaProvincia(provinciaBL.listarxDpto(id));
            System.out.println("lista tamaño " + listaProvincia.size());
        }else{
            limpiar();
        }

    }

    public void listarDistritos() {
        System.out.println("id provincia  " + distrito.getProvincia().getIdprovincia());
        long id = distrito.getProvincia().getIdprovincia();
        setListaDistrito(distritoBL.listarxProv(id));
        System.out.println("distrito tamaño " + listaDistrito.size());
    }

    public void limpiar() {
        distrito.setIddistrito(Long.MIN_VALUE);
        distrito.getProvincia().getDepartamento().setIddepartamento(Long.MIN_VALUE);
        distrito.getProvincia().setIdprovincia(Long.MIN_VALUE);

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

    public DistritoBL getDistritoBL() {
        return distritoBL;
    }

    public void setDistritoBL(DistritoBL distritoBL) {
        this.distritoBL = distritoBL;
    }

    public Distrito getDistrito() {
        return distrito;
    }

    public void setDistrito(Distrito distrito) {
        this.distrito = distrito;
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

    public List<Distrito> getListaDistrito() {
        return listaDistrito;
    }

    public void setListaDistrito(List<Distrito> listaDistrito) {
        this.listaDistrito = listaDistrito;
    }

    public List<SelectItem> getSelectOneItemsDistrito() {
        this.selectOneItemsDistrito = new LinkedList<SelectItem>();
        for (Distrito oDis : listaDistrito) {
            this.setDistrito(oDis);
            SelectItem selectItem = new SelectItem(distrito.getIddistrito(), distrito.getDenominacion());
            this.selectOneItemsDistrito.add(selectItem);
        }
        return selectOneItemsDistrito;
    }

    public void setSelectOneItemsDistrito(List<SelectItem> selectOneItemsDistrito) {
        this.selectOneItemsDistrito = selectOneItemsDistrito;
    }

}
