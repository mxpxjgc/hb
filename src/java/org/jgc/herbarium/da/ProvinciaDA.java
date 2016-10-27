/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Departamento;
import org.jgc.herbarium.be.Provincia;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PROFESIONAL
 */
@Repository
public class ProvinciaDA extends AbstractDA<Provincia>{

    @Override
    public long registrar(Provincia bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Provincia bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Provincia bean) {
        return delete(bean);
    }

    @Override
    public List<Provincia> listar() {
        return list(Provincia.class);
    }

    @Override
    public List<Provincia> listar(String ref) {
        return list("from Provincia p left join fetch p.departamento");
    }

    @Override
    public List<Provincia> listar(long id) {
        return list(Provincia.class, Departamento.class, id);
    }

    @Override
    public Provincia buscar(long id) {
        return search(Provincia.class, id);
    }

    @Override
    public Provincia buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Provincia.class);
    }
    
}
