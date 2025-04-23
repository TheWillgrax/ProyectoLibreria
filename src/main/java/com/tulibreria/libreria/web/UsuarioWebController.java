package com.tulibreria.libreria.web;

import com.tulibreria.libreria.entity.Usuario;
import com.tulibreria.libreria.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UsuarioWebController {

    private final UsuarioService usuarioService;

    public UsuarioWebController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // 1. Listar usuarios con layout
    @GetMapping("/usuarios")
    public String mostrarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        model.addAttribute("title", "Gestión de Usuarios"); // Título dinámico
        model.addAttribute("content", "usuarios");          // Carga usuarios.html dentro del layout
        return "layout";                                    // Usa layout.html como base
    }

    // 2. Mostrar formulario para crear nuevo usuario (sin layout)
    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario_form";  // Solo el formulario, sin layout
    }

    // 3. Guardar usuario (nuevo o editado)
    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    // 4. Mostrar formulario para editar usuario (sin layout)
    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioEditarUsuario(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID de usuario inválido: " + id));
        model.addAttribute("usuario", usuario);
        return "usuario_form";  // Usa el mismo formulario para editar, sin layout
    }

    // 5. Eliminar usuario
    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }
}
