<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>

<div class="col-10">
<form class="mt-5" action="/admin?acao=AdicionarCurso" method="post">

    <div class="mb-3">
        <select class="form-select" name="instituicao_id" aria-label="Default select example">
          <option selected>Selecione a instituição</option>
          <c:forEach items="${instituicoes}" var="instituicao">
            <option value="${instituicao.id}"> ${instituicao.nome} </option>
          </c:forEach>
        </select>
        </div>

    <div class="mb-3">
      <label for="nome" class="form-label"> Nome </label>
      <input type="text" class="form-control" id="nome" name="nome">
    </div>

    <div class="mb-3">
    <select class="form-select" name="tipo" aria-label="Default select example">
      <option selected>Selecione o tipo de graduação</option>
      <option value="TENOLOGO">TECNÓLOGO</option>
      <option value="BACHARELADO">BACHARELADO</option>
    </select>
    </div>

    <div class="mb-3">
     <select class="form-select" name="area" aria-label="Default select example" required>
       <option selected> Selecione a área </option>
       <option value="'TECNOLOGIA DA INFORMACAO'">'TECNOLOGIA DA INFORMACAO'</option>
       <option value="GESTAO E NEGOCIOS">GESTAO E NEGOCIOS</option>
       <option value="FINANCAS">FINANCAS</option>
       <option value="CIENCIAS DA SAUDE">CIENCIAS DA SAUDE</option>
       <option value="CIENCIAS EXATAS">CIENCIAS EXATAS</option>
       <option value="CIENCIAS DA NATUREZA">CIENCIAS DA NATUREZA</option>
       <option value="ARTES">ARTES</option>
     </select>
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
    window.location.href = "/admin?acao=ExibirTelaCurso";
  }
</script>
<%@ include file="footer.jsp" %>