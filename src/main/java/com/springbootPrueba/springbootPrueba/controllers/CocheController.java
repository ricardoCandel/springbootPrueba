package com.springbootPrueba.springbootPrueba.controllers;

import com.springbootPrueba.springbootPrueba.exceptions.MarcaNotFoundException;
import com.springbootPrueba.springbootPrueba.model.Coche;
import com.springbootPrueba.springbootPrueba.model.Marca;
import com.springbootPrueba.springbootPrueba.request.BuscarCocheAnswer;
import com.springbootPrueba.springbootPrueba.request.NuevoCocheAnswer;
import com.springbootPrueba.springbootPrueba.request.NuevoCocheRequest;
import com.springbootPrueba.springbootPrueba.service.CocheServicio;
import com.springbootPrueba.springbootPrueba.service.MarcaServicio;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coche")
public class CocheController {

    @Autowired
    private CocheServicio cocheService;

    @Autowired
    private MarcaServicio marcaServicio;

    @GetMapping
    public ResponseEntity<List<?>> findAll() {
        try {
            List<Coche> coches = cocheService.findAll();
            List<BuscarCocheAnswer> respuesta = new ArrayList<>();
            for(Coche coche : coches) {
                respuesta.add(new BuscarCocheAnswer(coche));
            }
            return ResponseEntity.ok().body(respuesta); // return 200
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable int id) {
        try {
            Coche coche = cocheService.findById( id);
            return ResponseEntity.ok().body(new NuevoCocheAnswer(coche)); // return 200
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build(); // return 404
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody NuevoCocheRequest nuevoCoche) {
        try {
            Marca marca = marcaServicio.findById(nuevoCoche.getMarca());
            Coche cocheAGuardar = new Coche();
            cocheAGuardar.setModelo(nuevoCoche.getModelo());
            cocheAGuardar.setColor(nuevoCoche.getColor());
            cocheAGuardar.setMarca(marca);
            Coche guardado = cocheService.save(cocheAGuardar);
            return ResponseEntity.status(201).body(new NuevoCocheAnswer(guardado)); // return 200
        } catch (MarcaNotFoundException marcaEx) {
            return ResponseEntity.status(406).body(marcaEx);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        try {
            cocheService.delete(id);
            return ResponseEntity.accepted().build(); // return 202
        } catch (NotFoundException e) {
            return ResponseEntity.noContent().build(); // return 204
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build(); // return 500
        }
    }
}
