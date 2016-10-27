
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Especie;
import org.jgc.herbarium.be.Genero;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class EspecieDA extends AbstractDA<Especie>{

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
        return list(Especie.class);
    }

    @Override
    public List<Especie> listar(String ref) {
        return list("from especie e left join fetch e.genero");
    }

    @Override
    public List<Especie> listar(long id) {
        return list(Especie.class, Genero.class, id);
    }

    @Override
    public Especie buscar(long id) {
        return search(Especie.class,id);
    }

    @Override
    public Especie buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Especie.class);
    }
    
}
