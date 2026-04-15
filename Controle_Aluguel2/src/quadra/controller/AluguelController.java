package quadra.controller;

import quadra.model.ModelAluguel;
import quadra.model.ModelCliente;
import quadra.model.ModelHorario;
import quadra.repository.AluguelRepository;

import java.util.List;


public class AluguelController {

    private final AluguelRepository repository;

    public AluguelController(AluguelRepository repository) {
        this.repository = repository;
    }


    public ModelAluguel registrar(ModelCliente cliente, ModelHorario horario, String data) {
        if (!horario.isDisponivel()) {
            throw new IllegalStateException(
                    "RN03 - O horário '" + horario.getDescricao() + "' já está ocupado.");
        }
        horario.ocupar();
        ModelAluguel aluguel = new ModelAluguel(cliente, horario, data);
        repository.salvar(aluguel);
        return aluguel;
    }

    public List<ModelAluguel> consultarPorData(String data) {
        return repository.buscarPorData(data);
    }

    public double calcularTotalClientePorData(ModelCliente cliente, String data) {
        return repository.buscarPorClienteEData(cliente, data)
                .stream()
                .mapToDouble(ModelAluguel::getValor)
                .sum();
    }

    public List<ModelAluguel> listarTodos() {
        return repository.buscarTodos();
    }
}