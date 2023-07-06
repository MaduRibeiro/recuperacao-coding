public class Placar {
    private String mensagem;
    private boolean jogoGanho;

    public Placar(String mensagem, boolean jogoGanho) {
        this.mensagem = mensagem;
        this.jogoGanho = jogoGanho;
    }

    public String getMensagem() {
        return mensagem;
    }

    public boolean isJogoGanho() {
        return jogoGanho;
    }
}
