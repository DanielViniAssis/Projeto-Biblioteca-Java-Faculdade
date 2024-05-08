package com.bliblioteca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepositorioLivros {
    public static void cadastrarLivro(Livro livro) {
        String sql = "INSERT INTO livros (titulo, autor, paginas, ano_de_lancamento, emprestado) VALUES (?, ?, ?, ?, ?)";
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setString(1, livro.getTitulo());
            statement.setString(2, livro.getAutor());
            statement.setInt(3, livro.getPaginas());
            statement.setInt(4, livro.getAnoDeLancamento());
            statement.setBoolean(5, livro.isEmprestado());
    
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Livro cadastrado com sucesso!");
            } else {
                System.out.println("Falha ao cadastrar o livro.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // listagem
    public static void listarLivros() {
        String sql = "SELECT * FROM livros";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            if (!resultSet.isBeforeFirst()) {
                System.out.println("Não há nenhum livro cadastrado!");
            } else {
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Título: " + resultSet.getString("titulo"));
                    System.out.println("Autor: " + resultSet.getString("autor"));
                    System.out.println("Número de páginas: " + resultSet.getInt("paginas"));
                    System.out.println("Ano de lançamento: " + resultSet.getInt("ano_de_lancamento"));
                    System.out.println("Emprestado: " + (resultSet.getBoolean("emprestado") ? "Sim" : "Não"));
                    System.out.println("--------------------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Emprestimo
    public static void emprestimo(String titulo) {
        String sql = "UPDATE livros SET emprestado = true WHERE titulo = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setString(1, titulo);
    
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Empréstimo realizado com sucesso!");
            } else {
                System.out.println("Livro não encontrado ou já emprestado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Devolução
    public static void devolverLivro(String titulo) {
        String sql = "UPDATE livros SET emprestado = false WHERE titulo = ?";
    
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
    
            statement.setString(1, titulo);
    
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Devolução realizada com sucesso!");
            } else {
                System.out.println("Livro não encontrado ou já devolvido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

