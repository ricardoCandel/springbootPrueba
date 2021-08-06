package com.springbootPrueba.springbootPrueba.service;

import com.springbootPrueba.springbootPrueba.model.Marca;
import javassist.NotFoundException;

import java.util.List;

public interface MarcaServicio {
    List<?> findAll();

    Marca findById(int id) throws NotFoundException;

    Marca save(Marca marca);

    void delete(int id) throws NotFoundException;
}
