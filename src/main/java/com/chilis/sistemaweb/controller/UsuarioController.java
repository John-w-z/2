package com.chilis.sistemaweb.controller;

import com.chilis.sistemaweb.entity.Usuario;
import com.chilis.sistemaweb.repository.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
@lombok.RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario loginRequest) {
        // 1. Buscar al usuario en la base de datos por su nombre
        Optional<Usuario> oUsuario = usuarioRepository.findByUsuario(loginRequest.getUsuario());

        if (oUsuario.isPresent()) {
            Usuario usuario = oUsuario.get();
            
            // 2. Verificar si está activo
            if (!usuario.isActivo()) {
                return ResponseEntity.badRequest().body("El usuario se encuentra inactivo.");
            }

            // 3. Validar la contraseña (Por ahora texto plano para pruebas sencillas)
            if (usuario.getPasswordHash().equals(loginRequest.getPasswordHash())) {
                return ResponseEntity.ok(usuario); // Login exitoso: Devuelve los datos del usuario
            } else {
                return ResponseEntity.badRequest().body("Contraseña incorrecta.");
            }
        }

        return ResponseEntity.badRequest().body("El usuario no existe.");
    }
}