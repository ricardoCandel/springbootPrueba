package com.springbootPrueba.springbootPrueba.service.impl;

import com.springbootPrueba.springbootPrueba.exceptions.CocheNotFoundException;
import com.springbootPrueba.springbootPrueba.model.Coche;
import com.springbootPrueba.springbootPrueba.repository.CocheRepositorio;
import com.springbootPrueba.springbootPrueba.repository.MarcaRepositorio;
import com.springbootPrueba.springbootPrueba.service.CocheServicio;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CocheServicioImpl implements CocheServicio {

    @Autowired
    private CocheRepositorio repositorio;

    @Autowired
    private MarcaRepositorio marcaRepositorio;

    @Override
    public List<Coche> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Coche findById(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new CocheNotFoundException("No se encuentra el coche " + id));
    }

    @Override
    public Coche save(Coche coche) throws NotFoundException {
        marcaRepositorio.findById(coche.getMarca().getId());
        return repositorio.save(coche);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Coche aBorrar = findById(id);
        repositorio.delete(aBorrar);
    }
}
