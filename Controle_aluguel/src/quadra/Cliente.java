package quadra;

public class Cliente {

    private static int contadorId = 1;

    private int id;
    private String nome;
    private String telefone;

    public Cliente(String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("RN01 - O nome do cliente não pode ser vazio.");
        }
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("RN06 - O telefone do cliente não pode ser vazio.");
        }
        this.id = contadorId++;
        this.nome = nome.trim();
        this.telefone = telefone.trim();
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getTelefone() { return telefone; }

    @Override
    public String toString() {
        return String.format("Cliente{id=%d, nome='%s', telefone='%s'}", id, nome, telefone);
    }
}