package model.persistencia.dao;

import java.sql.*;
import model.persistencia.Funcionario;
import model.persistencia.Cargo;
import model.persistencia.dao.Conexao;
import java.util.List;
import java.util.ArrayList;

public class FuncionarioDao {

    private Connection conn;

    public FuncionarioDao() {
        try {
            if (this.conn == null || this.conn.isClosed()) {
                this.conn = Conexao.conectar();
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inicializar conexão no DAO");
            e.printStackTrace();
        }
    }

    // Cadastrar um novo funcionário
    public Funcionario cadastrar(Funcionario funcionario) {
        PreparedStatement stmtFuncionario = null;
        ResultSet rs = null;

        try {
            // Inserir dados do funcionário
            String sqlFuncionario = "INSERT INTO funcionario (id_usuario, codigo_funcionario, cargo, id_supervisor) VALUES (?, ?, ?, ?)";
            stmtFuncionario = conn.prepareStatement(sqlFuncionario, Statement.RETURN_GENERATED_KEYS);
            stmtFuncionario.setInt(1, funcionario.getIdUsuario());  // ID do usuário
            stmtFuncionario.setString(2, funcionario.getCodigo_funcionario());  // Código do funcionário
            stmtFuncionario.setString(3, funcionario.getCargo().toString());  // Cargo (Enum convertido para String)
            stmtFuncionario.setInt(4, (funcionario.getSupervisor() != null) ? funcionario.getSupervisor().getId_funcionario() : 0);  // ID do supervisor (se houver)

            stmtFuncionario.executeUpdate();

            rs = stmtFuncionario.getGeneratedKeys();
            int idFuncionario = 0;
            if (rs.next()) {
                idFuncionario = rs.getInt(1);
            }
            rs.close();
            stmtFuncionario.close();

            // Atualiza o ID do funcionário no objeto
            funcionario.setId_funcionario(idFuncionario);

            return funcionario;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Buscar todos os funcionários
    public List<Funcionario> buscarTodos() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String query = "SELECT * FROM funcionario";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setCodigo_funcionario(rs.getString("codigo_funcionario"));
                funcionario.setCargo(Cargo.valueOf(rs.getString("cargo")));
                // Defina o supervisor e outros atributos se necessário
                funcionarios.add(funcionario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    // Buscar um funcionário pelo ID
    public Funcionario buscarPorId(int idFuncionario) {
        Funcionario funcionario = null;
        String query = "SELECT * FROM funcionario WHERE id_funcionario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idFuncionario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setCodigo_funcionario(rs.getString("codigo_funcionario"));
                funcionario.setCargo(Cargo.valueOf(rs.getString("cargo")));
                // Defina o supervisor se necessário
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    // Excluir um funcionário pelo ID
    public boolean excluir(int idFuncionario) {
        String query = "DELETE FROM funcionario WHERE id_funcionario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idFuncionario);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Alterar o status de um funcionário (ajustar conforme necessidade)
    public Funcionario alterarStatus(int idFuncionario) {
        String query = "UPDATE funcionario SET status = 'novo_status' WHERE id_funcionario = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idFuncionario);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                return buscarPorId(idFuncionario); // Retorna o funcionário atualizado
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
