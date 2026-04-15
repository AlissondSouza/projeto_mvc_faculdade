package quadra.model;

public class ModelAluguel {

    private static int contadorId = 1;

    private int id;
    private ModelCliente cliente;
    private ModelHorario horario;
    private String data;
    private double valor;

    public ModelAluguel(ModelCliente cliente, ModelHorario horario, String data) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.horario = horario;
        this.data = data;
        this.valor = horario.getValorPorHora();
    }

    public int getId() { return id; }
    public ModelCliente getCliente() { return cliente; }
    public ModelHorario getHorario() { return horario; }
    public String getData() { return data; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return String.format("Aluguel{id=%d, cliente='%s', horario='%s', data='%s', valor=R$%.2f}",
                id, cliente.getNome(), horario.getDescricao(), data, valor);
    }
}