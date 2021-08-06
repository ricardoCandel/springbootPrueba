package com.springbootPrueba.springbootPrueba.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Coches")
public class Coche implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "color")
    private String color;

    @ManyToOne(cascade= { CascadeType.ALL})
    @JoinColumn(name="marca_id")
    private Marca marca;

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", marca=" + marca.getId() +
                '}';
    }
}
