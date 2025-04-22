package com.tulibreria.libreria.controller;

import com.tulibreria.libreria.entity.Proveedor;
import com.tulibreria.libreria.service.ProveedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {

    private final ProveedorService proveedorService;

    public ProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<Proveedor> getAllProveedores() {
        return proveedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) {
        return proveedorService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedor createProveedor(@RequestBody Proveedor proveedor) {
        return proveedorService.save(proveedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable Long id, @RequestBody Proveedor proveedorDetails) {
        return proveedorService.findById(id)
                .map(proveedor -> {
                    proveedor.setNombre(proveedorDetails.getNombre());
                    proveedor.setContacto(proveedorDetails.getContacto());
                    proveedor.setTelefono(proveedorDetails.getTelefono());
                    proveedor.setEmail(proveedorDetails.getEmail());
                    return ResponseEntity.ok(proveedorService.save(proveedor));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        if (proveedorService.findById(id).isPresent()) {
            proveedorService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
