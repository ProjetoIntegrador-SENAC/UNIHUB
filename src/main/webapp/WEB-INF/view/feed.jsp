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
    <link rel="stylesheet" href="../../style/feed.css">
    <link rel="stylesheet" href="../../style/modal.css">

    <script src="../../js/theme.js" defer></script>
    <script src="../../js/feed.js" defer></script>
    <script src="../../js/modal.js" defer></script>

    <link rel="shortcut icon" href="../../img/system/favicon.ico" type="image/x-icon">
    <title>UNIHUB</title>
</head>
<body>
    <main>
        <!-- HEADER -->
        <header>
            <div class="logo">
                <a href="/conta?acao=ExibirFeed">
                    <img src="../../img/system/logo-white.png">
                </a>
            </div>
        </header>
        <!-- POST's -->
        <div class="container">
            <c:forEach items="${postagens}" var="postagem">
                <div class="post">
                    <div class="userPost">
                        <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${postagem.conta.foto}">
                        <h6>${postagem.conta.nome}</h6>
                    </div>
                    <div class="img">
                        <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${postagem.foto}">
                    </div>
                    <div class="legend">
                        <textarea class="textLegend" disabled>${postagem.conteudo}</textarea>
                        <button class="btnlegend">
                            <span class="material-symbols-outlined arrow" data-arrow="down-arrow">
                                arrow_drop_down
                            </span>
                        </button>
                    </div>
                    <div class="interactions">
                        <button class="btnFavorite">
                            <span class="icon material-symbols-outlined favorite" data-like="dislike">favorite</span>
                        </button>
                        <button class="btnComment">
                            <span class="icon material-symbols-outlined comment" data-comment="closed">Comment</span>
                        </button>
                        <button class="btnShare">
                            <span class="icon material-symbols-outlined share" data-share="closed">share</span>
                        </button>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- BTN ADD POST -->
        <nav>
            <span class="icon material-symbols-outlined">
                add_box
            </span>
        </nav>
        <div id="chatContainer"></div>
    </main>
    <aside>
        <section class="profile">
            <div class="user">
                <img id="imageProfile" src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${usuariologado.foto}"> <!-- TODO:Adicionar foto usuario -->
            </div>
            <div class="config">
                <span id="btnTheme" data-theme="dark" class="icon material-symbols-outlined">
                    dark_mode
                </span>
                <a class="exit" href="login?acao=Deslogar">
                    <span class="icon material-symbols-outlined">
                        logout
                    </span>
                </a>
            </div>
        </section>
        <section class="container">
            <div class="search">
                <input type="search" name="" id="">
                <span class="icon material-symbols-outlined">
                    search
                </span>
            </div>
            <div class="friends">
                <c:forEach items="${contas}" var="conta">
                <div class="friend">
                    <span data-set="${conta.id}" class="chatFrame">
                        <img src="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}/${conta.foto}"> <!-- TODO:Adicionar foto friend -->
                        <h4>${conta.nome}</h4>
                    </span>
                </div>
                </c:forEach>
            </div>
        </section>
    </aside>
    <div id="modal-overlay">
        <div id="modal" class="modal-content">
            <h2>Postagem</h2>
            <img id="preview-image">
            <form action="/foto" method="post" enctype="multipart/form-data" id="modal-form">
                <div id="img">
                    <label for="file" class="custom-file-label">Escolher imagem</label>
                    <input type="file" name="file" id="file" capture="user" required>
                </div>
                <textarea id="caption-input" name="legenda" placeholder="Digite a legenda" required></textarea>
                <div class="btnModal">
                    <button id="btnCancelar">Cancelar</button>
                    <button type="submit">Enviar</button>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
var conta = document.querySelectorAll('.chatFrame')

conta.forEach((e) => {
    e.addEventListener('click', function(e){
        chatContainer.innerHTML = ''
        id = e.currentTarget.getAttribute('data-set')
        console.log(id);
        var iframe = document.createElement("iframe");
        var stringIframe = 'http://localhost:8080/conta?acao=ExibirChat&id_conta_destino='+id;
        console.log(stringIframe)
        iframe.src = stringIframe
        console.log(iframe.src)
        iframe.style.width = "100%";
        iframe.style.height = "500px";
        iframe.style.border = "none";

        chatContainer.appendChild(iframe);

    })
})


</script>
</html>