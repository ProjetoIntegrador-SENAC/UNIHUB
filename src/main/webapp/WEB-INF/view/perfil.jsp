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
    <script src="./js/modalPerfil.js" defer></script>
    
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
                <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${conta.cd_foto}"> <!-- TODO: Adicionar Foto user -->
                <div id="edit-img">
                    <span class="btnPhoto material-symbols-outlined">edit</span>
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
                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${postagem.foto}">
                </div>
            </c:forEach>
        </div>
    </main>
    <!-- Modal Edit Photo Perfil -->
    <div id="modal-overlay">
        <div id="modal" class="modal-content">
            <h2>Foto De Perfil</h2>
            <img id="preview-image">
            <form action="/fotoperfil" method="post" enctype="multipart/form-data"> <!--TODO: É só adicionar o action do form não precisa mexer em mais nada-->
                <div id="img">
                    <label for="filePerfil" class="custom-file-label">Escolher imagem</label>
                    <input type="file" name="filePerfil" id="filePerfil" capture="user" required>
                </div>
                <div class="btnModal">
                    <button id="btnCancelar">Cancelar</button>
                    <button type="submit">Enviar</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>