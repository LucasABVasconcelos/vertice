<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Banco Malvader - Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #F6A122;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .container {
      background-color: #ffffff;
      border-radius: 10px;
      padding: 30px;
      width: 350px;
      box-shadow: 0px 0px 12px rgba(0, 0, 0, 0.1);
    }

    label {
      display: block;
      margin-top: 15px;
      font-weight: bold;
    }

    /* Adicionando box-sizing para corrigir o padding */
    input, select {
      background-color: white;
      padding: 8px;
      margin-top: 5px;
      border: 1px solid #F6A122;
      border-radius: 5px;
      width: 100%;
      box-sizing: border-box; /* Garante que o padding não ultrapasse a largura */
    }

    .buttons {
      display: flex;
      justify-content: space-between;
      margin-top: 20px;
    }

    button {
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      color: white;
      cursor: pointer;
      width: 48%;
      transition: background-color 0.3s ease; /* Efeito de transição */
    }

    /* Cor do botão Entrar */
    .login-btn {
      background-color: #D88509; /* Cor padrão do botão */
    }

    .login-btn:hover {
      background-color: #F6A122; /* Cor ao passar o mouse (hover) */
    }

    /* Cor do botão Sair */
    .exit-btn {
      background-color: #190F01;
    }

    .logo-container {
      text-align: center;
      margin-bottom: 20px;
    }

  </style>
</head>
<body>

<div class="container">
  <div class="logo-container">
    <img src="logo.png" alt="Logo Banco Malvader" width="120">
  </div>

  <form method="POST" action="view/inicio.jsp">
    <label for="cpf">CPF:</label>
    <input type="text" id="cpf" name="cpf" placeholder="000.000.000-00" required>

    <label for="senha">Senha:</label>
    <input type="password" id="senha" name="senha" required>

    <div class="buttons">
      <!-- Botão 'Sair' à esquerda -->
      <button type="button" class="exit-btn" onclick="window.close()">Sair</button>
      <!-- Botão 'Entrar' à direita, com funcionalidade de envio -->
      <button type="submit" class="login-btn">Entrar</button>
    </div>
  </form>
</div>

</body>
</html>
