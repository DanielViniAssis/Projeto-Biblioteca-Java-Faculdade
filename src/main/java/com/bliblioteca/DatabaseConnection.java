package com.bliblioteca;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/biblioteca";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            if (conn != null) {
                System.out.println("Conexão com o banco de dados estabelecida.");
            
                try (Statement statement = conn.createStatement()) {
                    String sql = "CREATE TABLE IF NOT EXISTS livros ("
                            + "id SERIAL PRIMARY KEY,"
                            + "titulo VARCHAR,"
                            + "autor VARCHAR,"
                            + "paginas INTEGER,"
                            + "ano_de_lancamento INTEGER,"
                            + "emprestado BOOLEAN DEFAULT FALSE"
                            + ")";
                    statement.execute(sql);
                    
                    System.out.println("Tabela criada com sucesso.");
                } catch (SQLException e) {
                    System.out.println("Erro ao criar a tabela: " + e.getMessage());
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}
