package com.tulibreria.libreria.controller;

import com.tulibreria.libreria.entity.Inventario;
import com.tulibreria.libreria.service.InventarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventarios")
public class InventarioController {

    private final InventarioService inventarioService;

    public InventarioController(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }

    @GetMapping
    public List<Inventario> getAllInventarios() {
        return inventarioService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id) {
        return inventarioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Inventario createInventario(@RequestBody Inventario inventario) {
        return inventarioService.save(inventario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inventario> updateInventario(@PathVariable Long id, @RequestBody Inventario inventarioDetails) {
        return inventarioService.findById(id)
                .map(inventario -> {
                    inventario.setProducto(inventarioDetails.getProducto());
                    inventario.setBodega(inventarioDetails.getBodega());
                    inventario.setCantidad(inventarioDetails.getCantidad());
                    return ResponseEntity.ok(inventarioService.save(inventario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable Long id) {
        if (inventarioService.findById(id).isPresent()) {
            inventarioService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
