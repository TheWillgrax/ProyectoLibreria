package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Proveedores")
@Data
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 100)
    private String contacto;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;
}
