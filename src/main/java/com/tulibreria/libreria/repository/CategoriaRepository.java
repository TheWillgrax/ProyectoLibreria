package com.tulibreria.libreria.repository;

import com.tulibreria.libreria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
