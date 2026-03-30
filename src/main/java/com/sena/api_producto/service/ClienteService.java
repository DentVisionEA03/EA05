package com.sena.api_producto.service;

import com.sena.api_producto.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    public List<Cliente> listarTodos() {
        return new ArrayList<>();
    }

    public Cliente buscarPorId(Long id) {
        return new Cliente();
    }

    public Cliente guardar(Cliente cliente) {
        return cliente;
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        return cliente;
    }

    public void eliminar(Long id) {
    }
}