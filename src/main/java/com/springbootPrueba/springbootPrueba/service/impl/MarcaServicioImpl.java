package com.springbootPrueba.springbootPrueba.service.impl;

import com.springbootPrueba.springbootPrueba.exceptions.MarcaNotFoundException;
import com.springbootPrueba.springbootPrueba.model.Marca;
import com.springbootPrueba.springbootPrueba.repository.MarcaRepositorio;
import com.springbootPrueba.springbootPrueba.service.MarcaServicio;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServicioImpl implements MarcaServicio {

    @Autowired
    private MarcaRepositorio repositorio;

    @Override
    public List<?> findAll() {
        return repositorio.findAll();
    }

    @Override
    public Marca findById(int id) throws NotFoundException {
        return repositorio.findById(id).orElseThrow(() -> new MarcaNotFoundException("No se encuentra el marca " + id));
    }

    @Override
    public Marca save(Marca marca) {
        return repositorio.save(marca);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        Marca aBorrar = findById(id);
        repositorio.delete(aBorrar);
    }
}
