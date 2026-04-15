package quadra.controller;

import quadra.model.ModelHorario;
import quadra.repository.HorarioRepository;

import java.util.List;

public class HorarioController {

    private final HorarioRepository repository;

    public HorarioController(HorarioRepository repository) {
        this.repository = repository;
    }


    public ModelHorario cadastrar(String descricao, double valorPorHora) {
        ModelHorario horario = new ModelHorario(descricao, valorPorHora);
        repository.salvar(horario);
        return horario;
    }

    public List<ModelHorario> listarTodos() {
        return repository.buscarTodos();
    }

    public List<ModelHorario> listarDisponiveis() {
        return repository.buscarDisponiveis();
    }
}