/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Departamento;
import org.jgc.herbarium.da.DepartamentoDA;
import org.jgc.herbarium.util.AbstractBL;
import org.jgc.herbarium.util.AbstractDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author PROFESIONAL
 */
@Service
public class DepartamentoBL extends AbstractBL<Departamento>{

    @Autowired
    @Qualifier("departamentoDA")
    private DepartamentoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (DepartamentoDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Departamento> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Departamento> listar(long id) {
        return list(id);
    }

    @Override
    public Departamento buscar(long id) {
        return search(id);
    }

    @Override
    public Departamento buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
