package com.bliblioteca;

import java.util.Scanner;

public class BibliotecaMenu {
    public static void main(String[] args) {
        RepositorioLivros repositorio = new RepositorioLivros();
        Scanner leitura = new Scanner(System.in);
        int opcao = 0; 

        do {
            System.out.println("---------------- Biblioteca ----------------");
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Emprestimo de Livro");
            System.out.println("4. Devolver Livro");
            System.out.println("5. Sair");
            System.out.println("Escolha a sua opção: ");
            
            if (!leitura.hasNextInt()) {
                leitura.next();
                System.out.println("Digite um valor válido!");
            } else {
                if (leitura.hasNextInt()) {
                    opcao = leitura.nextInt();
                    leitura.nextLine(); 
                } else {
                    System.out.println("Digite um valor válido!");
                    leitura.next();
                }
                
                switch (opcao) {
                    case 1:
                        UserLivro.UserCadastra(repositorio);
                        break;
                    case 2:
                        RepositorioLivros.listarLivros();
                        break;
                    case 3:
                        System.out.println("Digite o título do livro que deseja emprestar:");
                        String titulo = leitura.nextLine();
                        RepositorioLivros.emprestimo(titulo);
                        break;
                    case 4:
                        System.out.println("Digite o título do livro que deseja devolver:");
                        titulo = leitura.nextLine();
                        RepositorioLivros.devolverLivro(titulo);
                        break;
                    case 5:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            }
        } while (opcao != 5);

        leitura.close();
    }
    
}
