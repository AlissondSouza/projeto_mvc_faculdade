package quadra;

import quadra.controller.AluguelController;
import quadra.controller.ClienteController;
import quadra.controller.HorarioController;
import quadra.model.ModelAluguel;
import quadra.model.ModelCliente;
import quadra.model.ModelHorario;
import quadra.repository.AluguelRepository;
import quadra.repository.ClienteRepository;
import quadra.repository.HorarioRepository;
import quadra.view.SistemaView;

import java.util.List;

public class Main {

    public static void main(String[] args) {


        SistemaView view = new SistemaView();

        ClienteRepository  clienteRepo  = new ClienteRepository();
        HorarioRepository  horarioRepo  = new HorarioRepository();
        AluguelRepository  aluguelRepo  = new AluguelRepository();

        ClienteController  clienteCtrl  = new ClienteController(clienteRepo);
        HorarioController  horarioCtrl  = new HorarioController(horarioRepo);
        AluguelController  aluguelCtrl  = new AluguelController(aluguelRepo);

        view.exibirTitulo();

        view.exibirSeparador("Cadastro de Clientes");
        ModelCliente joao  = clienteCtrl.cadastrar("João Silva",   "(11) 99999-0001");
        view.exibirClienteCadastrado(joao);
        ModelCliente maria = clienteCtrl.cadastrar("Maria Souza",  "(11) 99999-0002");
        view.exibirClienteCadastrado(maria);
        ModelCliente pedro = clienteCtrl.cadastrar("Pedro Alves",  "(11) 99999-0003");
        view.exibirClienteCadastrado(pedro);


        view.exibirSeparador("Teste RN01 - Nome vazio");
        try {
            clienteCtrl.cadastrar("", "(11) 00000-0000");
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirSeparador("Cadastro de Horários");
        ModelHorario h1 = horarioCtrl.cadastrar("08:00 - 09:00", 80.00);
        view.exibirHorarioCadastrado(h1);
        ModelHorario h2 = horarioCtrl.cadastrar("09:00 - 10:00", 80.00);
        view.exibirHorarioCadastrado(h2);
        ModelHorario h3 = horarioCtrl.cadastrar("19:00 - 20:00", 120.00);
        view.exibirHorarioCadastrado(h3);
        ModelHorario h4 = horarioCtrl.cadastrar("20:00 - 21:00", 120.00);
        view.exibirHorarioCadastrado(h4);


        view.exibirSeparador("Teste RN02 - Valor negativo");
        try {
            horarioCtrl.cadastrar("22:00 - 23:00", -50.00);
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirSeparador("Registrar Aluguéis (14/04/2026)");
        ModelAluguel a1 = aluguelCtrl.registrar(joao,  h1, "14/04/2026");
        view.exibirAluguelRegistrado(a1);
        ModelAluguel a2 = aluguelCtrl.registrar(joao,  h2, "14/04/2026");
        view.exibirAluguelRegistrado(a2);
        ModelAluguel a3 = aluguelCtrl.registrar(maria, h3, "14/04/2026");
        view.exibirAluguelRegistrado(a3);


        view.exibirSeparador("Teste RN03 - Horário já ocupado");
        try {
            aluguelCtrl.registrar(pedro, h1, "14/04/2026");
        } catch (IllegalStateException e) {
            view.exibirErro(e.getMessage());
        }

        view.exibirHorariosDisponiveis(horarioCtrl.listarDisponiveis());

        List<ModelAluguel> alugueisDia = aluguelCtrl.consultarPorData("14/04/2026");
        view.exibirAlugueisPorData("14/04/2026", alugueisDia);

        view.exibirSeparador("Total por Cliente em 14/04/2026 (RN04)");
        double totalJoao  = aluguelCtrl.calcularTotalClientePorData(joao,  "14/04/2026");
        double totalMaria = aluguelCtrl.calcularTotalClientePorData(maria, "14/04/2026");
        view.exibirTotalCliente(joao,  "14/04/2026", totalJoao);
        view.exibirTotalCliente(maria, "14/04/2026", totalMaria);

        view.exibirSeparador("Registrar Aluguel em 15/04/2026");
        ModelAluguel a4 = aluguelCtrl.registrar(pedro, h4, "15/04/2026");
        view.exibirAluguelRegistrado(a4);

        view.exibirAlugueisPorData("15/04/2026", aluguelCtrl.consultarPorData("15/04/2026"));

        view.exibirRodape();
    }
}