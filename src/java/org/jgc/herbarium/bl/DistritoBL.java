/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Distrito;
import org.jgc.herbarium.da.DistritoDA;
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
public class DistritoBL extends AbstractBL<Distrito>{

    @Autowired
    @Qualifier("distritoDA")
    private DistritoDA dao;
    
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (DistritoDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Distrito> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Distrito> listar(long id) {
        return list(id);
    }

    @Override
    public Distrito buscar(long id) {
        return search(id);
    }

    @Override
    public Distrito buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
