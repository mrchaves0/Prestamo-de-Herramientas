package com.example.Prestamo.Controller;

import com.example.Prestamo.Model.Herramienta;
import com.example.Prestamo.Service.HerramientaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;
    
    @PostMapping
    public ResponseEntity<Herramienta> registrarHerramienta(@Valid @RequestBody Herramienta herramienta) {
        return ResponseEntity.ok(herramientaService.registrarHerramienta(herramienta));
    }

    @GetMapping
    public ResponseEntity<List<Herramienta>> consultarHerramientas() {
        return ResponseEntity.ok(herramientaService.obtenerTodas());
    }
}