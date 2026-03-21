package com.sena.api_producto.exception;

public class ErrorResponse {
    private String mensaje;
    private int status;
    private String timestamp;
    public ErrorResponse(String mensaje, int status) {
        this.mensaje = mensaje;
        this.status = status;
        this.timestamp = java.time.LocalDateTime.now().toString();
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getStatus() {
        return status;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
