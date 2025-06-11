package controller;

import model.persistencia.Cliente;
import model.persistencia.Endereco;
import model.persistencia.dao.ClienteDao;
import model.persistencia.dao.EnderecoDao;

public class ClienteController {

    // Método para cadastrar o cliente e seu endereço
    public Cliente cadastrar(Cliente cliente) {
        // Verificar se o cliente tem um endereço atribuído
        if (cliente.getEndereco() == null) {
            System.out.println("Erro: Endereço não foi atribuído ao cliente.");
            return null;  // Retorna null se o endereço não for atribuído
        }

        // Criação do DAO de Endereço
        EnderecoDao enderecoDao = new EnderecoDao();
        Endereco endereco = cliente.getEndereco();
        
        // Inserir o endereço primeiro, se não tiver id
        if (endereco.getId_endereco() == 0) {
            // Caso o id do endereço seja 0, inserimos no banco e obtemos o id gerado
            endereco = enderecoDao.inserir(endereco);
            if (endereco == null) {
                System.out.println("Erro: Não foi possível cadastrar o endereço.");
                return null;  // Se o endereço não for inserido corretamente, retorna null
            }
            cliente.setEndereco(endereco); // Atualiza o endereço do cliente com o id gerado
        }
        
        // Criação do DAO de Cliente e cadastro
        ClienteDao clienteDao = new ClienteDao();
        cliente = clienteDao.cadastrar(cliente);
        
        if (cliente == null) {
            System.out.println("Erro: Não foi possível cadastrar o cliente.");
            return null;  // Se o cliente não for inserido corretamente, retorna null
        }

        // Retorna o cliente, que agora deve ter o id e o endereço associado
        return cliente;
    }
}
