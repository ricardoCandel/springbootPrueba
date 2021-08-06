package com.springbootPrueba.springbootPrueba.service;

import com.springbootPrueba.springbootPrueba.model.Coche;
import javassist.NotFoundException;

import java.util.List;

public interface CocheServicio {
    List<Coche> findAll();

    Coche findById(int id) throws NotFoundException;

    Coche save(Coche coche) throws NotFoundException;

    void delete(int id) throws NotFoundException;
}
