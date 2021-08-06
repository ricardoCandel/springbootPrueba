package com.springbootPrueba.springbootPrueba.repository;

import com.springbootPrueba.springbootPrueba.model.Precio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioRepositorio extends JpaRepository<Precio, Integer>  {
}
