package quadra.repository;

import quadra.model.ModelCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteRepository {

    private final List<ModelCliente> clientes = new ArrayList<>();

    public void salvar(ModelCliente cliente) {
        clientes.add(cliente);
    }

    public List<ModelCliente> buscarTodos() {
        return new ArrayList<>(clientes);
    }

    public Optional<ModelCliente> buscarPorId(int id) {
        return clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }
}