package com.bliblioteca;
import java.util.Scanner;

public class UserLivro{
    public static void UserCadastra(RepositorioLivros repositorio){
        Scanner leitura = new Scanner(System.in);

        System.out.println("Digite o Titulo do livro: ");
        String titulo = leitura.nextLine();
        
        System.out.println("Digite o Autor do livro: ");
        String autor = leitura.nextLine();

        System.out.println("Digite o Numero de paginas do livro: ");
        int paginas = leitura.nextInt();

        System.out.println("Digite o Ano de lançamento do livro: ");
        int anoDeLancamento = leitura.nextInt();
        
        Livro livro = new Livro(titulo, autor, paginas, anoDeLancamento);

        // salvamento no repositorio
        RepositorioLivros.cadastrarLivro(livro);

        
    }
}
