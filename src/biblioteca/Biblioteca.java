package biblioteca;

import biblioteca.view.TelaBiblioteca;

public class Biblioteca {
    public static void main(String[] args) {
        /*   Autor autor = new Autor(0, "João", "das Couves");
        AutorController ca = new AutorController();
        ca.addAutor(autor);
        */   
        /*  List<Autor> listaAutores = ca.listAutores();
        
        for (Autor autor : listaAutores) {
        System.out.println("ID: " + autor.getId());
        System.out.println("Nome: " + autor.getNome());
        System.out.println("Sobrenome: " + autor.getSobrenome());
        System.out.println("------------------------");*/
      //  }

        // Criação do objeto Livro
        /*        Livro livro;
        String dataString = "2023-05-10";
        Date data = Date.valueOf(dataString);
        livro = new Livro(0,"Livro Exemplo 5",data,1);
        
        // Criação do objeto LivroDAO e chamada do método cadastrarLivro
        LivroDAO livroDAO = new LivroDAO();
        livroDAO.cadastrarLivro(livro);*/
        
        TelaBiblioteca tela = new TelaBiblioteca();
        tela.setVisible(true);
    }
}
