<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-10">
<table class="table table-dark table-striped mt-5">
    <thead>
        <tr>
            <th>CPF</th>
            <th>NOME</th>
            <th>NASCIMENTO</th>
            <th> GENERO </th>
            <th> MAIS DETALHES </th>
            <th> EDITAR </th>
            <th> EXCLUIR </th>

        </tr>
    </thead>
    <tbody>
    <c:forEach items="${contas}" var="conta">
    <tr>
            <td>${conta.cpf }</td>
            <td>${conta.nome }</td>
            <td>${conta.data_nascimento }</td>
            <td>${conta.genero}</td>
            <td>
                <!-- Button trigger modal -->
                <span class="material-icons">
                    more
                </span>

            </td>
            <td>
            <a href="/admin?acao=ExibirTelaEditarConta&id=${conta.id}">
            <span class="material-icons editar" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${conta.id}">
                edit
            </span>
            </td>
            <td>
                <a href="/admin?acao=ExcluirConta&id=${conta.id}">
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
                <label for="f_cpf" class="form-label"> CPF </label>
                <input type="email" class="form-control" id="f_cpf" placeholder="">
            </div>
            <div class="col-4">
                <label for="f_nome" class="form-label"> Nome </label>
                <input type="email" class="form-control" id="f_nome" placeholder="name@example.com">
            </div>
             <div class="col-4">
                <label for="f_nascimento" class="form-label">Data de Nascimento </label>
                <input type="date" class="form-control" id="f_nascimento" placeholder="">
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-4">
                <label for="f_genero" class="form-label"> Genero </label>
                <select class="form-select" aria-label="Default select example" id="f_genero">
                  <option selected>  </option>
                </select>
            </div>

             <div class="col-8">
                <label for="f_instituicoes" class="form-label"> Instituicao </label>
                <select class="form-select" aria-label="Default select example" id="f_instituicoes">
                  <option selected>  </option>
                </select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-4">
                <label for="f_curso" class="form-label"> Curso </label>
                <select class="form-select" aria-label="Default select example" id="f_curso">
                </select>
            </div>

            <div class="col-4">
                <label for="f_ano_inicio" class="form-label"> Ano inicio </label>
                <select class="form-select" aria-label="Default select example" id="f_ano_inicio">

                </select>
            </div>

            <div class="col-4">
                <label for="f_semestre" class="form-label"> Semestre  </label>
                <select class="form-select" aria-label="Default select example" id="f_semestre">
                </select>
            </div>
        </div>
      <div class="row mt-3">
          <div class="col-4">
              <label for="f_turno" class="form-label"> Turno </label>
              <select class="form-select" aria-label="Default select example" id="f_turno">
              </select>
          </div>
          <div class="col-4">
              <label for="f_turma" class="form-label"> Turma </label>
              <select class="form-select" aria-label="Default select example" id="f_turma">
              </select>
          </div>
      </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"> Fechar </button>
        <button type="button" class="btn btn-primary"> Salvar </button>
      </div>
    </div>
  </div>
</div>

</body>
<script src="./js/admin.js" defer></script>

</html>