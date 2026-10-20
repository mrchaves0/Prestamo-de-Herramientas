package com.example.Prestamo.Service;

import com.example.Prestamo.Dto.PrestamoRequest;
import com.example.Prestamo.Model.Herramienta;
import com.example.Prestamo.Model.Prestamo;
import com.example.Prestamo.Repository.HerramientaRepository;
import com.example.Prestamo.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrestamoService {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Transactional
    public Prestamo registrarPrestamo(PrestamoRequest request) {


        Herramienta herramienta = herramientaRepository.findById(request.getHerramientaId())
                .orElseThrow(() -> new RuntimeException("Error: La herramienta solicitada no existe."));


        if (request.getCantidad() <= 0) {
            throw new RuntimeException("Error: La cantidad a prestar debe ser mayor a cero.");
        }
        if (request.getCantidad() > herramienta.getCantidad()) {
            throw new RuntimeException("Error: No hay suficientes unidades. Disponibles: " + herramienta.getCantidad());
        }


        herramienta.setCantidad(herramienta.getCantidad() - request.getCantidad());
        herramientaRepository.save(herramienta);


        Prestamo prestamo = new Prestamo();
        prestamo.setResponsable(request.getResponsable());
        prestamo.setCantidad(request.getCantidad());
        prestamo.setFechaPrestamo(LocalDate.now());
        prestamo.setHerramienta(herramienta);

        return prestamoRepository.save(prestamo);
    }

    public List<Prestamo> obtenerTodos() {
        return prestamoRepository.findAll();
    }

    public List<Prestamo> obtenerPorHerramienta(Long herramientaId) {
        return prestamoRepository.findByHerramientaId(herramientaId);
    }
}