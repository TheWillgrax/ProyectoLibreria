package com.tulibreria.libreria.repository;

import com.tulibreria.libreria.entity.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario, Long> {
}
