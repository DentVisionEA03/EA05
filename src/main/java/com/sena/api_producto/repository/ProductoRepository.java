package com.sena.api_producto.repository;

import com.sena.api_producto.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Busca productos por nombre ignorando mayúsculas
    List<Producto> findByNombreContainingIgnoreCase(String nombre);

    // Busca productos con precio menor al indicado
    List<Producto> findByPrecioLessThan(Double precio);
}