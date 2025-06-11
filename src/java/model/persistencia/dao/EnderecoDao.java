package model.persistencia.dao;

import model.persistencia.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class EnderecoDao {

    // Método para inserir ou buscar um endereço existente
    public Endereco inserir(Endereco endereco) {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Verificar se a conexão está aberta
            if (conn == null || conn.isClosed()) {
                conn = Conexao.conectar();
            }

            // Verificar se o endereço já existe no banco
            if (verificarEnderecoExistente(endereco)) {
                // Se o endereço já existir, retorna o endereço existente
                return buscarEnderecoExistente(endereco);
            }

            // Caso o endereço não exista, insere o novo endereço
            String sql = "INSERT INTO endereco (cep, local, numero_casa, bairro, cidade, estado, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getLocal());
            stmt.setInt(3, endereco.getNumero_casa());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());
            stmt.setString(7, endereco.getComplemento());

            stmt.executeUpdate();
            rs = stmt.getGeneratedKeys();
            
            if (rs.next()) {
                endereco.setId_endereco(rs.getInt(1));  // Retorna o ID do novo endereço
            }
            
            return endereco;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                // Não fechar a conexão aqui, pois ela será usada posteriormente
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Verifica se o endereço já existe com base nos campos essenciais
    private boolean verificarEnderecoExistente(Endereco endereco) {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Verificar se a conexão está aberta
            if (conn == null || conn.isClosed()) {
                conn = Conexao.conectar();
            }

            String sql = "SELECT * FROM endereco WHERE cep = ? AND local = ? AND numero_casa = ? AND bairro = ? AND cidade = ? AND estado = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getLocal());
            stmt.setInt(3, endereco.getNumero_casa());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());

            rs = stmt.executeQuery();
            return rs.next();  // Retorna true se o endereço já existir
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                // Não fechar a conexão aqui, pois ela será usada posteriormente
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Recupera o endereço existente do banco de dados
    private Endereco buscarEnderecoExistente(Endereco endereco) {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Endereco enderecoExistente = null;

        try {
            // Verificar se a conexão está aberta
            if (conn == null || conn.isClosed()) {
                conn = Conexao.conectar();
            }

            String sql = "SELECT * FROM endereco WHERE cep = ? AND local = ? AND numero_casa = ? AND bairro = ? AND cidade = ? AND estado = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getLocal());
            stmt.setInt(3, endereco.getNumero_casa());
            stmt.setString(4, endereco.getBairro());
            stmt.setString(5, endereco.getCidade());
            stmt.setString(6, endereco.getEstado());

            rs = stmt.executeQuery();
            if (rs.next()) {
                enderecoExistente = new Endereco();
                enderecoExistente.setId_endereco(rs.getInt("id_endereco"));
                enderecoExistente.setCep(rs.getString("cep"));
                enderecoExistente.setLocal(rs.getString("local"));
                enderecoExistente.setNumero_casa(rs.getInt("numero_casa"));
                enderecoExistente.setBairro(rs.getString("bairro"));
                enderecoExistente.setCidade(rs.getString("cidade"));
                enderecoExistente.setEstado(rs.getString("estado"));
                enderecoExistente.setComplemento(rs.getString("complemento"));
            }
            return enderecoExistente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                // Não fechar a conexão aqui, pois ela será usada posteriormente
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
