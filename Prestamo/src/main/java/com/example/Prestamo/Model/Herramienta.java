package com.example.Prestamo.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "herramientas")
@Getter
@Setter
@NoArgsConstructor
public class Herramienta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "La categoría no puede estar vacía")
    private String categoria;

    @NotNull
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidad;

    public Herramienta(String nombre, String categoria, Integer cantidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
    }
}

