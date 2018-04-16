package View;

import Data.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        Biblioteca biblioteca = new Biblioteca();

        cadastrarUsuarios(biblioteca);
        cadastrarLivros(biblioteca);
        JOptionPane.showMessageDialog(null,"Ola. Nesse momento foram cadastrados diversos usuarios e livros para agilizar :).");
        emprestarVariosLivros(biblioteca);
        JOptionPane.showMessageDialog(null, "Agora foram emprestados varios livros. Tambem para agilizar");

        int opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da opção desejada: \n" +
                "1. Gerar relatório de Alunos e livros emprestados.\n" +
                "2. Gerar relatório de Livros da biblioteca com a quantidade de exemplares disponíveis no momento.\n" +
                "3. Gerar relatório de Livros emprestados com a indicação do exemplar e aluno com o livro \n" +
                "4. Emprestar um livro\n" +
                "5. Devolver um livro\n" +
                "6. Cadastrar exemplar de um Livro\n" +
                "7. Cadastrar Usuario\n" +
                "0. Sair"));

        while(opcao != 0){
            int prontuario;
            String titulo,subtitulo,autor,editora,nome,senha;
            int ISBN;
            boolean emprestimo;

            switch (opcao){
                case 1:
                    JOptionPane.showMessageDialog(null, biblioteca.relacaoAlunosLivrosEmprestados());
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,biblioteca.relacaoExemplaresDisponiveis());
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null,biblioteca.relacaoLivrosEmprestadosParaAlunos());
                    break;
                case 4:
                    prontuario = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o prontuario do usuario"));
                    senha = JOptionPane.showInputDialog(null, "Informe a senha do usuario");
                    ISBN = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o ISBN do exemplar"));

                    JOptionPane.showMessageDialog(null,biblioteca.emprestarLivro(prontuario,senha,ISBN));
                    break;
                case 5:
                    ISBN = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o ISBN do exemplar que deseja devolver"));

                    JOptionPane.showMessageDialog(null,biblioteca.devolverLivros(ISBN));
                    break;
                case 6:
                    titulo = JOptionPane.showInputDialog(null,"Informe o titulo do livro");
                    subtitulo = JOptionPane.showInputDialog(null,"Informe o subtitulo do livro");
                    autor = JOptionPane.showInputDialog(null,"Informe o autor do livro");
                    editora = JOptionPane.showInputDialog(null,"Informe a editora do livro");
                    ISBN = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o ISBN do livro"));

                    if(JOptionPane.showConfirmDialog(null,"Esse livro proderá ser emprestado?","", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        emprestimo = true;
                    }else{
                        emprestimo = false;
                    }

                    JOptionPane.showMessageDialog(null,biblioteca.cadastrarLivro(new Exemplar(titulo,subtitulo,autor,editora,ISBN,emprestimo)));
                    break;
                case 7:
                    nome = JOptionPane.showInputDialog(null,"Informe o nome do usuario!");
                    prontuario = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o prontuario do usuario"));
                    senha = JOptionPane.showInputDialog(null,"Informe a senha do usuario");

                    int tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o codigo do tipo de usuario:\n" +
                            "1.Aluno" +
                            "2.Professor" +
                            "3.Servidor"));
                    switch (tipoUsuario){
                        case 1:
                            JOptionPane.showMessageDialog(null,biblioteca.cadastrarUsuario(new Aluno(nome,prontuario,senha)));
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,biblioteca.cadastrarUsuario(new Professor(nome,prontuario,senha)));
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null,biblioteca.cadastrarUsuario(new Servidor(nome,prontuario,senha)));
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opção invalida!!!");
                    }

                    break;
            }


            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o numero da opção desejada: \n" +
                    "1. Gerar relatório de Alunos e livros emprestados.\n" +
                    "2. Gerar relatório de Livros da biblioteca com a quantidade de exemplares disponíveis no momento.\n" +
                    "3. Gerar relatório de Livros emprestados com a indicação do exemplar e aluno com o livro \n" +
                    "4. Emprestar um livro\n" +
                    "5. Devolver um livro qualquer\n" +
                    "6. Cadastrar Livro\n" +
                    "7. Cadastrar Usuario\n" +
                    "0. Sair"));
        }






    }

    private static void emprestarVariosLivros(Biblioteca biblioteca){
        System.out.println(biblioteca.emprestarLivro(1711351,"abcd",1234561));  // Java como programar
        System.out.println(biblioteca.emprestarLivro(1711351,"abcd",6543217));  // Estatistica Basica
        System.out.println(biblioteca.emprestarLivro(1234567,"abcd",74125817)); // POO com ednilson
        System.out.println(biblioteca.emprestarLivro(1234567,"abcd",6543218));  // Estatistica Basica
        System.out.println(biblioteca.emprestarLivro(9632587,"abcd",45678911)); // Estatistica aplicada
        System.out.println(biblioteca.emprestarLivro(9632587,"abcd",1234563));  // Java como programar

    }

    private static void cadastrarUsuarios(Biblioteca biblioteca){
        biblioteca.cadastrarUsuario(new Aluno("Isabele Moraes", 1711351,"abcd"));
        biblioteca.cadastrarUsuario(new Aluno("Caio", 1234567,"abcd"));
        biblioteca.cadastrarUsuario(new Aluno("Gabriel Frodo", 4657894,"abcd"));
        biblioteca.cadastrarUsuario(new Aluno("Gabriel Sthalberg", 7894561,"abcd"));
        biblioteca.cadastrarUsuario(new Aluno("Leonardo Rossi", 9632587,"abcd"));

        biblioteca.cadastrarUsuario(new Professor("Ednilson Rossi", 9784563,"123456"));
        biblioteca.cadastrarUsuario(new Professor("Francisco Pirola", 4567912,"Joia"));
        biblioteca.cadastrarUsuario(new Professor("Edilson", 7894521,"123456"));

        biblioteca.cadastrarUsuario(new Professor("Servidor 1", 8521479,"654321"));
        biblioteca.cadastrarUsuario(new Professor("Servidor 2", 9513574,"654321"));
        biblioteca.cadastrarUsuario(new Professor("Servidor 3", 6542587,"654321"));
    }

    private static void cadastrarLivros(Biblioteca biblioteca){
        biblioteca.cadastrarLivro(new Exemplar("Java","Como Programar","Deitel","Java livros",123456,true));
        biblioteca.cadastrarLivro(new Exemplar("Java","Como Programar","Deitel","Java livros",123456,false));
        biblioteca.cadastrarLivro(new Exemplar("Java","Como Programar","Deitel","Java livros",123456,true));
        biblioteca.cadastrarLivro(new Exemplar("Java","Como Programar","Deitel","Java livros",123456,true));
        biblioteca.cadastrarLivro(new Exemplar("Java","Como Programar","Deitel","Java livros",123456,true));

        biblioteca.cadastrarLivro(new Exemplar("Estistica Basica","Isabele será aprovada","Ana","Estatistica livros",654321,false));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Basica","Isabele será aprovada","Ana","Estatistica livros",654321,true));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Basica","Isabele será aprovada","Ana","Estatistica livros",654321,true));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Basica","Isabele será aprovada","Ana","Estatistica livros",654321,true));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Basica","Isabele será aprovada","Ana","Estatistica livros",654321,true));

        biblioteca.cadastrarLivro(new Exemplar("Estistica Aplicada","Isabele será aprovada com certeza","Ana","Estatistica livros",456789,true));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Aplicada","Isabele será aprovada com certeza","Ana","Estatistica livros",456789,true));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Aplicada","Isabele será aprovada com certeza","Ana","Estatistica livros",456789,true));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Aplicada","Isabele será aprovada com certeza","Ana","Estatistica livros",456789,false));
        biblioteca.cadastrarLivro(new Exemplar("Estistica Aplicada","Isabele será aprovada com certeza","Ana","Estatistica livros",456789,true));


        biblioteca.cadastrarLivro(new Exemplar("POO com Ednilson","Isabele aprovada, mais que certeza","Ednilson","Estatistica livros",741258,false));
        biblioteca.cadastrarLivro(new Exemplar("POO com Ednilson","Isabele aprovada, mais que certeza","Ednilson","Estatistica livros",741258,true));
        biblioteca.cadastrarLivro(new Exemplar("POO com Ednilson","Isabele aprovada, mais que certeza","Ednilson","Estatistica livros",741258,true));
        biblioteca.cadastrarLivro(new Exemplar("POO com Ednilson","Isabele aprovada, mais que certeza","Ednilson","Estatistica livros",741258,true));
        biblioteca.cadastrarLivro(new Exemplar("POO com Ednilson","Isabele aprovada, mais que certeza","Ednilson","Estatistica livros",741258,true));
    }

}
