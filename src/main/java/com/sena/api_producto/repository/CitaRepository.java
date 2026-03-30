package com.sena.api_producto.repository;

import com.sena.api_producto.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CitaRepository extends JpaRepository<Cita, Long> {

    List<Cita> findByPacienteIgnoreCase(String paciente);

    List<Cita> findByFecha(LocalDate fecha);
}