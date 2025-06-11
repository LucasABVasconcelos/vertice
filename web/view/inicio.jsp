<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Menu do Funcionário - Banco Malvader</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      font-family: 'Segoe UI', sans-serif;
      background-color: #f0f4f8;
      color: #ffffff;
      display: flex;
      flex-direction: column;
      min-height: 100vh;
    }

    menun {
      font-family: Arial, sans-serif;
      background-color: #f0f4f8;
      margin: 0;
      padding: 0;
    }

    /* Estilo do cabeçalho */
    header {
      background-color: #F6A122;  /* Fundo laranja */
      padding: 20px;
      display: flex;
      align-items: center;
      justify-content: center;
      color: white;
      width: 100%;  /* Garantir que o header ocupe toda a largura */
      position: sticky;
      top: 0;
      z-index: 1;  /* Garante que o cabeçalho fique por cima do conteúdo */
    }

    header img {
      height: 50px;  /* Tamanho da logo */
      margin-right: 15px;  /* Espaçamento entre a logo e outros elementos */
    }

    .container {
      background-color: #ffffff;
      padding: 40px;
      border-radius: 10px;
      box-shadow: 0 0 30px rgba(0,0,0,0.3);
      width: 480px;
      text-align: center;  /* Centraliza o conteúdo dentro da .container */
      margin-top: 80px;  /* Garante que o conteúdo fique abaixo do cabeçalho */
      margin-left: auto;
      margin-right: auto; /* Centraliza a .container na tela */
    }

    h1 {
      margin-bottom: 30px;
      color: #362102;
    }

    .menu-link {
      display: block;
      width: 100%;
      padding: 12px;
      margin: 10px 0;
      font-size: 16px;
      color: #ffffff;
      background-color: #D88509;
      text-decoration: none;
      border-radius: 6px;
      transition: background-color 0.3s ease;
      text-align: center; /* Garante que os links fiquem centralizados */
    }

    .menu-link:hover {
      color: #ffffff;
      background-color: #F6A122;
    }

    .menu-link.sair {
      background-color: #190F01;
    }

    .menu-link.sair:hover {
      background-color: #190F01;
    }
  </style>
</head>
<body>

  <!-- Cabeçalho com logo fixo no topo -->
  <header class="menun">
    <img src="../logo_n.png" alt="Logo Banco Malvader">
  </header>

  <!-- Conteúdo principal da página -->
  <div class="container">
    <h1>Bem-vindo!</h1>

    <!-- Botões do menu -->
    <a href="formCadastroConta.jsp" class="menu-link">Abertura de Conta</a>
    <a href="/encerrar-conta" class="menu-link">Encerramento de Conta</a>
    <a href="/consultas" class="menu-link">Consulta de Dados</a>
    <a href="/alteracoes" class="menu-link">Alteração de Dados</a>
    <a href="/cadastro-funcionario" class="menu-link">Cadastro de Funcionários</a>
    <a href="/relatorios" class="menu-link">Geração de Relatórios</a>

    <!-- Botão "Sair", redirecionando para a tela de login -->
    <a href="index.jsp" class="menu-link sair">Sair</a>
  </div>

</body>
</html>
