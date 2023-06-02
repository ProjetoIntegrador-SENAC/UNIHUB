<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/05/2023
  Time: 02:59
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">

  <form class="mt-5" action="/admin?acao=AdicionarUsuario" method="post">
    <div class="mb-3">
      <label for="email" class="form-label"> Email </label>
      <input type="text" class="form-control" id="email" name="email" placeholder="Email do usuário" required>
      <label for="senha" class="form-label"> Senha </label>
      <input type="text" class="form-control" id="senha" name="senha" placeholder="Senha do usuário" required>
      <label for="papel" class="form-label"> Papel </label>
      <input type="text" class="form-control" id="papel" name="papel" placeholder="Papel do usuário" required>
    </div>

    <div class="mb-3">
      <button type="submit" class="btn btn-primary mb-3"> Confirmar</button>
      <button type="button" class="btn btn-danger mb-3" onclick="cancelar()"> Cancelar </button>
    </div>
    <form>
</div>
</div>
<script>
  function cancelar() {
    window.location.href = "/admin?acao=ExibirTelaUsuario";
  }
</script>
<%@ include file="footer.jsp" %>
