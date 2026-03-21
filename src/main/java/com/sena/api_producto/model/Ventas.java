package com.sena.api_producto.model;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDateTime fecha;

    @NotNull(message = "El total es obligatorio")
    @PositiveOrZero(message = "El total no puede ser negativo")
    private Double total;

    @NotBlank(message = "El método de pago es obligatorio")
    @Size(max = 50)
    private String metodoPago; // Ejemplo: "Efectivo", "Tarjeta", "Transferencia"

    @Column(length = 500)
    private String observaciones;

    // Constructor vacío
    public Ventas() {
        this.fecha = LocalDateTime.now(); // Asigna la fecha actual por defecto
    }

    // Constructor con parámetros
    public Ventas(Double total, String metodoPago, String observaciones) {
        this.fecha = LocalDateTime.now();
        this.total = total;
        this.metodoPago = metodoPago;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
    public Double getTotal() { return total; }
    public void setTotal(Double total) { this.total = total; }
    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }
}