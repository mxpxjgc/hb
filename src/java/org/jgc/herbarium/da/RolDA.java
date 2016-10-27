
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Rol;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class RolDA extends AbstractDA<Rol>{

    @Override
    public long registrar(Rol bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Rol bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Rol bean) {
        return delete(bean);
    }

    @Override
    public List<Rol> listar() {
        return list(Rol.class);
    }

    @Override
    public List<Rol> listar(String ref) {
        return list("from rol as r where r.nombre_rol like '%"+ref+"%'");
    }

    @Override
    public List<Rol> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol buscar(long id) {
        return search(Rol.class, id);
    }

    @Override
    public Rol buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Rol.class);
    }
    
}
