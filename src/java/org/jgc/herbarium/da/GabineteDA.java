
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Gabinete;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class GabineteDA extends AbstractDA<Gabinete>{

    @Override
    public long registrar(Gabinete bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Gabinete bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Gabinete bean) {
        return delete(bean);
    }

    @Override
    public List<Gabinete> listar() {
        return list(Gabinete.class);
    }

    @Override
    public List<Gabinete> listar(String ref) {
        return list("from gabinete as g where g.codigo like '%" + ref + "%'");
    }

    @Override
    public List<Gabinete> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gabinete buscar(long id) {
        return search(Gabinete.class, id);
    }

    @Override
    public Gabinete buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Gabinete.class);
    }
    
}
