package Estrutura;

import Estrutura.Coisa;

public class Papel extends Coisa{
    private static String IDENTIDADE = "Papel";

    public Papel(){
        setFraqueza("Tesoura");
        setVantagem("Pedra");
    }

    @Override
    public String jogar() {
        return IDENTIDADE;
    }
}
