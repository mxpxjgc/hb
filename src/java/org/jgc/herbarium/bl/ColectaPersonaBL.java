
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.ColectaPersona;
import org.jgc.herbarium.da.ColectaPersonaDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ColectaPersonaBL extends AbstractBL<ColectaPersona>{

    @Autowired
    @Qualifier("colectaPersonaDA")
    private ColectaPersonaDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ColectaPersonaDA) dao;
    }

    @Override
    public long registrar(ColectaPersona bean) {
        return save(bean);
    }

    @Override
    public long actualizar(ColectaPersona bean) {
        return update(bean);
    }

    @Override
    public long eliminar(ColectaPersona bean) {
        return delete(bean);
    }

    @Override
    public List<ColectaPersona> listar() {
        return list();
    }

    @Override
    public List<ColectaPersona> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<ColectaPersona> listar(long id) {
        return list(id);
    }

    @Override
    public ColectaPersona buscar(long id) {
        return search(id);
    }

    @Override
    public ColectaPersona buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
