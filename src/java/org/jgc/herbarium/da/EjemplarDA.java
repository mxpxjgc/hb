
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Casillero;
import org.jgc.herbarium.be.Ejemplar;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class EjemplarDA extends AbstractDA<Ejemplar>{

    @Override
    public long registrar(Ejemplar bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Ejemplar bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Ejemplar bean) {
        return delete(bean);
    }

    @Override
    public List<Ejemplar> listar() {
        return list(Ejemplar.class);        
    }

    @Override
    public List<Ejemplar> listar(String ref) {
        return list("from ejemplar e left join fetch e.casillero");
    }

    @Override
    public List<Ejemplar> listar(long id) {
        return list(Ejemplar.class, Casillero.class, id);
    }

    @Override
    public Ejemplar buscar(long id) {
        return search(Ejemplar.class,id);
    }

    @Override
    public Ejemplar buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Ejemplar.class);
    }
    
}
