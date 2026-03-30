package com.sena.api_producto.service;

import com.sena.api_producto.exception.RecursoNoEncontrado;
import com.sena.api_producto.model.Cita;
import com.sena.api_producto.repository.CitaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository repo;

    public CitaService(CitaRepository repo) {
        this.repo = repo;
    }

    public List<Cita> listarTodas() {
        return repo.findAll();
    }

    public Cita buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Cita no encontrada con id: " + id));
    }

    public Cita guardar(Cita c) {
        if (c.getPaciente() == null || c.getPaciente().isEmpty()) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }
        return repo.save(c);
    }

    public Cita actualizar(Long id, Cita datos) {
        Cita c = buscarPorId(id);

        c.setPaciente(datos.getPaciente());
        c.setOdontologo(datos.getOdontologo());
        c.setFecha(datos.getFecha());
        c.setHora(datos.getHora());
        c.setEstado(datos.getEstado());

        return repo.save(c);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontrado("No existe la cita con id: " + id);
        }
        repo.deleteById(id);
    }

    public List<Cita> listarPorPaciente(String paciente) {
        return repo.findByPacienteIgnoreCase(paciente);
    }
}