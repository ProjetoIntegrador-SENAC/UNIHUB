<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26/05/2023
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-10">
  <table class="table table-dark table-striped mt-5">
    <thead>
    <tr>
      <th>Email</th>
      <th>Senha</th>
      <th>Papel</th>
      <th>Mais Detalhes</th>
      <th>Editar</th>
      <th>Excluir</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.email}</td>
        <td>${usuario.senha}</td>
        <td>${usuario.papel}</td>
        <td>
          <!-- Button trigger modal -->
          <span class="material-icons">
              more
          </span>
        </td>
        <td>
          <span class="material-icons editar" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${usuario.id}">
              edit
          </span>
        </td>
        <td>
          <a href="/admin?acao=ExcluirUsuario&id=${usuario.id}">
            <span class="material-icons">
                delete_forever
            </span>
          </a>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-xl">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">
          EDITAR
        </h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <div class="row">
          <div class="col-4">
            <label for="f_email" class="form-label">Email</label>
            <input type="email" class="form-control" id="f_email" placeholder="">
          </div>
          <div class="col-4">
            <label for="f_senha" class="form-label">Senha</label>
            <input type="password" class="form-control" id="f_senha" placeholder="">
          </div>
          <div class="col-4">
            <label for="f_papel" class="form-label">Papel</label>
            <input type="text" class="form-control" id="f_papel" placeholder="">
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        <button type="button" class="btn btn-primary">Salvar</button>
      </div>
    </div>
  </div>
</div>

<script src="./js/admin.js" defer></script>

</html>

