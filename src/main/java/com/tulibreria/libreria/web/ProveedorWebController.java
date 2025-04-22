package com.tulibreria.libreria.web;

import com.tulibreria.libreria.entity.Proveedor;
import com.tulibreria.libreria.service.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProveedorWebController {

    private final ProveedorService proveedorService;

    public ProveedorWebController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    // 1. Listar proveedores
    @GetMapping("/proveedores")
    public String mostrarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.findAll());
        return "proveedores";  // templates/proveedores.html
    }

    // 2. Mostrar formulario para crear nuevo proveedor
    @GetMapping("/proveedores/nuevo")
    public String mostrarFormularioNuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor_form";  // templates/proveedor_form.html
    }

    // 3. Guardar proveedor (nuevo o editado)
    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    // 4. Mostrar formulario para editar proveedor
    @GetMapping("/proveedores/editar/{id}")
    public String mostrarFormularioEditarProveedor(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de proveedor inválido: " + id));
        model.addAttribute("proveedor", proveedor);
        return "proveedor_form";
    }

    // 5. Eliminar proveedor
    @GetMapping("/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.deleteById(id);
        return "redirect:/proveedores";
    }
}
