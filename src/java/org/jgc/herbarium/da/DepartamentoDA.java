/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.da;

import java.util.List;
import org.jgc.herbarium.be.Departamento;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.stereotype.Repository;

/**
 *
 * @author PROFESIONAL
 */
@Repository
public class DepartamentoDA extends AbstractDA<Departamento>{

    @Override
    public long registrar(Departamento bean) {
        return save(bean);
    }

    @Override
    public long actualizar(Departamento bean) {
        return update(bean);
    }

    @Override
    public long eliminar(Departamento bean) {
        return delete(bean);
    }

    @Override
    public List<Departamento> listar() {
        return list(Departamento.class);
    }

    @Override
    public List<Departamento> listar(String ref) {
        return list("from Departamento as d where d.denominacion like '%" + ref + "%'");
    }

    @Override
    public List<Departamento> listar(long id) {
        return list(Class.class, Class.class, id);
    }

    @Override
    public Departamento buscar(long id) {
        return search(Departamento.class, id);
    }

    @Override
    public Departamento buscar(String ref) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long id() {
        return maxId(Departamento.class);
    }
    
}
