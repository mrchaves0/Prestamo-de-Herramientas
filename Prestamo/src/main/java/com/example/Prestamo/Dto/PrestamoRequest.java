package com.example.Prestamo.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestamoRequest {

    @NotNull(message = "El ID de la herramienta es obligatorio")
    private Long herramientaId;

    @NotBlank(message = "Debe haber un responsable")
    private String responsable;

    @NotNull
    @Min(value = 1, message = "Debe prestar al menos 1 unidad")
    private Integer cantidad;
}