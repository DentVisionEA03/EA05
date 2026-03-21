package com.sena.api_producto.repository;
 // Asegúrate de que el paquete coincida con tu estructura

import com.sena.api_producto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Busca un cliente por su email exacto (útil para logins o validaciones)
    Optional<Cliente> findByEmail(String email);

    // Busca clientes por apellido ignorando mayúsculas/minúsculas
    List<Cliente> findByApellidoContainingIgnoreCase(String apellido);

    // Busca clientes que tengan un número de teléfono específico
    List<Cliente> findByTelefono(String telefono);

    // Verifica si ya existe un cliente con ese email antes de guardar
    boolean existsByEmail(String email);
}