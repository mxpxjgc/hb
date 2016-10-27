
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Formacion;
import org.jgc.herbarium.da.FormacionDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FormacionBL extends AbstractBL<Formacion>{

    @Autowired
    @Qualifier("formacionDA")
    private FormacionDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (FormacionDA) dao;
    }

    @Override
    public long registrar(Formacion bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Formacion bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Formacion bean) {
        return delete(bean);
    }

    @Override
    public List<Formacion> listar() {
        return list();
    }

    @Override
    public List<Formacion> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Formacion> listar(long id) {
        return list(id);
    }

    @Override
    public Formacion buscar(long id) {
        return search(id);
    }

    @Override
    public Formacion buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
