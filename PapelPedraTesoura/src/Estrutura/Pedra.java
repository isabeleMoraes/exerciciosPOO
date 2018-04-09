package Estrutura;

import Estrutura.Coisa;

public class Pedra extends Coisa{
    private static String IDENTIDADE = "Pedra";


    public Pedra() {
        setFraqueza("Papel");
        setVantagem("Tesoura");
    }

    @Override
    public String jogar() {
        return IDENTIDADE;
    }
}
