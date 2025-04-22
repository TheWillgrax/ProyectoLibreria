package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Categorias")
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;
}


