package quadra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SistemaAluguel {

    private List<quadra.Cliente> clientes = new ArrayList<>();
    private List<quadra.Horario> horarios = new ArrayList<>();
    private List<quadra.Aluguel> alugueis = new ArrayList<>();

    public quadra.Cliente cadastrarCliente(String nome, String telefone) {
        quadra.Cliente c = new quadra.Cliente(nome, telefone);
        System.out.println("✅ Cliente cadastrado: " + c);
        return c;
    }

    public List<quadra.Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public quadra.Horario cadastrarHorario(String descricao, double valorPorHora) {
        quadra.Horario h = new quadra.Horario(descricao, valorPorHora);
        horarios.add(h);
        System.out.println("✅ Horário cadastrado: " + h);
        return h;
    }

    public List<quadra.Horario> listarHorariosDisponiveis() {
        return horarios.stream()
                .filter(quadra.Horario::isDisponivel)
                .collect(Collectors.toList());
    }

    public List<quadra.Horario> listarTodosHorarios() {
        return new ArrayList<>(horarios);
    }

    public quadra.Aluguel registrarAluguel(quadra.Cliente cliente, quadra.Horario horario, String data) {
        // RN03 - Verificar disponibilidade
        if (!horario.isDisponivel()) {
            throw new IllegalStateException(
                    "RN03 - O horário '" + horario.getDescricao() + "' já está ocupado.");
        }

        horario.ocupar();
        quadra.Aluguel aluguel = new quadra.Aluguel(cliente, horario, data);
        alugueis.add(aluguel);
        System.out.println("✅ Aluguel registrado: " + aluguel);
        return aluguel;
    }

    public List<quadra.Aluguel> consultarAlugueisPorData(String data) {
        return alugueis.stream()
                .filter(a -> a.getData().equals(data))
                .collect(Collectors.toList());
    }

    public double calcularTotalClientePorData(quadra.Cliente cliente, String data) {
        return alugueis.stream()
                .filter(a -> a.getCliente().getId() == cliente.getId()
                        && a.getData().equals(data))
                .mapToDouble(quadra.Aluguel::getValor)
                .sum();
    }
}