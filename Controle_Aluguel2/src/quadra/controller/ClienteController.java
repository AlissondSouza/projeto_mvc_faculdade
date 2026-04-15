package quadra.controller;

import quadra.model.ModelCliente;
import quadra.repository.ClienteRepository;

import java.util.List;

public class ClienteController {

    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    public ModelCliente cadastrar(String nome, String telefone) {
        ModelCliente cliente = new ModelCliente(nome, telefone);
        repository.salvar(cliente);
        return cliente;
    }

    public List<ModelCliente> listarTodos() {
        return repository.buscarTodos();
    }
}