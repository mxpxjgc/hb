
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Colecta;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class ColectaDA extends AbstractDA<Colecta>{

    @Override
    public long registrar(Colecta bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Colecta bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Colecta bean) {
        return delete(bean);
    }

    @Override
    public List<Colecta> listar() {
        return list(Colecta.class);
    }

    @Override
    public List<Colecta> listar(String ref) {
        return list("from colecta as c where c.descripcion like '%"+ref+"%'");
    }

    @Override
    public List<Colecta> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Colecta buscar(long id) {
        return search(Colecta.class, id);
    }

    @Override
    public Colecta buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Colecta.class);
    }
    
}
