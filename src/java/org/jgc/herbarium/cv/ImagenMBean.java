
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
import org.jgc.herbarium.be.Ejemplar;
import org.jgc.herbarium.be.Imagen;
import org.jgc.herbarium.bl.ImagenBL;
import org.jgc.herbarium.util.Tarea;
import static org.jgc.herbarium.util.Utilitario.setTareaEvento;

@ManagedBean
@ViewScoped
public class ImagenMBean {
    @ManagedProperty(value = "#{imagenBL}")
    private ImagenBL imagenBL;
    
    @ManagedProperty(value = "#{imagen}")
    private Imagen imagen;
    
    private List<Imagen> listaImagen = new LinkedList<>();    
    private List<SelectItem> selectOneItemsImagen;
    
    public void registrarImagen() {
        setTareaEvento(new Tarea(Tarea.REGISTRO, getImagenBL().registrar(getImagen())) {
            @Override
            public void proceso() {
                imagen = new Imagen();
                listarImagen();
            }
        });
    }
    
    public void actualizarImagen(ActionEvent actionEvent) {
        System.out.println("Entra a actualizarImagen()");
        Imagen temp = new Imagen();
        String msg;
        temp = buscarId();
        temp.setEjemplar(this.getImagen().getEjemplar());
        temp.setImagenOriginal(this.getImagen().getImagenOriginal());
        temp.setImagenReducido(this.getImagen().getImagenReducido());
        long res = imagenBL.actualizar(temp);
        if(res==0){
            msg="Se actualizó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al actualizar el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        listarImagen();
    }
    
    public void eliminarImagen() {    
        System.out.println("Ingresa a eliminarImagen()");
        Imagen temp = new Imagen();
        String msg;
        temp = buscarId();
        long res = imagenBL.eliminar(temp);        
        if(res==0){
            msg="Se eliminó correctamente el registro.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }else{
            msg="Error al eliminar el registro.";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Atención", msg);
            FacesContext.getCurrentInstance().addMessage(null, message);
        }              
        listarImagen();
    }
    
    public Imagen buscarId(){
        System.out.println("ID enviado: "+getImagen().getIdimagen());
        return imagenBL.buscar(getImagen().getIdimagen());
    }

    @PostConstruct
    public void listarImagen() {
        setListaImagen(imagenBL.listar());
    }
    
    public void limpiar() {
        this.imagen.setIdimagen(Long.MIN_VALUE);        
        this.imagen.setEjemplar(new Ejemplar());
        this.imagen.setImagenOriginal(null);
        this.imagen.setImagenReducido(null);
        this.imagen.setDescripcion("");
        this.imagen.setObservacion("");
    }

    public ImagenBL getImagenBL() {
        return imagenBL;
    }

    public void setImagenBL(ImagenBL imagenBL) {
        this.imagenBL = imagenBL;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public List<Imagen> getListaImagen() {
        return listaImagen;
    }

    public void setListaImagen(List<Imagen> listaImagen) {
        this.listaImagen = listaImagen;
    }

    public List<SelectItem> getSelectOneItemsImagen() {
        this.selectOneItemsImagen = new LinkedList<SelectItem>();
        for (Imagen oImagen : listaImagen) {
            this.setImagen(oImagen);
            SelectItem selectItem = new SelectItem(imagen.getIdimagen(), imagen.getDescripcion());
            this.selectOneItemsImagen.add(selectItem);
        }        
        return selectOneItemsImagen;
    }

    public void setSelectOneItemsImagen(List<SelectItem> selectOneItemsImagen) {
        this.selectOneItemsImagen = selectOneItemsImagen;
    }
    
}
