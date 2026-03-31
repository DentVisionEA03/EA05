package com.sena.api_producto.controller;

import com.sena.api_producto.model.Cita;
import com.sena.api_producto.service.CitaService;
import com.sena.api_producto.dto.CitaDTO;
import com.sena.api_producto.model.enums.EstadoCita;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cita> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Cita obtener(@PathVariable Long id) {
        Cita cita = service.buscarPorId(id);
        if (cita == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cita no encontrada");
        }
        return cita;
    }

    @PostMapping
    public Cita crear(@Valid @RequestBody CitaDTO dto) {
        Cita c = new Cita();
        c.setPaciente(dto.getPaciente());
        c.setOdontologo(dto.getOdontologo());

        try {
            c.setFecha(LocalDate.parse(dto.getFecha()));
            c.setHora(LocalTime.parse(dto.getHora()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fecha u hora inválida");
        }

        try {
            c.setEstado(EstadoCita.valueOf(dto.getEstado().toUpperCase()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado inválido");
        }

        return service.guardar(c);
    }

    @PutMapping("/{id}")
    public Cita actualizar(@PathVariable Long id, @Valid @RequestBody CitaDTO dto) {
        Cita c = new Cita();
        c.setPaciente(dto.getPaciente());
        c.setOdontologo(dto.getOdontologo());

        try {
            c.setFecha(LocalDate.parse(dto.getFecha()));
            c.setHora(LocalTime.parse(dto.getHora()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Fecha u hora inválida");
        }

        try {
            c.setEstado(EstadoCita.valueOf(dto.getEstado().toUpperCase()));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Estado inválido");
        }

        return service.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }

    @GetMapping("/paciente/{nombre}")
    public List<Cita> porPaciente(@PathVariable String nombre) {
        return service.listarPorPaciente(nombre);
    }
}