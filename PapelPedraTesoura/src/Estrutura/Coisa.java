package Estrutura;

public abstract class Coisa {
    private String fraqueza;
    private String vantagem;

    public abstract String jogar();

    public String getFraqueza() {
        return fraqueza;
    }

    public void setFraqueza(String fraqueza) {
        this.fraqueza = fraqueza;
    }

    public String getVantagem() {
        return vantagem;
    }

    public void setVantagem(String vantagem) {
        this.vantagem = vantagem;
    }
}
