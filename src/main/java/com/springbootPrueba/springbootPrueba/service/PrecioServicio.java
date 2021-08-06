package com.springbootPrueba.springbootPrueba.service;

import com.springbootPrueba.springbootPrueba.model.Precio;
import javassist.NotFoundException;

import java.util.Date;
import java.util.List;

public interface PrecioServicio {
    Precio findById(int id) throws NotFoundException;

    Precio findByFechaInicio(Date fechaInicio) throws NotFoundException;

    Precio save(Precio precio);

    void delete(int id) throws NotFoundException;
}
