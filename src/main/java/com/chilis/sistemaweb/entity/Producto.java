package com.chilis.sistemaweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCTOS")
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;

    @Column(nullable = false)
    private Integer id_categoria;

    @Column(nullable = false, length = 150)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    // Cumpliendo con el "Decimal 10,2" que pidió el profesor
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    private boolean disponible = true;
    private boolean activo = true;
}