<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">

<a href="/admin?acao=ExibirTelaAdicionarInstituicao">
<span class="material-icons mt-5 text-success bg-dark p-2">
    add
</span>
</a>

<table class="table table-dark table-striped mt-2">
    <thead>
        <tr>
            <th>NOME</th>
            <th> EDITAR </th>
            <th> EXCLUIR </th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${instituicoes}" var="instituicao">
    <tr>
            <td>${instituicao.nome}</td>
            <td>
            <a href="/admin?acao=ExibirTelaEditarInstituicao&id=${instituicao.id}">
            <span class="material-icons editar" data-bs-toggle="modal" data-bs-target="#exampleModal" data-id="${instituicao.id}">
                edit
            </span>
            </td>
            <td>
                <a href="/admin?acao=ExcluirInstituicao&id=${instituicao.id}">
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
