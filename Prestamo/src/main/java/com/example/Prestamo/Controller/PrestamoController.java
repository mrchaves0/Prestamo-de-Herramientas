package com.example.Prestamo.Controller;

import com.example.Prestamo.Dto.PrestamoRequest;
import com.example.Prestamo.Model.Prestamo;
import com.example.Prestamo.Service.PrestamoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController {

    @Autowired
    private PrestamoService prestamoService;


    @PostMapping
    public ResponseEntity<?> registrarPrestamo(@Valid @RequestBody PrestamoRequest request) {
        try {

            Prestamo prestamo = prestamoService.registrarPrestamo(request);
            return ResponseEntity.ok(prestamo);
        } catch (RuntimeException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<Prestamo>> consultarPrestamos() {
        return ResponseEntity.ok(prestamoService.obtenerTodos());
    }

    @GetMapping("/herramienta/{id}")
    public ResponseEntity<List<Prestamo>> consultarPrestamosPorHerramienta(@PathVariable Long id) {
        return ResponseEntity.ok(prestamoService.obtenerPorHerramienta(id));
    }
}