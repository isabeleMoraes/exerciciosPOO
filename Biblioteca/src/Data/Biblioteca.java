package Data;

import Model.Livro;
import Model.Usuario;


public class Biblioteca {

    private static int ULTIMO_LIVRO;
    private static int ULTIMO_USUARIO;

    private Exemplar[] livros;
    private Usuario[] usuarios;


    public Biblioteca() {
        this.livros = new Exemplar[2000];
        this.usuarios = new Usuario[500];
        ULTIMO_LIVRO = 0;
        ULTIMO_USUARIO = 0;
    }

    /**
     * Metodo responsavel por realizar o cadastro de livros em um vetor;
     * @param livro
     * @return texto com o resultado do cadastro.
     */
    public String cadastrarLivro(Exemplar livro){
        String texto="";
        if(ULTIMO_LIVRO != 2001){
            livros[ULTIMO_LIVRO] = livro;
            texto = "Livro cadastrado com sucesso\n"+ "ISBN do exemplar: " + livros[ULTIMO_LIVRO].isbnExemplar();
            ULTIMO_LIVRO++;
        }else{
            texto = "Não há espaço para mais livros nessa biblioteca";
        }
        return texto;
    }

    /**
     * Metodo responsavel por cadastrar usuarios;
     * @param usuario
     * @return texto com o resultado do cadastro.
     */
    public String cadastrarUsuario(Usuario usuario){
        //inicialmente é possivel cadastrar normalmente, então eu seto como true.
        boolean podeCadastrar=true;
        String texto="";

        if(ULTIMO_USUARIO != 501) {

            if (ULTIMO_USUARIO != 0) {
                for (int i = 0; i < ULTIMO_USUARIO; i++) {
                    //se for encontrado um usuario com o prontuario informado, então seto a variavel como false,
                    // pois nao será possivel cadastrar o usuario passado como parametro
                    if (usuarios[i].getProntuario() == usuario.getProntuario()) {
                        podeCadastrar = false;
                        texto = "Prontuario já cadastrado para um usuario";
                    }
                }
            }


            //verifico se posso cadastrar o novo;
            if (podeCadastrar) {
                usuarios[ULTIMO_USUARIO] = usuario;
                ULTIMO_USUARIO++;
                texto = "Usuario Cadastrado com Sucesso!";
            }
        }else{
            texto = "Não há mais espaço para mais usuarios.";
        }
        return texto;

    }

    /**
     * Metodo responsavel por emprestar um exemplar a um determinado usuario;
     * @param prontuario
     * @param senha
     * @param ISBN
     * @return Texto com o resultado do cadastro;
     */
    public String emprestarLivro (int prontuario, String senha, int ISBN){
        Usuario usuario = null;
        Exemplar livro = null;
        String texto="a";
        int i;

        for(i=0;i<ULTIMO_LIVRO;i++){
            texto = "";
            if(livros[i].isbnExemplar() == ISBN){
                if(livros[i].isEmprestimo() && !livros[i].isEmprestado()){
                    livro = livros[i];
                    i=ULTIMO_LIVRO;
                }else{
                    if(livros[i].isEmprestado()){
                        texto = "O livro informado está emprestado para o usuario cujo o prontuario é: "+livros[i].getUsuarioEmprestou().getProntuario();
                    }else{
                        if(!livros[i].isEmprestimo()){
                            texto = "O livro informado não pode ser emprestado";
                        }
                    }
                }
            }else{
                texto = "Livro não encontrado";
            }
        }

        for(i=0;i<ULTIMO_USUARIO;i++){

            if(usuarios[i].getProntuario() == prontuario & usuarios[i].verificaSenha(senha)){
                usuario = usuarios[i];
                i=ULTIMO_USUARIO;
            }else{
                texto = "";
                texto += "\n Usuario não encontrado ou senha incorreta";
            }
        }

        if(usuario!=null && livro!=null){
            livro.setEmprestado(true);
            livro.setUsuarioEmprestou(usuario);
            texto = "Livro emprestado com sucesso!";
        }

        return texto;
    }

