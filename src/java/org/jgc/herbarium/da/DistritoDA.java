/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Distrito;
import org.jgc.herbarium.be.Provincia;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PROFESIONAL
 */
@Repository
public class DistritoDA extends AbstractDA<Distrito>{

    @Override
    public long registrar(Distrito bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Distrito bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Distrito bean) {
        return delete(bean);
    }

    @Override
    public List<Distrito> listar() {
        return list(Distrito.class);
    }

    @Override
    public List<Distrito> listar(String ref) {
        return list("from Distrito d left join fetch d.provincia");
    }

    @Override
    public List<Distrito> listar(long id) {
        return list(Distrito.class, Provincia.class, id);
    }

    @Override
    public Distrito buscar(long id) {
        return search(Distrito.class, id);
    }

    @Override
    public Distrito buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Distrito.class);
    }

    public List<Distrito> listarxProv(long id) {
        return listar(id);
    }
    
}
