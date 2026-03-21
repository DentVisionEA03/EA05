package com.sena.api_producto.controller;



import com.sena.api_producto.model.Ventas;
import com.sena.api_producto.service.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    @Autowired
    private VentasService ventaService;

    // Listar todas las ventas registradas
    @GetMapping
    public List<Ventas> listar() {
        return ventaService.listarTodas();
    }

    // Buscar una venta específica por su ID
    @GetMapping("/{id}")
    public Ventas buscarPorId(@PathVariable Long id) {
        return ventaService.buscarPorId(id);
    }

    // Buscar ventas por método de pago (ej: /api/ventas/metodo/Efectivo)
    @GetMapping("/metodo/{tipo}")
    public List<Ventas> listarPorMetodo(@PathVariable String tipo) {
        return ventaService.listarPorMetodoPago(tipo);
    }

    // Registrar una nueva venta
    @PostMapping
    public Ventas guardar(@RequestBody Ventas venta) {
        return ventaService.guardar(venta);
    }

    // Actualizar datos de una venta existente
    @PutMapping("/{id}")
    public Ventas actualizar(@PathVariable Long id, @RequestBody Ventas venta) {
        return ventaService.actualizar(id, venta);
    }

    // Eliminar un registro de venta
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        ventaService.eliminar(id);
    }
}