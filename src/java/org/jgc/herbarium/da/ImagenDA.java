
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Ejemplar;
import org.jgc.herbarium.be.Imagen;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class ImagenDA extends AbstractDA<Imagen>{

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
        return list(Imagen.class);
    }

    @Override
    public List<Imagen> listar(String ref) {
        return list("from imagen i left join fetch i.ejemplar");
    }

    @Override
    public List<Imagen> listar(long id) {
        return list(Imagen.class, Ejemplar.class, id);
    }

    @Override
    public Imagen buscar(long id) {
        return search(Imagen.class, id);
    }

    @Override
    public Imagen buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Imagen.class);
    }
    
}
