
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Especie;
import org.jgc.herbarium.da.EspecieDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class EspecieBL extends AbstractBL<Especie>{

    @Autowired
    @Qualifier("especieDA")
    private EspecieDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (EspecieDA) dao;
    }

    @Override
    public long registrar(Especie bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Especie bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Especie bean) {
        return delete(bean);
    }

    @Override
    public List<Especie> listar() {
        return list();
    }

    @Override
    public List<Especie> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Especie> listar(long id) {
        return list(id);
    }

    @Override
    public Especie buscar(long id) {
        return search(id);
    }

    @Override
    public Especie buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
