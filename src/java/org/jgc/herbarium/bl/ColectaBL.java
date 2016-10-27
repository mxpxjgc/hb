
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Colecta;
import org.jgc.herbarium.da.ColectaDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ColectaBL extends AbstractBL<Colecta>{

    @Autowired
    @Qualifier("colectaDA")
    private ColectaDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ColectaDA)dao;
    }

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
        return list();
    }

    @Override
    public List<Colecta> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Colecta> listar(long id) {
        return list(id);
    }

    @Override
    public Colecta buscar(long id) {
        return search(id);
    }

    @Override
    public Colecta buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
