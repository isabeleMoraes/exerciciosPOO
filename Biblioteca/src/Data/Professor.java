package Data;

import Model.Usuario;

public class Professor extends Usuario {
    private static int POLITICAEMPRESTIMO = 30;

    public Professor(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
    }
}
