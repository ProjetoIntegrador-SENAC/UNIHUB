<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-10">
  <c:if test="${fn:contains(message, 'sucesso')}">
    <h4 class="text-success"> ${message} </h4>
  </c:if>

  <c:if test="${fn:contains(message, 'erro')}">
    <h4 class="text-danger"> ${message} </h4>
  </c:if>

  <a href="/admin?acao=ExibirTelaAdicionarUsuario">
<span class="material-icons mt-5 text-success bg-dark p-2">
    add
</span>
  </a>
  <table class="table table-dark table-striped mt-2">
    <thead>
    <tr>
      <th>EMAIL</th>
      <th>SENHA</th>
      <th>PAPEL</th>
      <th> EDITAR </th>
      <th> EXCLUIR </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${usuarios}" var="usuario">
      <tr>
        <td>${usuario.email}</td>
        <td>${usuario.senha}</td>
        <td>${usuario.papel}</td>
        <td>
          <a href="/admin?acao=ExibirTelaEditarUsuario&id=${usuario.id}">
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
</div>
<%@ include file="footer.jsp" %>