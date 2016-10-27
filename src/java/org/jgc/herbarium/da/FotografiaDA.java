
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Colecta;
import org.jgc.herbarium.be.Fotografia;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class FotografiaDA extends AbstractDA<Fotografia>{

    @Override
    public long registrar(Fotografia bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Fotografia bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Fotografia bean) {
        return delete(bean);
    }

    @Override
    public List<Fotografia> listar() {
        return list(Fotografia.class);
    }

    @Override
    public List<Fotografia> listar(String ref) {
        return list("from fotografia f left join fetch f.colecta");
    }

    @Override
    public List<Fotografia> listar(long id) {
        return list(Fotografia.class, Colecta.class, id);
    }

    @Override
    public Fotografia buscar(long id) {
        return search(Fotografia.class, id);
    }

    @Override
    public Fotografia buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Fotografia.class);
    }
    
}
