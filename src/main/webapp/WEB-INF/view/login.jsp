<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="../../style/login.css">
    <link rel="stylesheet" href="../../style/modalLogin.css">
    <link rel="stylesheet" href="../../style/toast.css">

    <script src="../../js/login.js" defer></script>
    <script src="../../js/modalLogin.js" defer></script>

    <link rel="shortcut icon" href="../../img/favicon.ico" type="image/x-icon">
    <title>UNIHUB</title>
</head>

<body>
    <header class="logo">
        <a href="./login?acao=ExibirTelaLogin">
            <img src="../../img/logo-white.png">
        </a>
    </header>
    <main class="login">
        <section class="left">
            <h1>
                Seja bem vindo a UNIHUB
                <img src="../../img/logo-small-white.png">
            </h1>
            <div class="cardLeft">
                <h4>Somos uma rede social focada em universitários...</h4>
                <button id="singUp">Inscreva-se</button>
            </div>
        </section>
        <section class="right">
            <div class="cardRight">
                <form id="form-login" action="login?acao=Logar" method="post">
                    <h2>LOGIN</h2>
                    <div class="inputs">
                        <span class="icon material-symbols-outlined">
                            person
                        </span>
                        <input type="text" name="email" id="user" placeholder="Digite seu e-mail">
                    </div>
                    <div class="inputs">
                        <span class="icon material-symbols-outlined">
                            lock
                        </span>
                        <input type="password" name="senha" id="password" placeholder="Digite sua senha">
                        <span class="toggle-password icon material-symbols-outlined">visibility_off</span>
                    </div>
                    <button type="submit" class="btnLogin">LOGAR</button>
                    <span>
                        <p id="recuperar">
                            Esqueceu a sua senha?
                        </p>
                    </span>
                </form>
            </div>
        </section>
        <!-- Modal -->
        <div id="modal-overlay">
            <div id="modal" class="modal-content">
                <h2>Recuperação de senha</h2>
                <p id="msgError">Credenciais inválidas!</p>
                <form action="/recupera-senha" method="post" id="modal-form">
                    <input type="text" id="nomeUser" name="nomeUser" placeholder="Nome completo" required>
                    <input  type="text" id="emailUser" name="emailUser" placeholder="E-mail cadastrado" required>
                    <div class="btnModal">
                        <button id="btnCancelar">Cancelar</button>
                        <button type="submit">Enviar</button>
                    </div>
                </form>
            </div>
        </div>
    </main>
    <footer>
        <p>&copy; UNIHUB. Todos os direitos reservados.</p>
    </footer>
    <!-- Toast -->
    <div id="toast">
        <div id="img" class="material-symbols-outlined">error</div>
        <div id="desc">Email e/ou senha inválidos!</div>
    </div>
</body>
</html>