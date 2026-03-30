package com.sena.api_producto.service;

import com.sena.api_producto.exception.RecursoNoEncontrado;
import com.sena.api_producto.model.Ventas;
import org.springframework.stereotype.Service;
import com.sena.api_producto.repository.VentasRepository;
import java.util.List;






@Service
public class VentasService {

    private final VentasRepository repo;

    // Inyección por constructor
    public VentasService(VentasRepository repo) {
        this.repo = repo;
    }

    public List<Ventas> listarTodas() {
        return repo.findAll();
    }

    public Ventas buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Venta no encontrada con id: " + id));
    }

    public Ventas guardar(Ventas v) {
        // Lógica de negocio simple: Si el total es 0, podrías lanzar una advertencia
        if (v.getTotal() == null || v.getTotal() < 0) {
            throw new IllegalArgumentException("El total de la venta no es válido");
        }
        return repo.save(v);
    }

    public Ventas actualizar(Long id, Ventas datos) {
        Ventas v = buscarPorId(id);

        v.setTotal(datos.getTotal());
        v.setMetodoPago(datos.getMetodoPago());
        v.setObservaciones(datos.getObservaciones());
        // Nota: Generalmente la fecha de una venta no se actualiza,
        // pero puedes hacerlo si es necesario:
        // v.setFecha(datos.getFecha());

        return repo.save(v);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontrado("No se puede eliminar, la venta no existe con id: " + id);
        }
        repo.deleteById(id);
    }

    // Método adicional para filtrar por método de pago
    public List<Ventas> listarPorMetodoPago(String metodo) {
        return repo.findByMetodoPagoIgnoreCase(metodo);
    }
}