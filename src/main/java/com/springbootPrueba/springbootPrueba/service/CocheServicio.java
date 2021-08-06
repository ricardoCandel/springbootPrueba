package com.springbootPrueba.springbootPrueba.service;

import com.springbootPrueba.springbootPrueba.model.Coche;
import javassist.NotFoundException;

import java.util.List;

public interface CocheServicio {
    List<?> findAll();

    Coche findById(int id) throws NotFoundException;

    Coche save(Coche coche);

    void delete(int id) throws NotFoundException;
}
