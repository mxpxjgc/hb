
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Fotografia;
import org.jgc.herbarium.da.FotografiaDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FotografiaBL extends AbstractBL<Fotografia>{

    @Autowired
    @Qualifier("fotografiaDA")
    private FotografiaDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FotografiaDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Fotografia> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Fotografia> listar(long id) {
        return list(id);
    }

    @Override
    public Fotografia buscar(long id) {
        return search(id);
    }

    @Override
    public Fotografia buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
