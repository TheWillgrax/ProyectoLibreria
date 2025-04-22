package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Inventarios")
@Data
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_bodega")
    private Bodega bodega;

    @Column(nullable = false)
    private Integer cantidad;
}
