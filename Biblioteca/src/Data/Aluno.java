package Data;


import Model.Usuario;

public class Aluno extends Usuario {
    private static int POLITICA_EMPRESTIMO = 7;

    public Aluno(String nome, int prontuario, String senha) {
        super(nome, prontuario, senha);
    }
}
