
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Imagen;
import org.jgc.herbarium.da.ImagenDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ImagenBL extends AbstractBL<Imagen>{

    @Autowired
    @Qualifier("imagenDA")
    private ImagenDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ImagenDA) dao;
    }

    @Override
    public long registrar(Imagen bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Imagen bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Imagen bean) {
        return delete(bean);
    }

    @Override
    public List<Imagen> listar() {
        return list();
    }

    @Override
    public List<Imagen> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Imagen> listar(long id) {
        return list(id);
    }

    @Override
    public Imagen buscar(long id) {
        return search(id);
    }

    @Override
    public Imagen buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
