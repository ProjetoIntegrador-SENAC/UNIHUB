<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">

<form class="mt-5" action="/admin?acao=ExibirTelaTurma" method="post">
    <div class="mb-3 mt-2">
        <select class="form-select" name="instituicao_id" id="instituicao_turma" aria-label="Default select example">
          <option selected value="0">Selecione </option>
           <c:forEach items="${instituicoes}" var="instituicao">
          <option value="${instituicao.id}"> ${instituicao.nome} </option>
          </c:forEach>
        </select>
    </div>

    <div class="mb-3 mt-2">
        <select class="form-select" name="curso_id" aria-label="Default select example" id="turmas_select">
          <option selected value="0">Selecione </option>
        </select>
    </div>

    <div class="mb-3 mt-2">
          <button type="submit" class="btn btn-primary mb-3"> Buscar </button>
    </div>
<form>

<c:if test="${fn:contains(message, 'sucesso')}">
    <h4 class="text-success"> ${message} </h4>
</c:if>

<c:if test="${fn:contains(message, 'erro')}">
    <h4 class="text-danger"> ${message} </h4>
</c:if>

<c:if test="${not empty turmas}">

<c:forEach items="${turmas}" var="turma">
    <div class="card" style="width: 18rem;">
    <div class="card-body">
    <div class="d-flex flex-row">
        <h5 class="w-50"> Turma </h5>
        <h5 class="w-50"> ${turma.letra}</h5>
    </div>
    <div class="d-flex flex-row">
        <h5 class="w-50"> Data Início </h5>
        <h5 class="w-50"> ${turma.data_inicio}</h5>
    </div>
    <div class="d-flex flex-row">
        <h5 class="w-50"> Turno </h5>
        <h5 class="w-50"> ${turma.turno}</h5>
    </div>
      <a href="#" class="btn btn-primary mt-2">Mais detalhes</a>
    </div>
    </div>
</c:forEach>
</c:if>


<script>
function getCursos(id){
    return fetch("http://localhost:8080/api_cursos?instituicao_id="+id)
        .then(response => response.json())
        .then(data => {
            return data
        })
}

let element = document.getElementById("instituicao_turma")

element.addEventListener("change", function(){
  console.log('cheguei')
  id = document.getElementById('instituicao_turma').value
  console.log(id)
  getCursos(id).then(dados => {
    dados.forEach(dado => {
              console.log(dado)
              option = document.createElement("option")
              option.id = dado['id'];
              option.value = dado['id'];
              option.textContent = dado['nome'];
              document.getElementById('turmas_select').appendChild(option)
    })
  })
})

</script>
</div>
</div>
<%@ include file="footer.jsp" %>