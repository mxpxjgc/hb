package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.UsuarioRol;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

@Repository("usuarioRolDA")
public class UsuarioRolDA extends AbstractDA<UsuarioRol>{

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
        return list(UsuarioRol.class);
    }

    @Override
    public List<UsuarioRol> listar(String ref) {
        return list("");
    }

    @Override
    public List<UsuarioRol> listar(long id) {
        return list(UsuarioRol.class, UsuarioRol.class, id);
    }

    @Override
    public UsuarioRol buscar(long id) {
        return search(UsuarioRol.class, id);
    }

    @Override
    public long id() {
        return maxId(UsuarioRol.class);
    }

    @Override
    public UsuarioRol buscar(String ref) {
        int idExterno = Integer.parseInt(ref);
        return search("from UsuarioRol as ur where ur.usuario="+idExterno);
    }
    
}
