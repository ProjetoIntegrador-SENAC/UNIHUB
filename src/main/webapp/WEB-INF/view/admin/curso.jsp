<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10" style="height: 100vh;overflow-y: auto;">

     <a href="/admin?acao=ExibirTelaAdicionarCurso">
       <span class="material-icons mt-5 text-success bg-dark p-2">
           add
       </span>
       </a>

    <form class="mt-5" action="/admin?acao=ExibirTelaCurso" method="post">

        <select class="form-select" name="id" aria-label="Default select example">
          <option selected value="0">Selecione </option>
           <c:forEach items="${instituicoes}" var="instituicao">
          <option value="${instituicao.id}"> ${instituicao.nome} </option>
          </c:forEach>
        </select>

        <div class="mb-3 mt-2">
              <button type="submit" class="btn btn-primary mb-3"> Buscar </button>
        </div>
    <form>

    <c:if test="${fn:contains(message, 'sucesso')}">
        <h4 class="alert alert-success"> ${message} </h4>
    </c:if>

   <c:if test="${fn:contains(message, 'erro')}">
        <h4 class="alert alert-danger"> ${message} </h4>
   </c:if>

    <c:if test="${not empty instituicao_atual}">
        <h4> ${instituicao_atual.nome} </h4>
    </c:if>

    <c:if test="${not empty cursos}">

      <table class="table table-dark table-striped mt-2">
          <thead>
              <tr>
                  <th>NOME</th>
                  <th>TIPO</th>
                  <th>AREA</th>
                  <th> EDITAR </th>
                  <th> EXCLUIR </th>
              </tr>
          </thead>
          <tbody>
          <c:forEach items="${cursos}" var="curso">
          <tr>
              <td>${curso.nome}</td>
              <td>${curso.tipo}</td>
              <td>${curso.area}</td>
              <td>
              <a href="/admin?acao=ExibirTelaEditarCurso&id=${curso.id}">
              <span class="material-icons editar" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${curso.id}">
                  edit
              </span>
              </td>
              <td>
                  <a href="/admin?acao=ExcluirCurso&id=${curso.id}">
                  <span class="material-icons">
                      delete_forever
                  </span>
                  </a>
              </td>
          </tr>
         </c:forEach>
          </tbody>
      </table>
    </c:if>

</div>
</div>
<%@ include file="footer.jsp" %>