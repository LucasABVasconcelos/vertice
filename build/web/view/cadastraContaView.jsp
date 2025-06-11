<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="controller.ClienteController"%>
<%@page import="model.persistencia.Cliente"%>
<%@page import="model.persistencia.Endereco"%>
<%@page import="java.util.Enumeration"%>

<%
    // Dados do cliente
    String nome = request.getParameter("nome");
    String cpf = request.getParameter("cpf");
    String dataNascimentoStr = request.getParameter("data_nascimento");
    Date dataNascimento = null;

    // Verificar se a data de nascimento foi preenchida
    if (dataNascimentoStr == null || dataNascimentoStr.isEmpty()) {
        out.print("<h3 style='color: red;'>A data de nascimento é obrigatória.</h3>");
        return;
    }

    try {
        // Garantir que a data esteja no formato yyyy-MM-dd
        dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimentoStr);
    } catch (Exception e) {
        e.printStackTrace(); 
        out.print("<h3 style='color: red;'>Data de nascimento inválida. O formato deve ser yyyy-MM-dd.</h3>");
        return;
    }

    // Continuar com o restante do código de dados do cliente...

    String telefone = request.getParameter("telefone");
    String senha = request.getParameter("senha");
    String otp = request.getParameter("otp");

    // Verificação de dados obrigatórios
    if (nome == null || nome.isEmpty()) {
        out.print("<h3 style='color: red;'>Nome é obrigatório.</h3>");
        return;
    }
    if (cpf == null || cpf.isEmpty()) {
        out.print("<h3 style='color: red;'>CPF é obrigatório.</h3>");
        return;
    }

    // Verificação de dados obrigatórios do endereço
    String cep = request.getParameter("cep");
    String local = request.getParameter("local");
    String bairro = request.getParameter("bairro");
    String cidade = request.getParameter("cidade");
    String estado = request.getParameter("estado");
    String complemento = request.getParameter("complemento");

    if (cep == null || cep.isEmpty()) {
        out.print("<h3 style='color: red;'>CEP é obrigatório.</h3>");
        return;
    }
    if (local == null || local.isEmpty()) {
        out.print("<h3 style='color: red;'>Local é obrigatório.</h3>");
        return;
    }
    if (bairro == null || bairro.isEmpty()) {
        out.print("<h3 style='color: red;'>Bairro é obrigatório.</h3>");
        return;
    }
    if (cidade == null || cidade.isEmpty()) {
        out.print("<h3 style='color: red;'>Cidade é obrigatória.</h3>");
        return;
    }
    if (estado == null || estado.isEmpty()) {
        out.print("<h3 style='color: red;'>Estado é obrigatório.</h3>");
        return;
    }

    // Converter número da casa de string para inteiro (para evitar exceções)
    int numeroCasa = 0;
    try {
        numeroCasa = Integer.parseInt(request.getParameter("numero_casa"));
    } catch (NumberFormatException e) {
        out.print("<h3 style='color: red;'>Número da casa inválido.</h3>");
        return;
    }

    // Criar o objeto Endereco (garantindo que está inicializado corretamente)
    Endereco endereco = new Endereco();
    endereco.setBairro(bairro);
    endereco.setCep(cep);
    endereco.setCidade(cidade);
    endereco.setComplemento(complemento);
    endereco.setLocal(local);
    endereco.setNumero_casa(numeroCasa);
    endereco.setEstado(estado);

    // Garantir que o endereço está atribuído ao cliente
    Cliente cliente = new Cliente();
    cliente.setNome(nome);
    cliente.setData_nascimento(dataNascimento);
    cliente.setCpf(cpf);
    cliente.setSenha_hash(senha);
    cliente.setOtp_ativo(otp);
    cliente.setTelefone(telefone);
    cliente.setEndereco(endereco); // Atribuição do endereço

    // Criar o DAO de Cliente e cadastrar
    ClienteController clienteControl = new ClienteController();
    cliente = clienteControl.cadastrar(cliente);

    // Verificar se o cliente foi cadastrado corretamente
    if (cliente != null) {
        out.print("<h3 style='color: green;'>Cliente cadastrado com sucesso! ID: " + cliente.getId_usuario() + "</h3>");
    } else {
        out.print("<h3 style='color: red;'>Erro ao cadastrar o cliente.</h3>");
    }
%>
