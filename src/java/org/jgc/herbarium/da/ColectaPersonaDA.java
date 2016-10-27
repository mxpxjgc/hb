
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.ColectaPersona;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("colectaPersonaDA")
public class ColectaPersonaDA extends AbstractDA<ColectaPersona>{

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
        return list(ColectaPersona.class);
    }

    @Override
    public List<ColectaPersona> listar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ColectaPersona> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ColectaPersona buscar(long id) {
        return search(ColectaPersona.class, id);
    }

    @Override
    public ColectaPersona buscar(String ref) {
        int idExterno = Integer.parseInt(ref);
        return search("from ColectaPersona as cp where cp.colecta="+idExterno);
    }

    @Override
    public long id() {
        return maxId(ColectaPersona.class);
    }
    
}
