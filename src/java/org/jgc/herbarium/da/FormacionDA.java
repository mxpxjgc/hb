
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Formacion;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class FormacionDA extends AbstractDA<Formacion>{

    @Override
    public long registrar(Formacion bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Formacion bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Formacion bean) {
        return delete(bean);
    }

    @Override
    public List<Formacion> listar() {
        return list(Formacion.class);
    }

    @Override
    public List<Formacion> listar(String ref) {
        return list("from formacion_vegetal as f where f.formacionvegetal like '%"+ref+"%'");
    }

    @Override
    public List<Formacion> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Formacion buscar(long id) {
        return search(Formacion.class, id);
    }

    @Override
    public Formacion buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Formacion.class);
    }
    
}
