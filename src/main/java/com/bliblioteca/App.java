package com.bliblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.plaf.nimbus.State;

public class App 
{
    public static void main( String[] args )
    {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/biblioteca", "postgres", "123");
        if(conexao != null){
            System.out.println("Banco de dados conectado com sucesso!");
            Statement stm = conexao.createStatement();
            consultarDados(stm);
        } else{
            System.out.println("Conexão falhou");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    static void consultarDados(Statement stm){
        String sql = "select id, titulo, autor, paginas, ano_de_lancamento, emprestado from livros";
        try {
            ResultSet result = stm.executeQuery(sql);
            while (result.next()) {
                System.out.println("id: " + result.getInt("id") + ", titulo: " + result.getString("titulo"));
            }
        } catch (SQLException e) {  
            e.printStackTrace();
        }
    }
}
