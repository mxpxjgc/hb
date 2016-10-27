
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Habito;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class HabitoDA extends AbstractDA<Habito>{

    @Override
    public long registrar(Habito bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Habito bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Habito bean) {
        return delete(bean);
    }

    @Override
    public List<Habito> listar() {
        return list(Habito.class);
    }

    @Override
    public List<Habito> listar(String ref) {
        return list("from habito as h where h.nombrehabito like '%"+ref+"%'");
    }

    @Override
    public List<Habito> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Habito buscar(long id) {
        return search(Habito.class, id);
    }

    @Override
    public Habito buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Habito.class);
    }
    
}
