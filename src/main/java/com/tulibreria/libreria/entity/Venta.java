package com.tulibreria.libreria.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Ventas")
@Data
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pago")
    private TipoPago tipoPago;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDate fechaVenta;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;
}
