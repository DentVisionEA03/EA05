package com.sena.api_producto.service;



import com.sena.api_producto.exception.RecursoNoEncontrado;
import com.sena.api_producto.model.Cliente;
import com.sena.api_producto.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository repo;

    // Inyección por constructor
    public ClienteService(ClienteRepository repo) {
        this.repo = repo;
    }

    public List<Cliente> listarTodos() {
        return repo.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Cliente no encontrado con id: " + id));
    }

    public Cliente guardar(Cliente cliente) {
        // Aquí podrías agregar una validación extra:
        // if(repo.existsByEmail(cliente.getEmail())) throw new RuntimeException("Email ya registrado");
        return repo.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente datos) {
        Cliente c = buscarPorId(id);

        c.setNombre(datos.getNombre());
        c.setApellido(datos.getApellido());
        c.setEmail(datos.getEmail());
        c.setTelefono(datos.getTelefono());

        return repo.save(c);
    }

    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new RecursoNoEncontrado("No se puede eliminar, el cliente no existe con id: " + id);
        }
        repo.deleteById(id);
    }
}