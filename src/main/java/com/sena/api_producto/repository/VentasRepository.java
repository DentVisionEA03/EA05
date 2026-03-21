package com.sena.api_producto.repository;



import com.sena.api_producto.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Long> {

    // Buscar todas las ventas realizadas con un método de pago (ej: "Efectivo")
    List<Ventas> findByMetodoPagoIgnoreCase(String metodoPago);

    // Buscar ventas que superen un monto total específico
    List<Ventas> findByTotalGreaterThanEqual(Double total);

    // Buscar ventas realizadas entre dos fechas (útil para reportes diarios/mensuales)
    List<Ventas> findByFechaBetween(LocalDateTime inicio, LocalDateTime fin);
}