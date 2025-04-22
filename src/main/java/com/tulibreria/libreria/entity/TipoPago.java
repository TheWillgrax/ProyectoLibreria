package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TiposPago")
@Data
public class TipoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_pago")
    private Long id;

    @Column(nullable = false, length = 50)
    private String metodo;
}
