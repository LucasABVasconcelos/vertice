package model.persistencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;  // Adicionando a importação de List
import model.persistencia.Cliente;
import model.persistencia.Endereco;
import model.persistencia.dao.Conexao;

public class ClienteDao {

    private Connection conn;

    public ClienteDao() {
        try {
            // Conectar apenas se a conexão estiver fechada
            if (this.conn == null || this.conn.isClosed()) {
                this.conn = Conexao.conectar();
            }
        } catch (Exception e) {
            System.out.println("Erro ao inicializar conexão no DAO");
            e.printStackTrace();
        }
    }

    public Cliente cadastrar(Cliente cliente) {
        PreparedStatement stmtEndereco = null;
        PreparedStatement stmtUsuario = null;
        PreparedStatement stmtCliente = null;
        ResultSet rs = null;

        try {
            // Verifique se o endereço do cliente não é null
            if (cliente.getEndereco() == null) {
                System.out.println("Erro: Endereço não foi atribuído ao cliente.");
                return null; // Se o endereço não foi atribuído, retornar null
            }

            // Inserir Endereço
            String sqlEndereco = "INSERT INTO endereco (cep, local, numero_casa, bairro, cidade, estado, complemento) VALUES (?, ?, ?, ?, ?, ?, ?)";
            stmtEndereco = conn.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);

            stmtEndereco.setString(1, cliente.getEndereco().getCep());
            stmtEndereco.setString(2, cliente.getEndereco().getLocal());
            stmtEndereco.setInt(3, cliente.getEndereco().getNumero_casa());
            stmtEndereco.setString(4, cliente.getEndereco().getBairro());
            stmtEndereco.setString(5, cliente.getEndereco().getCidade());
            stmtEndereco.setString(6, cliente.getEndereco().getEstado());
            stmtEndereco.setString(7, cliente.getEndereco().getComplemento());

            stmtEndereco.executeUpdate();

            rs = stmtEndereco.getGeneratedKeys();
            int idEndereco = 0;
            if (rs.next()) {
                idEndereco = rs.getInt(1);
            }
            rs.close();
            stmtEndereco.close();

            // Inserir Usuário
            String sqlUsuario = "INSERT INTO usuario (nome, cpf, telefone, tipo_usuario, senha_hash, otp_ativo, data_nascimento, id_endereco) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            stmtUsuario = conn.prepareStatement(sqlUsuario, Statement.RETURN_GENERATED_KEYS);
            stmtUsuario.setString(1, cliente.getNome());
            stmtUsuario.setString(2, cliente.getCpf());
            stmtUsuario.setString(3, cliente.getTelefone());
            stmtUsuario.setString(4, "cliente");
            stmtUsuario.setString(5, cliente.getSenha_hash());
            stmtUsuario.setString(6, cliente.getOtp_ativo());

            // Corrigir a data de nascimento para formato correto
            stmtUsuario.setDate(7, new java.sql.Date(cliente.getData_nascimento().getTime()));  // Garantir que a data de nascimento é passada corretamente
            stmtUsuario.setInt(8, idEndereco);
            stmtUsuario.executeUpdate();

            rs = stmtUsuario.getGeneratedKeys();
            int idUsuario = 0;
            if (rs.next()) {
                idUsuario = rs.getInt(1);
            }
            rs.close();
            stmtUsuario.close();

            // Inserir Cliente
            String sqlCliente = "INSERT INTO cliente (id_usuario) VALUES (?)";
            stmtCliente = conn.prepareStatement(sqlCliente, Statement.RETURN_GENERATED_KEYS);
            stmtCliente.setInt(1, idUsuario);
            stmtCliente.executeUpdate();

            rs = stmtCliente.getGeneratedKeys();
            int idCliente = 0;
            if (rs.next()) {
                idCliente = rs.getInt(1);
            }

            // Atualizar os IDs no objeto Cliente
            cliente.setId_usuario(idUsuario);
            cliente.setId_cliente(idCliente);

            return cliente;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                // Fechar todos os recursos após as operações
                if (rs != null) rs.close();
                if (stmtEndereco != null) stmtEndereco.close();
                if (stmtUsuario != null) stmtUsuario.close();
                if (stmtCliente != null) stmtCliente.close();
                // Não fechamos a conexão aqui para manter aberta para outros processos
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Métodos adicionais para buscar, excluir e alterar
    public List<Cliente> buscarTodos() {
        // Método para buscar todos os clientes
        return null;
    }

    public List<Cliente> buscarPorNome(String nome) {
        // Método para buscar cliente por nome
        return null;
    }

    public Cliente buscarPorId(int id) {
        // Método para buscar cliente por ID
        return null;
    }

    public boolean excluir(int id) {
        // Método para excluir cliente
        return false;
    }

    public Cliente alterarStatus(int id) {
        // Método para alterar status do cliente
        return null;
    }
}
