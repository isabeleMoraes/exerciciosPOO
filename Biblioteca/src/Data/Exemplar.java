package Data;

import Model.Livro;
import Model.Usuario;

public class Exemplar extends Livro {
    private static int ULTIMO_NUMERO;

    private int id;
    private boolean emprestimo;
    private boolean emprestado;
    private Usuario usuarioEmprestou;

    public Exemplar(String titulo, String subtitulo, String autor, String editora, int ISBN, boolean emprestimo){
        super(titulo, subtitulo, autor, editora, ISBN);
        ULTIMO_NUMERO++;
        id = ULTIMO_NUMERO;
        setEmprestimo(emprestimo);
        emprestado = false;
        usuarioEmprestou = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(boolean emprestimo) {
        this.emprestimo = emprestimo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

    public Usuario getUsuarioEmprestou() {
        return usuarioEmprestou;
    }

    public void setUsuarioEmprestou(Usuario usuarioEmprestou) {
        this.usuarioEmprestou = usuarioEmprestou;
    }

    public int isbnExemplar(){
        return Integer.parseInt(String.valueOf(getISBN() +""+ id));
    }
}
