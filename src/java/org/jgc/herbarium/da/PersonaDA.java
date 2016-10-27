
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Persona;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class PersonaDA extends AbstractDA<Persona>{

    @Override
    public long registrar(Persona bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Persona bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Persona bean) {
        return delete(bean);
    }

    @Override
    public List<Persona> listar() {
        return list(Persona.class);
    }

    @Override
    public List<Persona> listar(String ref) {
        return list("from persona as p where p.dni like '%"+ref+"%'");
    }

    @Override
    public List<Persona> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona buscar(long id) {
        return search(Persona.class, id);
    }

    @Override
    public Persona buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Persona.class);
    }
    
}
