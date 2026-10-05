package com.chilis.sistemaweb.repository;

import com.chilis.sistemaweb.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Esto buscará automáticamente en MySQL: SELECT * FROM usuarios WHERE usuario = ?
    Optional<Usuario> findByUsuario(String usuario);
}
