
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Habito;
import org.jgc.herbarium.da.HabitoDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class HabitoBL extends AbstractBL<Habito>{

    @Autowired
    @Qualifier("habitoDA")
    private HabitoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (HabitoDA) dao;
    }

    @Override
    public long registrar(Habito bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Habito bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Habito bean) {
        return delete(bean);
    }

    @Override
    public List<Habito> listar() {
        return list();
    }

    @Override
    public List<Habito> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Habito> listar(long id) {
        return list(id);
    }

    @Override
    public Habito buscar(long id) {
        return search(id);
    }

    @Override
    public Habito buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
