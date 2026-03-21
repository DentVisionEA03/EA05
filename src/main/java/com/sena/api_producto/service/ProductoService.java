package com.sena.api_producto.service;

import com.sena.api_producto.exception.RecursoNoEncontrado;
import com.sena.api_producto.model.Producto;
import com.sena.api_producto.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository repo;

    public ProductoService(ProductoRepository repo) {
        this.repo = repo;
    }

    public List<Producto> listarTodos() {
        return repo.findAll();
    }

    public Producto buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Producto no encontrado con id: " + id));
    }

    public Producto guardar(Producto p) {
        return repo.save(p);
    }

    public Producto actualizar(Long id, Producto datos) {
        Producto p = buscarPorId(id);
        p.setNombre(datos.getNombre());
        p.setPrecio(datos.getPrecio());
        p.setDescripcion(datos.getDescripcion());
        return repo.save(p);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontrado("No se puede eliminar, id no existe: " + id);
        }
        repo.deleteById(id);
    }
}