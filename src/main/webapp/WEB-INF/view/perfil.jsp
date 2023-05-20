<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0..1,0" />
    
    <link rel="stylesheet" href="./style/perfil.css">
    <script src="./js/perfil.js" defer></script>
    
    <link rel="shortcut icon" href="./img/favicon.ico" type="image/x-icon">
    <title>UNIHUB</title>
</head>
<body>
    <header>
        <div class="headerTop">
            <div class="logo">
                <img src="./img/logo-white.png">
            </div>
            <div class="config">
                <span class="icon material-symbols-outlined">
                    settings
                </span>
                <a href="/conta?acao=ExibirFeed">
                    <span class="icon material-symbols-outlined">
                        disabled_by_default
                    </span>
                </a>
            </div>
        </div>
        <div class="profile">
            <div class="user">
                <img src="./img/user.png"> <!-- Adicionar Foto user -->
            </div>
            <div class="titles">
                <div class="nameUser">
                    <h1> ${conta.nome_conta} ${conta.sobrenome} </h1> <!-- Adicionar nome user -->
                </div>
                <div class="courseUser">
                    <h2>${conta.curso_nome}</h2> <!-- Adicionar curso user -->
                </div>
            </div>
        </div>
    </header>
    <main>
        <div class="container">
            <c:forEach items="${postagens}" var="postagem">
                ${postagem.foto}
                ${postagem.conteudo}
                <div class="post">
                    <span class="icon material-symbols-outlined">
                        delete
                    </span>
                    <img src="./img/background-register.jpg" alt="">
                </div>
            </c:forEach>
        </div>
    </main>
</body>
</html>