    /**
     * Metodo responsavel pela devolução de livros emprestados.
     * @param ISBN
     * @return Texto com resultado da devolução;
     */
    public String devolverLivros(int ISBN){
        String texto="";

        for(int i=0;i<ULTIMO_LIVRO;i++){
            if(livros[i].isbnExemplar() == ISBN){
                if(livros[i].isEmprestado()){
                    livros[i].setEmprestado(false);
                    livros[i].setUsuarioEmprestou(null);
                    i=ULTIMO_LIVRO;
                    texto="Livro devolvido com sucesso!";
                }else{
                    texto = "O livro informado não está emprestado";
                }
            }else{
                texto = "Livro não encontrado";
            }
        }

        return texto;
    }

    /**
     * Relação de alunos e os livros que o mesmo emprestou
     * @return stringBuffer com o texto da relação.
     */
    public String relacaoAlunosLivrosEmprestados(){
        StringBuffer stringBuffer, stringBufferAux;
        stringBuffer = new StringBuffer();

        Aluno aluno;
        int cont;

        for(int i=0; i<ULTIMO_USUARIO;i++){
            if(usuarios[i] instanceof Aluno){
                stringBufferAux = new StringBuffer();
                stringBufferAux.append("Livros empresatados para ");
                stringBufferAux.append(usuarios[i].getNome().toUpperCase());
                stringBufferAux.append("\n");

                cont = 0;

                for (int j=0; j<ULTIMO_LIVRO;j++){
                    if(livros[j].getUsuarioEmprestou() != null){
                        if(livros[j].isEmprestimo() & livros[j].isEmprestado() && livros[j].getUsuarioEmprestou().getProntuario() == usuarios[i].getProntuario()){
                            stringBufferAux.append("- ");
                            stringBufferAux.append(livros[j].getTitulo());
                            stringBufferAux.append(" ");
                            stringBufferAux.append(livros[j].getSubtitulo());
                            stringBufferAux.append("\n");
                            cont ++;
                        }
                    }
                }

                stringBufferAux.append("\n\n");

                if(cont != 0){
                    stringBuffer.append(stringBufferAux.toString());
                }

            }
        }

        return stringBuffer.toString();
    }

    /**
     * Relação de exemplares disponiveis para emprestimo;
     * @return stringBuffer com o texto da relação.
     */

    public String relacaoExemplaresDisponiveis(){
        StringBuffer stringBuffer = new StringBuffer();
        int qtde;

        for(int i=0; i<ULTIMO_LIVRO;i++){
            qtde=0;

            if(!livroJaVerificado(i, livros[i].getISBN()) ){
                stringBuffer.append(livros[i].getTitulo().toUpperCase());
                stringBuffer.append(" ");
                stringBuffer.append(livros[i].getSubtitulo().toUpperCase());
                stringBuffer.append(" possui ");
                for(int j=0; j<ULTIMO_LIVRO;j++){
                    if (livros[i].getISBN() == livros[j].getISBN() & livros[j].isEmprestimo() & !livros[j].isEmprestado()){
                        qtde++;
                    }
                }
                stringBuffer.append(qtde);
                stringBuffer.append(" exemplares disponiveis!\n");

            }


        }
        return stringBuffer.toString();
    }

    /**
     * Relação de livros emprestados e os respectivos alunos;
     * @return stringBuffer com o texto da relação.
     */

    public String relacaoLivrosEmprestadosParaAlunos(){
        StringBuffer stringBuffer = new StringBuffer();

        for(int i=0; i<ULTIMO_LIVRO;i++){

            if(!livroJaVerificado(i, livros[i].getISBN())){

                stringBuffer.append(livros[i].getTitulo().toUpperCase());
                stringBuffer.append(" ");
                stringBuffer.append(livros[i].getSubtitulo().toUpperCase());
                stringBuffer.append("\n");

                for(int j=0; j<ULTIMO_LIVRO;j++){

                    if (livros[j].getUsuarioEmprestou() instanceof Aluno & livros[i].getISBN() == livros[j].getISBN() & livros[j].isEmprestimo() & livros[j].isEmprestado()){

                        stringBuffer.append("Exemplar ");
                        stringBuffer.append((j+1));
                        stringBuffer.append(": ");
                        stringBuffer.append(livros[j].getUsuarioEmprestou().getNome());
                        stringBuffer.append("\n");

                    }
                }
                stringBuffer.append("\n");

            }


        }
        return stringBuffer.toString();
    }

    private boolean livroJaVerificado(int tamanho, int isbn){
        boolean achou =false;

        for(int i=0; i<tamanho;i++){
            if(livros[i].getISBN() == isbn){
                achou = true;
                i=tamanho;
            }
        }
        return achou;
    }
}
