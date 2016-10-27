
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Gabinete;
import org.jgc.herbarium.da.GabineteDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GabineteBL extends AbstractBL<Gabinete>{

    @Autowired
    @Qualifier("gabineteDA")
    private GabineteDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (GabineteDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Gabinete> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Gabinete> listar(long id) {
        return list(id);
    }

    @Override
    public Gabinete buscar(long id) {
        return search(id);
    }

    @Override
    public Gabinete buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
