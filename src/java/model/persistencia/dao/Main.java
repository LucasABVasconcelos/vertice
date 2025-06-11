package model.persistencia.dao;

import controller.UsuarioController;

public class Main {
    public static void main(String[] args) {
        UsuarioController controller = new UsuarioController();
        controller.testarCadastroUsuario();
    }
}
