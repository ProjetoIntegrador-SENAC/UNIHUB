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

    <link rel="stylesheet" href="../../style/root.css">
    <link rel="stylesheet" href="../../style/allFriends.css">

    <script src="../../js/theme.js" defer></script>
    <script src="../../js/allFriends.js" defer></script>
    
    <link rel="shortcut icon" href="../../img/system/favicon.ico" type="image/x-icon">
    <title>UNIHUB</title>
</head>
<body>
    <header>
        <div class="headerTop">
            <div class="logo">
                <a href="/conta?acao=ExibirFeed">
                    <img src="../../img/system/logo-white.png">
                </a>
            </div>
            <div class="config">
                <span id="btnTheme" data-theme="dark" class="icon material-symbols-outlined">
                    dark_mode
                </span>
                <span id="btnFriendsAll" class="icon material-symbols-outlined">
                    contacts
                </span>
                <a href="/conta?acao=ExibirFeed">
                    <span class="icon material-symbols-outlined">
                        disabled_by_default
                    </span>
                </a>
            </div>
        </div>
    </header>
    <main>
        <div class="search">
            <input type="search">
            <span class="icon material-symbols-outlined">
                search
            </span>
        </div>
        <h1>Turma</h1>
        <div class="container">
            <c:forEach items="${contas}" var="conta">
                <div class="friend" data-set="${conta.id}">
                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${conta.foto}">
                    <p>${conta.nome}</p>
                </div>
            </c:forEach>
        </div>
        <h1>Curso</h1>
        <div class="container">
            <c:forEach items="${contas}" var="conta">
                <div class="friend" data-set="${conta.id}">
                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${conta.foto}">
                    <p>${conta.nome}</p>
                </div>
            </c:forEach>
        </div>
        <h1>Instituição</h1>
        <div class="container">
            <c:forEach items="${contas}" var="conta">
                <div class="friend" data-set="${conta.id}">
                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${conta.foto}">
                    <p>${conta.nome}</p>
                </div>
            </c:forEach>
        </div>
        <h1>Outros</h1>
        <div class="container">
            <c:forEach items="${contas}" var="conta">
                <div class="friend" data-set="${conta.id}">
                    <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${conta.foto}">
                    <p>${conta.nome}</p>
                </div>
            </c:forEach>
        </div>
    </main>
</body>
</html>