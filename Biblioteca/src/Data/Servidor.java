package Data;

import Model.Usuario;

public class Servidor extends Usuario {
    private static int POLITICAEMPRESTIMO = 4;

    public Servidor(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
    }
}
