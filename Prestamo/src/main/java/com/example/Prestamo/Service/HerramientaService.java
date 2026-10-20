package com.example.Prestamo.Service;

import com.example.Prestamo.Model.Herramienta;
import com.example.Prestamo.Repository.HerramientaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    public Herramienta registrarHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    public List<Herramienta> obtenerTodas() {
        return herramientaRepository.findAll();
    }
}