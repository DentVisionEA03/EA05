package com.sena.api_producto.dto;

import jakarta.validation.constraints.*;

public class CitaDTO {

    @NotBlank(message = "El paciente es obligatorio")
    @Size(min = 3, max = 50)
    private String paciente;

    @NotBlank(message = "El odontólogo es obligatorio")
    private String odontologo;

    @NotNull(message = "La fecha es obligatoria")
    private String fecha;

    @NotNull(message = "La hora es obligatoria")
    private String hora;

    @NotBlank(message = "El estado es obligatorio")
    private String estado;

    // getters y setters


    public String getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(String odontologo) {
        this.odontologo = odontologo;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}