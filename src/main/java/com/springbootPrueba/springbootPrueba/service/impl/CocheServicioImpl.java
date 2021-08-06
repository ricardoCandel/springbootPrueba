package com.springbootPrueba.springbootPrueba.service.impl;

import com.springbootPrueba.springbootPrueba.model.Coche;
import com.springbootPrueba.springbootPrueba.repository.CocheRepositorio;
import com.springbootPrueba.springbootPrueba.service.CocheServicio;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CocheServicioImpl implements CocheServicio {

    @Autowired
    private CocheRepositorio repositorio;

    @Override
    public List<Coche> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Coche findById(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new NotFoundException("No se encuentra el coche " + id));
    }

    @Override
    public Coche save(Coche employee) {
        return repositorio.save(employee);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Coche aBorrar = findById(id);
        repositorio.delete(aBorrar);
    }
}
