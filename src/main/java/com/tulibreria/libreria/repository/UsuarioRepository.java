package com.tulibreria.libreria.repository;

import com.tulibreria.libreria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
