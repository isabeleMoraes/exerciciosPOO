package Recursos;

import Estrutura.Coisa;
import Estrutura.Papel;
import Estrutura.Pedra;
import Estrutura.Tesoura;

import java.util.Random;

public class Jogador {
    public static int AUTOMATIVO = -2;
    public static int HUMANO = -1;

    public static int PEDRA = 0;
    public static int PAPEL = 1;
    public static int TESOURA = 2;

    private String nome;
    private int vitorias;
    private Coisa coisa;


    public Jogador(String nome) {

        this.nome = nome;
    }

    public void criarJogada(int jogada){
        if(jogada == PEDRA){
            coisa = new Pedra();
        }else{
            if(jogada == PAPEL){
                coisa = new Papel();
            }else{
                if(jogada == TESOURA){
                    coisa = new Tesoura();
                }
            }
        }
    }

    public void criarJogada(){
        int rand;
        Random random = new Random();
        rand = random.nextInt(3);
        if(rand == PEDRA){
            coisa = new Pedra();
        }else{
            if(rand == PAPEL){
                coisa = new Papel();
            }else{
                if(rand == TESOURA){
                    coisa = new Tesoura();
                }
            }
        }
    }

    public String mostrar(){
        return coisa.jogar();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias() {
        this.vitorias ++;
    }

    public Coisa getCoisa() {
        return coisa;
    }
}
