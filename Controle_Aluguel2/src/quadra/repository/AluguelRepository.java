package quadra.repository;

import quadra.model.ModelAluguel;
import quadra.model.ModelCliente;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AluguelRepository {

    private final List<ModelAluguel> alugueis = new ArrayList<>();

    public void salvar(ModelAluguel aluguel) {
        alugueis.add(aluguel);
    }

    public List<ModelAluguel> buscarTodos() {
        return new ArrayList<>(alugueis);
    }

    public List<ModelAluguel> buscarPorData(String data) {
        return alugueis.stream()
                .filter(a -> a.getData().equals(data))
                .collect(Collectors.toList());
    }

    public List<ModelAluguel> buscarPorClienteEData(ModelCliente cliente, String data) {
        return alugueis.stream()
                .filter(a -> a.getCliente().getId() == cliente.getId()
                        && a.getData().equals(data))
                .collect(Collectors.toList());
    }
}