package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Familia;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class FamiliaDA extends AbstractDA<Familia> {

    @Override
    public long registrar(Familia bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Familia bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Familia bean) {
        return delete(bean);
    }

    @Override
    public List<Familia> listar() {
        return list(Familia.class);
    }

    @Override
    public List<Familia> listar(String ref) {
        return list("from Familia as f where f.denominacion like '%" + ref + "%'");
    }

    @Override
    public List<Familia> listar(long id) {
        return list(Class.class, Class.class, id);
    }

    @Override
    public Familia buscar(long id) {
        return search(Familia.class, id);
    }

    @Override
    public Familia buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public long id() {
        return maxId(Familia.class);

    }
}
