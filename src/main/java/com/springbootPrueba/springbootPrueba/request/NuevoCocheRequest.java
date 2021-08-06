package com.springbootPrueba.springbootPrueba.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NuevoCocheRequest {

    private String modelo;
    private String color;
    private int marca;
}
