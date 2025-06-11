<%-- 
    Document   : formCadastroCliente
    Created on : 2 de jun. de 2025, 09:31:55
    Author     : Hially
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Cadastro de Cliente - Banco Malvader</title>
  <style>
    * {
      box-sizing: border-box;
    }

    body {
      font-family: Arial, sans-serif;
      background-color: #f0f4f8;
      margin: 0;
      padding: 0;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    header {
      background-color: #F6A122;
      padding: 20px;
      display: flex;
      align-items: center;
      justify-content: center;
      color: white;
    }

    header img {
      height: 50px;
      margin-right: 15px;
    }

    .container {
      flex: 1;
      background-color: #ffffff;
      padding: 30px;
      margin: 30px auto;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
      max-width: 600px;
      width: 100%;
    }

    h2 {
      text-align: center;
      margin-bottom: 25px;
      color: #362102;
    }

    h3 {
      margin-top: 30px;
      color: #374151;
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: bold;
    }

    input, select {
      width: 100%;
      padding: 8px;
      margin-top: 5px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    button {
      margin-top: 25px;
      width: 100%;
      padding: 12px;
      background-color: #D88509;
      color: white;
      font-size: 16px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
    }

    button:hover {
      background-color: #F6A122;
    }

    footer {
      background-color: #111827;
      color: #9ca3af;
      text-align: center;
      padding: 15px;
      font-size: 13px;
    }
  </style>
</head>
<body>

  <header>
    <img src="../logo_n.png" alt="Logo Banco Malvader">
  </header>

  <div class="container">
    <h2>Cadastro de Cliente</h2>
    <form method="POST" action="cadastraContaView.jsp">

      <!-- Dados do cliente -->
      <label for="nome">Nome Completo:</label>
      <input type="text" id="nome" name="nome" required>

      <label for="cpf">CPF:</label>
      <input type="text" id="cpf" name="cpf" maxlength="14" placeholder="000.000.000-00" required>

      <label for="data_nascimento">Data de Nascimento:</label>
      <input type="date" id="data_nascimento" name="data_nascimento" required>

      <label for="telefone">Telefone:</label>
      <input type="text" id="telefone" name="telefone" placeholder="(00) 00000-0000" required>

      <label for="senha">Senha:</label>
      <input type="password" id="senha" name="senha" required>

      <label for="otp">Código OTP:</label>
      <input type="text" id="otp" name="otp" maxlength="6" required>

      <!-- Endereço -->
      <h3>Endereço</h3>

      <label for="cep">CEP:</label>
      <input type="text" id="cep" name="cep" required>

      <label for="local">Rua / Logradouro:</label>
      <input type="text" id="local" name="local" required>

      <label for="numero_casa">Número:</label>
      <input type="number" id="numero_casa" name="numero_casa" required>

      <label for="bairro">Bairro:</label>
      <input type="text" id="bairro" name="bairro" required>

      <label for="cidade">Cidade:</label>
      <input type="text" id="cidade" name="cidade" required>

      <label for="estado">Estado:</label>
      <input type="text" id="estado" name="estado" maxlength="2" placeholder="UF" required>

      <label for="complemento">Complemento:</label>
      <input type="text" id="complemento" name="complemento">

      <button type="submit">Cadastrar Cliente</button>
    </form>
  </div>

  <footer>
    &copy; 2025 Banco Malvader — Sistema de Gerenciamento Bancário Seguro
  </footer>

</body>
</html>
