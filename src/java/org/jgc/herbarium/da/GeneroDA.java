
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Genero;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("generoDA")
public class GeneroDA extends AbstractDA<Genero>{

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
        return list(Genero.class);
    }

    @Override
    public List<Genero> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Genero> listar(long id) {
        return list(Class.class, Class.class, id);
    }

    @Override
    public Genero buscar(long id) {
        return search(Genero.class, id);
    }

    @Override
    public Genero buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Genero.class);
    }

    public List<Genero> listarxIDFamilia(long id) {
        String hql = "from Genero a inner join fetch a.familia b where b.idfamilia=" + id;
        return listar(hql);
    }
    
}
