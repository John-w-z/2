package com.chilis.sistemaweb.repository;

import com.chilis.sistemaweb.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    
    // Esto te permitirá buscar platos que estén activos en la carta
    List<Producto> findByActivoTrue();
}