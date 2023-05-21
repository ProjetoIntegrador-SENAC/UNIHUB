<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="./style/modalPerfil.css">
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
                <img src="./img/user.png"> <!-- TODO: Adicionar Foto user -->
                <div id="edit-img">
                    <label for="file-imgUser" class="custom-file-imgUser-label material-symbols-outlined">edit</label>
                    <input type="file" name="file-imgUser" id="file-imgUser" capture="user" required>
                </div>
            </div>
            <div class="titles">
                <div class="nameUser">
                    <h1> ${conta.nome_conta} ${conta.sobrenome} </h1>
                </div>
                <div class="courseUser">
                    <h2>${conta.curso_nome}</h2>
                </div>
            </div>
        </div>
    </header>
    <main>
        <div class="container">
            <c:forEach items="${postagens}" var="postagem">
                <div class="post">
                    <span id="btnDelet" class="icon material-symbols-outlined">
                        delete
                    </span>
                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${postagem.foto}" alt=""> <!--TODO:Adicionar foto postagem-->
                </div>
            </c:forEach>
        </div>
    </main>
</body>
</html>