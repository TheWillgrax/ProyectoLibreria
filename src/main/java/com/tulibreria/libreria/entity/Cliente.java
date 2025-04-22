package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Clientes")
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 20)
    private String telefono;

    @Column(length = 100)
    private String email;
}
