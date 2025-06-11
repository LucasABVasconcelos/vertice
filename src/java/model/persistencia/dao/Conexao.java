package model.persistencia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    static String usuario = "root";
    static String senha = "A@bc123@";
    static String url = "jdbc:mysql://localhost:3306/bancovertice_db";  // URL do banco de dados
    static String driver = "com.mysql.cj.jdbc.Driver";  // Driver JDBC do MySQL
    
    static Connection conexao = null;

    // Método que ativa a conexão
    public static Connection conectar() {
        try {
            if (conexao == null || conexao.isClosed()) {  // Verificar se a conexão já está ativa
                Class.forName(driver);  // Carregar o driver JDBC
                conexao = DriverManager.getConnection(url, usuario, senha);  // Estabelecer a conexão
                System.out.println(conexao.getClass().getName());  // Mostrar a classe da conexão
                System.out.println("Conexão ativa");
            }
        } catch (Exception e) {
            System.out.println("Conexão falhou");
            e.printStackTrace();  // Imprimir detalhes do erro
        }

        return conexao;
    }

    // Método para destruir a conexão quando não for mais necessária
    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();  // Fechar a conexão
                System.out.println("Conexão fechada");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao fechar a conexão");
            e.printStackTrace();  // Imprimir detalhes do erro
        }
    }
}
