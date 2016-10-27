/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jgc.herbarium.bl;

import java.util.List;
import org.jgc.herbarium.be.Provincia;
import org.jgc.herbarium.da.ProvinciaDA;
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
public class ProvinciaBL extends AbstractBL<Provincia>{

    @Autowired
    @Qualifier("provinciaDA")
    private ProvinciaDA dao;
    @Override
    public AbstractDA getDAO() {
        return dao;
    }

    @Override
    public void setDA(AbstractDA dao) {
        this.dao = (ProvinciaDA) dao;
    }

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
        return list();
    }

    @Override
    public List<Provincia> listar(String ref) {
        return list(ref);
    }

    @Override
    public List<Provincia> listar(long id) {
        return list(id);
    }

    @Override
    public Provincia buscar(long id) {
        return search(id);
    }

    @Override
    public Provincia buscar(String ref) {
        return search(ref);
    }

    @Override
    public long id() {
        return maxId();
    }
    
}
