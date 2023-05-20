<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">

<form class="mt-5" action="/admin?acao=EditarInstituicao" method="post">
    <div class="mb-3">
      <label for="nome" class="form-label"> Nome </label>
      <input type="text" class="form-control" id="nome" name="nome" value="${instituicao.nome}">
    </div>

    <div class="mb-3">
           <input type="text" name="id" class="form-control d-none" id="exampleFormControlInput1" placeholder="name@example.com" value="${instituicao.id}">
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
    window.location.href = "/admin?acao=ExibirTelaInstituicao";
  }
</script>
<%@ include file="footer.jsp" %>