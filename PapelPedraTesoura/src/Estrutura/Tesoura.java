package Estrutura;

import Estrutura.Coisa;

public class Tesoura extends Coisa{

    private static String IDENTIDADE = "Tesoura";

    public Tesoura() {
        setFraqueza("Pedra");
        setVantagem("Papel");
    }

    @Override
    public String jogar() {
        return IDENTIDADE;
    }
}