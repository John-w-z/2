package com.chilis.sistemaweb.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "USUARIOS")
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(nullable = false)
    private Integer id_personal;

    @Column(nullable = false)
    private Integer id_rol;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(name = "password_hash", length = 80)
    private String passwordHash;

    @Column(name = "pin_hash", length = 80)
    private String pinHash;

    private boolean activo = true;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion = LocalDateTime.now();
}