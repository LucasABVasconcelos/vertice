package model.persistencia.dao;

import model.persistencia.Usuario;
import model.persistencia.Endereco;
import model.persistencia.dao.Conexao;
import model.persistencia.dao.EnderecoDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDao {

    // Método para cadastrar o usuário
    public Usuario cadastrar(Usuario usuario) {
        Connection conn = Conexao.conectar();
        PreparedStatement stmtUsuario = null;
        ResultSet rs = null;
        EnderecoDao enderecoDao = new EnderecoDao();
        
        try {
            // Verificar se o endereço já existe (caso o endereço tenha um ID válido)
            Endereco endereco = usuario.getEndereco();
            
            if (endereco == null) {
                System.out.println("Erro: Endereço não pode ser nulo.");
                return null;
            }
            
            // Se o ID do endereço for 0, significa que é um novo endereço
            if (endereco.getId_endereco() == 0) { 
                endereco = enderecoDao.inserir(endereco);  // Insere o endereço
                if (endereco == null) {
                    System.out.println("Erro ao inserir endereço.");
                    return null; // Não prosseguir caso o endereço não seja inserido
                }
            }

            // Agora que o endereço tem um id válido, insira o usuário
            String sql = "INSERT INTO usuario (nome, cpf, data_nascimento, telefone, tipo_usuario, senha_hash, otp_ativo, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmtUsuario = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            stmtUsuario.setString(1, usuario.getNome());
            stmtUsuario.setString(2, usuario.getCpf());
            stmtUsuario.setDate(3, new java.sql.Date(usuario.getData_nascimento().getTime()));  // Converte para SQL Date
            stmtUsuario.setString(4, usuario.getTelefone());
            stmtUsuario.setString(5, usuario.getTipo_usuario().toString()); // Convertendo para string
            stmtUsuario.setString(6, usuario.getSenha_hash());
            stmtUsuario.setString(7, usuario.getOtp_ativo());
            stmtUsuario.setInt(8, endereco.getId_endereco()); // Atribuindo o id_endereco ao usuário
            
            stmtUsuario.executeUpdate();
            
            rs = stmtUsuario.getGeneratedKeys();
            if (rs.next()) {
                usuario.setId_usuario(rs.getInt(1)); // Atribui o id gerado ao usuário
            }
            
            return usuario;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmtUsuario != null) stmtUsuario.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
