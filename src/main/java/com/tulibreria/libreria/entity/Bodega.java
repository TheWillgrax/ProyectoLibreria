package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Bodegas")
@Data
public class Bodega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bodega")
    private Long id;

    @Column(nullable = false, length = 255)
    private String ubicacion;

    @Column(nullable = false)
    private Integer capacidad;
}
