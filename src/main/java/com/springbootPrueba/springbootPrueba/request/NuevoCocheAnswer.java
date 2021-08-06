package com.springbootPrueba.springbootPrueba.request;

import com.springbootPrueba.springbootPrueba.model.Coche;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NuevoCocheAnswer {

    private int id;
    private String modelo;
    private String color;
    private int marca;

    public NuevoCocheAnswer(Coche coche) {
        this.id = coche.getId();
        this.modelo = coche.getModelo();
        this.color = coche.getColor();
        this.marca = coche.getMarca().getId();
    }
}
