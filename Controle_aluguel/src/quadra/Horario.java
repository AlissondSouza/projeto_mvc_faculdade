package quadra;

public class Horario {

    private static int contadorId = 1;

    private int id;
    private String descricao;
    private double valorPorHora;
    private boolean disponivel;

    public Horario(String descricao, double valorPorHora) {
        if (valorPorHora <= 0) {
            throw new IllegalArgumentException("RN02 - O valor do horário não pode ser negativo ou zero.");
        }
        this.id = contadorId++;
        this.descricao = descricao;
        this.valorPorHora = valorPorHora;
        this.disponivel = true;
    }

    public int getId() { return id; }
    public String getDescricao() { return descricao; }
    public double getValorPorHora() { return valorPorHora; }
    public boolean isDisponivel() { return disponivel; }

    public void ocupar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return String.format("Horario{id=%d, descricao='%s', valor=R$%.2f, disponivel=%s}",
                id, descricao, valorPorHora, disponivel ? "Sim" : "Não");
    }
}