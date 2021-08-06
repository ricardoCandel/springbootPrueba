package com.springbootPrueba.springbootPrueba.repository;

import com.springbootPrueba.springbootPrueba.model.Coche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocheRepositorio extends JpaRepository<Coche, Integer> {
}
