package com.springbootPrueba.springbootPrueba.repository;

import com.springbootPrueba.springbootPrueba.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepositorio extends JpaRepository<Marca, Integer> {
}
