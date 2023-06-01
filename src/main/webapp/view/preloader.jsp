<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="../img/system/favicon.ico" type="image/x-icon">
    <title>UNIHUB</title>
</head>
<style>

*{
    margin: 0;
    padding: 0;
    border: 0;
}

@keyframes opacity {
    0%{
        opacity: 0;
    }
    50%{
        opacity: 1;
    }
    100%{
        opacity: 0;
    }
}
@keyframes pulse {
    0%{
        transform: scale(0.8);
    }
    50%{
        transform: scale(1.3);
    }
    100%{
        transform: scale(0.8);
    }
}

body {
    background-color: #282729;
    display: flex;
    align-items: center;
    justify-content: center;
    width: 100%;
    height: 100vh;
    overflow: none;
}

.loader {
  width: 500px;
  height: 500px;
  position: relative;
  animation: pulse 2s infinite linear;

}

.image-top {
  width: 100%;
  height: 100%;
  position: absolute;
  animation: opacity 2s infinite linear;
}

.image-bottom {
  width: 100%;
  height: 100%;
  position: absolute;
}

</style>
<body>
    <div class="loader">
        <img class="image-bottom" src="../../img/system/logo-white.png">
        <img class="image-top" src="../../img/system/logo-emphasis.png">
      </div>
</body>
<script>
    window.addEventListener('load', () =>{
        setTimeout(function() {
            window.location.href = "../login?acao=ExibirTelaLogin";
        }, 6000);
    })
</script>
</html>