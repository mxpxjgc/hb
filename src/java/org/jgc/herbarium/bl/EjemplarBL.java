
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Ejemplar;
import org.jgc.herbarium.da.EjemplarDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EjemplarBL extends AbstractBL<Ejemplar>{

    @Autowired
    @Qualifier("ejemplarDA")
    private EjemplarDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (EjemplarDA) dao;
    }

    @Override
    public long registrar(Ejemplar bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Ejemplar bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Ejemplar bean) {
        return delete(bean);
    }

    @Override
    public List<Ejemplar> listar() {
        return list();
    }

    @Override
    public List<Ejemplar> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Ejemplar> listar(long id) {
        return list(id);
    }

    @Override
    public Ejemplar buscar(long id) {
        return search(id);
    }

    @Override
    public Ejemplar buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
