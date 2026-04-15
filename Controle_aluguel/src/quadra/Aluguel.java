package quadra;

public class Aluguel {

    private static int contadorId = 1;

    private int id;
    private quadra.Cliente cliente;
    private quadra.Horario horario;
    private String data; // formato dd/MM/yyyy
    private double valor;

    public Aluguel(quadra.Cliente cliente, quadra.Horario horario, String data) {
        this.id = contadorId++;
        this.cliente = cliente;
        this.horario = horario;
        this.data = data;
        this.valor = horario.getValorPorHora();
    }

    public int getId() { return id; }
    public quadra.Cliente getCliente() { return cliente; }
    public quadra.Horario getHorario() { return horario; }
    public String getData() { return data; }
    public double getValor() { return valor; }

    @Override
    public String toString() {
        return String.format("Aluguel{id=%d, cliente='%s', horario='%s', data='%s', valor=R$%.2f}",
                id, cliente.getNome(), horario.getDescricao(), data, valor);
    }
}