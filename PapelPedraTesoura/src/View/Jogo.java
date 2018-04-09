package View;

import Recursos.Jogador;

import javax.swing.*;

public class Jogo {
    static int i = 0;
    static String vencedor, vencedorRodada;


    public static void main(String[] args) {
        int opcaoSelecionada, qtdeBatalhas =-1;
        boolean repetindo=false;
        Jogador[] jogadores = null;

        JOptionPane.showMessageDialog(null,"BEM VINDO AO JOGO JOKENPO!!!");

        qtdeBatalhas = Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja batalhar 1 vez ou 3 vezes?"));

        opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Escolha uma das opções abaixo:\n" +
                "1. Ler as regras.\n" +
                "2. Jogar com o computador.\n" +
                "3. Joga com varios computadores\n" +
                "4. Gerar dois jogadores automaticos."+
                        "\nOBSERVAÇÃO: O jogador de menor numero tem vantagem nos empates"));


        while (i != qtdeBatalhas) {
            if (opcaoSelecionada == 1) {
                ImageIcon imagemRegra = new ImageIcon(Jogo.class.getResource("jokenpo.jpg"));
                JOptionPane.showMessageDialog(null,
                        "- Pedra ganha da tesoura (quebra a tesoura)\n" +
                                "- Tesoura ganha do papel (corta o papel)\n" +
                                "- Papel ganha da pedra (embrulha a pedra)", "REGRAS DO JOGO!", JOptionPane.INFORMATION_MESSAGE, imagemRegra);
                opcaoSelecionada = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "2. Jogar com o computador.\n" +
                                "3. Joga com varios computadores.\n" +
                                "4. Gerar dois jogadores automaticos."+
                                "OBSERVAÇÃO: O jogador de menor numero tem vantagem nos empates"));
            } else {

                String nomeJogador;

                switch (opcaoSelecionada) {
                    case 2:
                        int coisaUsuario;

                        if(jogadores==null){
                            jogadores = new Jogador[2];
                            for(int i=0; i<jogadores.length;i++){
                                jogadores[i] = new Jogador("Jogador "+i);
                            }
                            JOptionPane.showMessageDialog(null, "Voce será o jogador 0. OK?");
                        }

                        coisaUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da sua jogada: \n" +
                                "0. PEDRA\n" +
                                "1. PAPEL\n" +
                                "2. TESOURA"));

                        jogadores[0].criarJogada(coisaUsuario);

                        for(int i=1; i<jogadores.length;i++){
                            jogadores[i].criarJogada();
                        }



                        JOptionPane.showMessageDialog(null,  verificaVencedorRodada(jogadores) + "\n Resultado da jogada: " + vencedorRodada);

                        break;
                    case 3:
                        if(jogadores == null){
                            int qtdeComputadores = Integer.parseInt(JOptionPane.showInputDialog(null,"Contra quando computadores deseja jogar?"));
                            jogadores = new Jogador[qtdeComputadores+1];
                            for(int i=0; i<jogadores.length;i++){
                                jogadores[i] = new Jogador("Jogador "+i);
                            }

                            JOptionPane.showMessageDialog(null, "Voce será o jogador 0. OK?");

                        }

                        coisaUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o numero da sua jogada: \n" +
                                "0. PEDRA\n" +
                                "1. PAPEL\n" +
                                "2. TESOURA"));

                        jogadores[0].criarJogada(coisaUsuario);

                        for(int i=1; i<jogadores.length;i++){
                            jogadores[i].criarJogada();
                        }

                        JOptionPane.showMessageDialog(null,  verificaVencedorRodada(jogadores) + "\n Resultado da jogada: " + vencedorRodada);

                        break;

                    case 4:
                        if(jogadores==null){
                            jogadores = new Jogador[2];
                            for(int i=0; i<jogadores.length;i++){
                                jogadores[i] = new Jogador("Jogador "+i);
                            }
                        }


                        for(int i=0; i<jogadores.length;i++){
                            jogadores[i].criarJogada();
                        }

                        JOptionPane.showMessageDialog(null,  verificaVencedorRodada(jogadores) + "\n Resultado da jogada: " + vencedorRodada);

                        break;


                }
                 i++;

                if (i == qtdeBatalhas) {
                    JOptionPane.showMessageDialog(null, vencedor + " é o(a) grande vencedor");
                }
            }

        }
    }

    public static String verificaVencedorRodada(Jogador[] jds){
        Jogador ganhou, aux, vitorioso;

        ganhou = jds[0];
        aux = jds[0];
        vitorioso = jds[0];

        StringBuffer stringBuffer = new StringBuffer();


        for(int j=0; j<jds.length;j++){
            for(int g=0; g<jds.length; g++){
                if(i!=g){
                    if(jds[j].mostrar().equals(jds[g].getCoisa().getFraqueza())){
                        aux = jds[j];
                    }else{
                        if(jds[j].mostrar().equals(jds[g].getCoisa().getVantagem())){
                            aux= jds[g];
                        }else{
                            aux = jds[j];
                        }
                    }
                }
            }

                stringBuffer.append("\n");
                stringBuffer.append(jds[j].getNome());
                stringBuffer.append(": ");
                stringBuffer.append(jds[j].mostrar());



            if(ganhou.mostrar().equals(aux.getCoisa().getVantagem())){
                ganhou = aux;
            }

        }

        ganhou.setVitorias();

        vencedorRodada = ganhou.getNome();

        for(int i=0; i<jds.length;i++){
            if(vitorioso.getVitorias() < jds[i].getVitorias()){
                vitorioso = jds[i];
            }
        }
        vencedor = vitorioso.getNome();

        return stringBuffer.toString();
    }

}
