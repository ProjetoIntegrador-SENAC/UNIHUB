<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 31/05/2023
  Time: 02:56
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">

  <form class="mt-5" action="/admin?acao=EditarUsuario" method="post">
    <div class="mb-3">
      <label for="email" class="form-label"> Email </label>
      <input type="text" class="form-control" id="email" name="email" value="${usuario.email}">
      <label for="senha" class="form-label"> Senha </label>
      <input type="text" class="form-control" id="senha" name="senha" value="${usuario.senha}">
      <label for="papel" class="form-label"> Papel </label>
      <input type="text" class="form-control" id="papel" name="papel" value="${usuario.papel}">
    </div>

    <div class="mb-3">
      <input type="text" name="id" class="form-control d-none" id="exampleFormControlInput1" placeholder="name@example.com" value="${usuario.id}">
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