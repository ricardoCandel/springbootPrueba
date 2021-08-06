package com.springbootPrueba.springbootPrueba.controllers;

import com.springbootPrueba.springbootPrueba.model.Oferta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/ofertas")
public class OfertasController {

    private static final String template = "%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public ResponseEntity<List<Oferta>> bucarPorCocheYFechaInicio(
        @RequestParam(value = "idCoche") int idCoche,
        @RequestParam(value = "fechaInicio") Date fechaInicio
    ) {
        return null;
    }
}
