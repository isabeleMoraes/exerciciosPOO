package Model;

public abstract class Livro {
    private String titulo;
    private String subtitulo;
    private String autor;
    private String editora;
    private int ISBN;

    public Livro(String titulo, String subtitulo, String autor, String editora, int ISBN) {
        this.titulo = titulo;
        this.subtitulo = subtitulo;
        this.autor = autor;
        this.editora = editora;
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }
}
