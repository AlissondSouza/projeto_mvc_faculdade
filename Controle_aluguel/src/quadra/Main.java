package quadra;

import java.util.List;
public class Main {

    public static void main(String[] args) {

        System.out.println("=================================================");
        System.out.println("  SISTEMA DE ALUGUEL DE QUADRA ESPORTIVA - P1   ");
        System.out.println("=================================================\n");

        quadra.SistemaAluguel sistema = new quadra.SistemaAluguel();

        System.out.println("--- Cadastro de Clientes ---");
        quadra.Cliente joao  = sistema.cadastrarCliente("João Silva",    "(11) 99999-0001");
        quadra.Cliente maria = sistema.cadastrarCliente("Maria Souza",   "(11) 99999-0002");
        quadra.Cliente pedro = sistema.cadastrarCliente("Pedro Alves",   "(11) 99999-0003");

        System.out.println("\n--- Teste RN01: nome vazio ---");
        try {
            sistema.cadastrarCliente("", "(11) 00000-0000");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Cadastro de Horários ---");
        quadra.Horario h1 = sistema.cadastrarHorario("08:00 - 09:00", 80.00);
        quadra.Horario h2 = sistema.cadastrarHorario("09:00 - 10:00", 80.00);
        quadra.Horario h3 = sistema.cadastrarHorario("19:00 - 20:00", 120.00);
        quadra.Horario h4 = sistema.cadastrarHorario("20:00 - 21:00", 120.00);

        System.out.println("\n--- Teste RN02: valor negativo ---");
        try {
            sistema.cadastrarHorario("22:00 - 23:00", -50.00);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Registrar Aluguéis (14/04/2026) ---");
        sistema.registrarAluguel(joao,  h1, "14/04/2026");
        sistema.registrarAluguel(joao,  h2, "14/04/2026");
        sistema.registrarAluguel(maria, h3, "14/04/2026");

        System.out.println("\n--- Teste RN03: horário já ocupado ---");
        try {
            sistema.registrarAluguel(pedro, h1, "14/04/2026");
        } catch (IllegalStateException e) {
            System.out.println("❌ Erro esperado: " + e.getMessage());
        }

        System.out.println("\n--- Horários Disponíveis ---");
        List<quadra.Horario> disponiveis = sistema.listarHorariosDisponiveis();
        if (disponiveis.isEmpty()) {
            System.out.println("Nenhum horário disponível.");
        } else {
            disponiveis.forEach(System.out::println);
        }

        System.out.println("\n--- Aluguéis em 14/04/2026 (RN05) ---");
        List<quadra.Aluguel> alugueisDoDia = sistema.consultarAlugueisPorData("14/04/2026");
        alugueisDoDia.forEach(System.out::println);

        System.out.println("\n--- Total por Cliente em 14/04/2026 (RN04) ---");
        double totalJoao  = sistema.calcularTotalClientePorData(joao,  "14/04/2026");
        double totalMaria = sistema.calcularTotalClientePorData(maria, "14/04/2026");
        System.out.printf("💰 João  : R$ %.2f%n", totalJoao);
        System.out.printf("💰 Maria : R$ %.2f%n", totalMaria);

        System.out.println("\n--- Registrar Aluguel em 15/04/2026 ---");
        sistema.registrarAluguel(pedro, h4, "15/04/2026");

        System.out.println("\n--- Aluguéis em 15/04/2026 ---");
        sistema.consultarAlugueisPorData("15/04/2026").forEach(System.out::println);

        System.out.println("\n=================================================");
        System.out.println("  FIM DA SIMULAÇÃO - PROJETO 1                  ");
        System.out.println("=================================================");
    }
}