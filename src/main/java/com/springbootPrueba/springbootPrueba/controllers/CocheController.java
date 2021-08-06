package com.springbootPrueba.springbootPrueba.controllers;

import com.springbootPrueba.springbootPrueba.model.Coche;
import com.springbootPrueba.springbootPrueba.service.CocheServicio;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    private CocheServicio service;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        try {
            List<?> list = service.findAll();
            return ResponseEntity.ok().body(list); // return 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Coche coche = service.findById( id);
            return ResponseEntity.ok().body(coche); // return 200
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build(); // return 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Coche coche) {
        try {
            Coche guardado = service.save(coche);
            return ResponseEntity.ok().body(guardado); // return 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            service.delete(id);
            return ResponseEntity.accepted().build(); // return 202
        } catch (NotFoundException e) {
            return ResponseEntity.noContent().build(); // return 204
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }
}
