package com.tulibreria.libreria.service;

import com.tulibreria.libreria.entity.Bodega;
import com.tulibreria.libreria.repository.BodegaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BodegaService {

    private final BodegaRepository bodegaRepository;

    public BodegaService(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    public List<Bodega> findAll() {
        return bodegaRepository.findAll();
    }

    public Optional<Bodega> findById(Long id) {
        return bodegaRepository.findById(id);
    }

    public Bodega save(Bodega bodega) {
        return bodegaRepository.save(bodega);
    }

    public void deleteById(Long id) {
        bodegaRepository.deleteById(id);
    }
}
