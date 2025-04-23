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

    // 1. Listar proveedores con layout
    @GetMapping("/proveedores")
    public String mostrarProveedores(Model model) {
        model.addAttribute("proveedores", proveedorService.findAll());
        model.addAttribute("title", "Gestión de Proveedores"); // Título dinámico
        model.addAttribute("content", "proveedores");          // Carga proveedores.html dentro del layout
        return "layout";                                       // Usa layout.html como base
    }

    // 2. Mostrar formulario para crear nuevo proveedor (sin layout)
    @GetMapping("/proveedores/nuevo")
    public String mostrarFormularioNuevoProveedor(Model model) {
        model.addAttribute("proveedor", new Proveedor());
        return "proveedor_form";  // Solo carga el formulario directamente
    }

    // 3. Guardar proveedor (nuevo o editado)
    @PostMapping("/proveedores/guardar")
    public String guardarProveedor(@ModelAttribute Proveedor proveedor) {
        proveedorService.save(proveedor);
        return "redirect:/proveedores";
    }

    // 4. Mostrar formulario para editar proveedor (sin layout)
    @GetMapping("/proveedores/editar/{id}")
    public String mostrarFormularioEditarProveedor(@PathVariable Long id, Model model) {
        Proveedor proveedor = proveedorService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de proveedor inválido: " + id));
        model.addAttribute("proveedor", proveedor);
        return "proveedor_form";  // Usa el mismo formulario para editar, sin layout
    }

    // 5. Eliminar proveedor
    @GetMapping("/proveedores/eliminar/{id}")
    public String eliminarProveedor(@PathVariable Long id) {
        proveedorService.deleteById(id);
        return "redirect:/proveedores";
    }
}
