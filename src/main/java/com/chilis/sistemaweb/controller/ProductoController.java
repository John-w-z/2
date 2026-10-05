package com.chilis.sistemaweb.controller;

import com.chilis.sistemaweb.entity.Producto;
import com.chilis.sistemaweb.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
@lombok.RequiredArgsConstructor 
public class ProductoController {

    private final ProductoRepository productoRepository; 

    // 1. OBTENER TODOS LOS PRODUCTOS (Para mostrar la carta en la web)
    @GetMapping
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    // 2. CREAR UN NUEVO PRODUCTO (Para agregar un plato nuevo)
    @PostMapping
    public Producto guardarProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }
}