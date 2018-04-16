package Model;

import Model.CriptografiaMD5;

public abstract class Usuario {
    private String nome;
    private int prontuario;
    private String senha;
    private static int POLITICA_EMPRESTIMO;


    public Usuario(String nome, int prontuario, String senha) {
        this.nome = nome;
        this.prontuario = prontuario;
        setSenha(senha);
    }

    /**
     * Metodo que valida senha informada no momento do emprestimo;
     * @param senha
     * @return verdadeiro se a senha estiver correta e false se a senha estiver errada.
     */
    public boolean verificaSenha(String senha){
        boolean isValita = false;
        String senhaCriptografada = CriptografiaMD5.criptografar(senha);

        if(senhaCriptografada.equals(this.senha)){
            isValita = true;
        }

        return isValita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProntuario() {
        return prontuario;
    }

    public void setProntuario(int prontuario) {
        this.prontuario = prontuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = CriptografiaMD5.criptografar(senha);
    }
}
