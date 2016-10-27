
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Casillero;
import org.jgc.herbarium.da.CasilleroDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CasilleroBL extends AbstractBL<Casillero>{

    @Autowired
    @Qualifier("casilleroDA")
    private CasilleroDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (CasilleroDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Casillero> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Casillero> listar(long id) {
        return list(id);
    }

    @Override
    public Casillero buscar(long id) {
        return search(id);
    }

    @Override
    public Casillero buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
