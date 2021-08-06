package com.springbootPrueba.springbootPrueba.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Marcas")
public class Marca implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(fetch=FetchType.LAZY, mappedBy="marca", cascade={CascadeType.ALL})
    private List<Coche> coches;
}
