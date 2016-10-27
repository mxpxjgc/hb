
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.UsuarioRol;
import org.jgc.herbarium.da.UsuarioRolDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRolBL extends AbstractBL<UsuarioRol>{

    @Autowired
    @Qualifier("usuarioRolDA")
    private UsuarioRolDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (UsuarioRolDA) dao;
    }

    @Override
    public long registrar(UsuarioRol bean) {
        return save(bean);
    }

    @Override
    public long actualizar(UsuarioRol bean) {
        return update(bean);
    }

    @Override
    public long eliminar(UsuarioRol bean) {
        return delete(bean);
    }

    @Override
    public List<UsuarioRol> listar() {
        return list();
    }

    @Override
    public List<UsuarioRol> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<UsuarioRol> listar(long id) {
        return list(id);
    }

    @Override
    public UsuarioRol buscar(long id) {
        return search(id);
    }

    @Override
    public UsuarioRol buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
