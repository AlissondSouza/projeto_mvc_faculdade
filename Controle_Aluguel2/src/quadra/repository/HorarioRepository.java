package quadra.repository;

import quadra.model.ModelHorario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class HorarioRepository {

    private final List<ModelHorario> horarios = new ArrayList<>();

    public void salvar(ModelHorario horario) {
        horarios.add(horario);
    }

    public List<ModelHorario> buscarTodos() {
        return new ArrayList<>(horarios);
    }

    public List<ModelHorario> buscarDisponiveis() {
        return horarios.stream()
                .filter(ModelHorario::isDisponivel)
                .collect(Collectors.toList());
    }

    public Optional<ModelHorario> buscarPorId(int id) {
        return horarios.stream()
                .filter(h -> h.getId() == id)
                .findFirst();
    }
}