<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" rel="stylesheet">

    <!-- Tippy.js -->
    <link rel="stylesheet" href="https://unpkg.com/tippy.js@6/animations/scale.css" />
    <script src="https://unpkg.com/@popperjs/core@2"></script>
    <script src="https://unpkg.com/tippy.js@6"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="../../style/register.css">
    <link rel="stylesheet" href="../../style/toast.css">

    <!-- jQuery mask -->
    <script type="text/javascript" src="https://code.jquery.com./jquery-3.2.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js" defer></script>
    
    <!-- JAVASCRIPT -->
    <script src="../../js/register.js" defer></script>

    <link rel="shortcut icon" href="../../img/system/favicon.ico" type="image/x-icon">
    <title>UNIHUB</title>
</head>
<body onload="getInstituicoes()">
    <header class="logo">
        <a href="./login?acao=ExibirTelaLogin">
            <img src="../../img/system/logo-white.png" alt="">
        </a>
    </header>
    <main>
        <div class="cardRegister">
            <h1>Cadastre-se</h1>

            <form id="form" action="/conta?acao=CadastrarConta" method="post">

                <div class="fields field1">
                    <input type="text" name="nome" id="firstName" class="field" placeholder="Nome">
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field2">
                    <input type="text" name="sobrenome" id="lastName" class="field" placeholder="Sobrenome">
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field3">
                    <input type="date" name="data_nascimento" id="birth" class="field" max="2005-12-31">
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field4">
                    <select name="genero" id="gender" class="field">
                        <option value="0" selected disabled>Gênero</option>
                        <option value="Masculino">Masculino</option>
                        <option value="Feminino">Feminino</option>
                        <option value="Outros">Outros</option>
                    </select>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field5">
                    <input type="text" name="cpf" id="cpf" class="field" placeholder="000.000.000-00" onkeypress="onlynumber(), mask()">
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field6">
                    <select name="instituicao" id="instituicao" class="field">
                        <option value="0" selected disabled>Universidade</option>
                    </select>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field7">
                    <select name="curso" id="curso" class="field">
                        <option value="0" selected disabled>Curso</option>
                    </select>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field8">
                    <select name="shift" id="shift" class="field">
                        <option value="0" selected disabled>Turno</option>
                        <option value="matinal">Matinal</option>
                        <option value="noturno">Noturno</option>
                        <option value="integral">Integral</option>
                    </select>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field9">
                    <input type="number" name="year" id="year" class="field" placeholder="Ano início" min="2013" max="2023" step="1" onkeypress="mask()">
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field10">
                    <select name="semester" id="semester" class="field">
                        <option value="0" selected disabled>Semestre</option>
                        <option value="1">Primeiro</option>
                        <option value="2">Segundo</option>
                    </select>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field11">
                    <select name="turma_id" id="turma_id" class="field"> // TODO: verificar se vai usar ou não(se sim, criar js)
                        <option value="0" selected disabled>Turma</option>
                        <option value="A">A</option>
                        <option value="B">B</option>
                        <option value="C">C</option>
                        <option value="D">D</option>
                    </select>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field12">
                    <input type="email" name="email" id="email" class="field" placeholder="E-mail">
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field13">
                    <input type="password" name="senha" id="password" class="field tooltip"placeholder="Senha">
                    <span class="toggle-password icon material-symbols-outlined">visibility_off</span>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="fields field14">
                    <input type="password" name="passwordConfirmation" id="passwordConfirmation" class="field tooltip"placeholder="Confirmar senha">
                    <span class="toggle-password icon material-symbols-outlined">visibility_off</span>
                    <span class="error material-icons-round">error</span>
                    <span class="success material-icons-round">check_circle</span>
                </div>

                <div class="btn">
                    <button type="submit" class="btnRegister">CADASTRAR</button>
                </div>
            </form>
        </div>
    </main>
    <footer>
        <p>&copy; UNIHUB. Todos os direitos reservados.</p>
    </footer>
    <div id="toast">
        <div id="img" class="material-symbols-outlined">error</div>
        <div id="desc">Verifique os campos com erro!</div>
    </div>
</body>
<script>
    // Inicializar tooltips
    tippy('.tooltip', {
        content: 'A senha deve ter pelo menos 8 caracteres.',
        placement: 'bottom', // Altere a posição do tooltip conforme necessário
        arrow: false, // Desativar seta do tooltip
        allowHTML: true, // Permitir conteúdo HTML no tooltip
        trigger: 'focus',
        duration: 1000,
        animation: 'scale'
    });
</script>
</html>