package controller;

import model.persistencia.Usuario;
import model.persistencia.Endereco;
import model.persistencia.dao.UsuarioDao;
import model.persistencia.dao.EnderecoDao;

public class UsuarioController {

    // Método para testar o cadastro de um usuário com o endereço
    public void testarCadastroUsuario() {
        // Criar o usuário
        Usuario usuario = new Usuario();
        usuario.setNome("João Silva");
        usuario.setCpf("12345678900");
        usuario.setTelefone("11987654321");
        usuario.setData_nascimento(new java.util.Date());
        usuario.setTipo_usuario(model.persistencia.util.TipoUsuario.FUNCIONARIO);
        usuario.setSenha_hash("senha123");

        // Criar o DAO de Usuário e cadastrar
        UsuarioDao usuarioDao = new UsuarioDao();
        usuario = usuarioDao.cadastrar(usuario);

        // Verificar se o usuário foi criado com sucesso (id_usuario será atribuído)
        if (usuario.getId_usuario() > 0) {
            System.out.println("Usuário cadastrado com sucesso. ID: " + usuario.getId_usuario());

            // Criar o endereço
            Endereco endereco = new Endereco();
            endereco.setCep("12345-678");
            endereco.setLocal("Rua Teste");
            endereco.setNumero_casa(100);
            endereco.setBairro("Centro");
            endereco.setCidade("Cidade Exemplo");

            // Garantir que o campo 'estado' não é nulo
            String estado = "EX"; // Defina o valor de 'estado' aqui
            if (estado != null && !estado.isEmpty()) {
                endereco.setEstado(estado);  // Setar o estado
            } else {
                // Caso esteja nulo ou vazio, defina um valor padrão
                endereco.setEstado("XX");  // Exemplo de valor padrão
            }

            endereco.setComplemento("Apto 101");

            // Inserir o endereço no banco de dados
            EnderecoDao enderecoDao = new EnderecoDao();
            endereco = enderecoDao.inserir(endereco); // Inserção do endereço no banco

            // Verificar se o endereço foi inserido com sucesso
            if (endereco != null && endereco.getId_endereco() > 0) {
                usuario.setEndereco(endereco);  // Associa o usuário criado com o endereço inserido
                System.out.println("Endereço cadastrado com sucesso para o usuário ID: " + usuario.getId_usuario());
            } else {
                System.out.println("Erro ao cadastrar o endereço.");
            }
        } else {
            System.out.println("Erro ao cadastrar o usuário.");
        }
    }
}
