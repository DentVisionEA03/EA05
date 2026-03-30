package com.sena.api_producto.controller;

import com.sena.api_producto.model.Cita;
import com.sena.api_producto.service.CitaService;
import org.springframework.web.bind.annotation.*;

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
        return service.buscarPorId(id);
    }

    @PostMapping
    public Cita crear(@RequestBody Cita c) {
        return service.guardar(c);
    }

    @PutMapping("/{id}")
    public Cita actualizar(@PathVariable Long id, @RequestBody Cita c) {
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