
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Casillero;
import org.jgc.herbarium.be.Gabinete;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class CasilleroDA extends AbstractDA<Casillero>{

    @Override
    public long registrar(Casillero bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Casillero bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Casillero bean) {
        return delete(bean);
    }

    @Override
    public List<Casillero> listar() {
        return list(Casillero.class);
    }

    @Override
    public List<Casillero> listar(String ref) {
        return list("from Casillero c left join fetch c.gabinete");
    }

    @Override
    public List<Casillero> listar(long id) {
        return list(Casillero.class, Gabinete.class, id);
    }

    @Override
    public Casillero buscar(long id) {
        return search(Casillero.class,id);
    }

    @Override
    public Casillero buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Casillero.class);
    }

    
    
}
