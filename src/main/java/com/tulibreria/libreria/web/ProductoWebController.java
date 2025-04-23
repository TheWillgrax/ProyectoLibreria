package com.tulibreria.libreria.web;

import com.tulibreria.libreria.entity.Producto;
import com.tulibreria.libreria.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductoWebController {

    private final ProductoService productoService;

    public ProductoWebController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // 1. Mostrar lista de productos con layout
    @GetMapping("/productos")
    public String mostrarProductos(Model model) {
        model.addAttribute("productos", productoService.findAll());
        model.addAttribute("title", "Gestión de Productos"); // Título dinámico
        model.addAttribute("content", "productos"); // Carga productos.html en el layout
        return "layout";  // Siempre regresa layout.html
    }

    // 2. Mostrar formulario para crear nuevo producto (sin layout)
    @GetMapping("/productos/nuevo")
    public String mostrarFormularioNuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "producto_form";  // Solo el formulario, sin layout
    }

    // 3. Guardar producto (nuevo o editado)
    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.save(producto);
        return "redirect:/productos";
    }

    // 4. Mostrar formulario para editar producto (sin layout)
    @GetMapping("/productos/editar/{id}")
    public String mostrarFormularioEditarProducto(@PathVariable Long id, Model model) {
        Producto producto = productoService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de producto inválido: " + id));
        model.addAttribute("producto", producto);
        return "producto_form";  // Usa el mismo formulario, sin layout
    }

    // 5. Eliminar producto
    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.deleteById(id);
        return "redirect:/productos";
    }
}
