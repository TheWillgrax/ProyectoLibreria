package com.tulibreria.libreria.repository;

import com.tulibreria.libreria.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
