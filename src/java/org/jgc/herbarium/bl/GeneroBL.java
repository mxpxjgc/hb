
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Genero;
import org.jgc.herbarium.da.GeneroDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GeneroBL extends AbstractBL<Genero>{

    @Autowired
    @Qualifier("generoDA")
    private GeneroDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (GeneroDA) dao;
    }

    @Override
    public long registrar(Genero bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Genero bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Genero bean) {
        return delete(bean);
    }

    @Override
    public List<Genero> listar() {
        return list();
    }

    @Override
    public List<Genero> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Genero> listar(long id) {
        return list(id);
    }

    @Override
    public Genero buscar(long id) {
        return search(id);
    }

    @Override
    public Genero buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }

    public List<Genero> listarxIDFamilia(long id) {
        return dao.listarxIDFamilia(id);
    }
    
}
