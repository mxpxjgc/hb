
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Usuario;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDA extends AbstractDA<Usuario>{

    @Override
    public long registrar(Usuario bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Usuario bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Usuario bean) {
        return delete(bean);
    }

    @Override
    public List<Usuario> listar() {
        return list(Usuario.class);
    }

    @Override
    public List<Usuario> listar(String ref) {
        return list("from usuario as u where u.usuario like '%"+ref+"%'");
    }

    @Override
    public List<Usuario> listar(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario buscar(long id) {
        return search(Usuario.class, id);
    }

    @Override
    public Usuario buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Usuario.class);
    }
    
}
