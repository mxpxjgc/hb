
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Familia;
import org.jgc.herbarium.da.FamiliaDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FamiliaBL extends AbstractBL<Familia>{

    @Autowired
    @Qualifier("familiaDA")
    private FamiliaDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FamiliaDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Familia> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Familia> listar(long id) {
        return list(id);
    }

    @Override
    public Familia buscar(long id) {
        return search(id);
    }

    @Override
    public Familia buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
