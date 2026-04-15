package quadra.view;

import quadra.model.ModelAluguel;
import quadra.model.ModelCliente;
import quadra.model.ModelHorario;

import java.util.List;

public class SistemaView {

    public void exibirTitulo() {
        System.out.println("=================================================");
        System.out.println("  SISTEMA DE ALUGUEL DE QUADRA ESPORTIVA - P2   ");
        System.out.println("         (Padrão MVC)                            ");
        System.out.println("=================================================\n");
    }

    public void exibirClienteCadastrado(ModelCliente cliente) {
        System.out.println("✅ Cliente cadastrado: " + cliente);
    }

    public void exibirHorarioCadastrado(ModelHorario horario) {
        System.out.println("✅ Horário cadastrado: " + horario);
    }

    public void exibirAluguelRegistrado(ModelAluguel aluguel) {
        System.out.println("✅ Aluguel registrado: " + aluguel);
    }

    public void exibirErro(String mensagem) {
        System.out.println("❌ Erro: " + mensagem);
    }

    public void exibirSeparador(String titulo) {
        System.out.println("\n--- " + titulo + " ---");
    }

    public void exibirHorariosDisponiveis(List<ModelHorario> horarios) {
        exibirSeparador("Horários Disponíveis");
        if (horarios.isEmpty()) {
            System.out.println("Nenhum horário disponível no momento.");
        } else {
            horarios.forEach(System.out::println);
        }
    }

    public void exibirAlugueisPorData(String data, List<ModelAluguel> alugueis) {
        exibirSeparador("Aluguéis em " + data + " (RN05)");
        if (alugueis.isEmpty()) {
            System.out.println("Nenhum aluguel encontrado para esta data.");
        } else {
            alugueis.forEach(System.out::println);
        }
    }

    public void exibirTotalCliente(ModelCliente cliente, String data, double total) {
        System.out.printf("💰 %-15s em %s: R$ %.2f%n", cliente.getNome(), data, total);
    }

    public void exibirRodape() {
        System.out.println("\n=================================================");
        System.out.println("  FIM DA SIMULAÇÃO - PROJETO 2 (MVC)            ");
        System.out.println("=================================================");
    }
}