package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Compras")
@Data
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_proveedor")
    private Proveedor proveedor;

    @Column(name = "fecha_compra", nullable = false)
    private LocalDate fechaCompra;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
}
