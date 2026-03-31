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

    // Listar todas las citas
    public List<Cita> listarTodas() {
        return repo.findAll();
    }

    // Buscar cita por ID
    public Cita buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Cita no encontrada"));
    }

    // Guardar nueva cita
    public Cita guardar(Cita c) {
        if (c.getPaciente() == null || c.getPaciente().isEmpty()) {
            throw new IllegalArgumentException("El paciente es obligatorio");
        }
        return repo.save(c);
    }

    // Actualizar cita existente
    public Cita actualizar(Long id, Cita datos) {
        Cita c = buscarPorId(id); // ya lanza 404 si no existe

        c.setPaciente(datos.getPaciente());
        c.setOdontologo(datos.getOdontologo());
        c.setFecha(datos.getFecha());
        c.setHora(datos.getHora());
        c.setEstado(datos.getEstado());

        return repo.save(c);
    }

    // Eliminar cita
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontrado("ID inexistente");
        }
        repo.deleteById(id);
    }

    // Buscar citas por nombre de paciente
    public List<Cita> listarPorPaciente(String paciente) {
        return repo.findByPacienteIgnoreCase(paciente);
    }
}