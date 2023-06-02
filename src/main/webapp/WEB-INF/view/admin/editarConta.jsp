<%@ page import="br.com.projetopi.redesocial.model.Conta" %>
<%@ page import="br.com.projetopi.redesocial.dao.InstituicaoDao" %>
<%@ page import="br.com.projetopi.redesocial.service.InstituicaoService" %>
<%@ page import="br.com.projetopi.redesocial.model.Instituicao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.projetopi.redesocial.dao.TurmaDao" %>
<%@ page import="br.com.projetopi.redesocial.model.Turma" %>
<%@ page import="br.com.projetopi.redesocial.model.Curso" %>
<%@ page import="br.com.projetopi.redesocial.dao.CursoDao" %>
<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">

    <form class="mt-5" action="/admin?acao=EditarConta" method="post">
        <div class="mb-3">
            <label for="nome" class="form-label"> Nome </label>
            <input type="text" class="form-control" id="nome" name="nome" value="${conta.nome}"><br>

            <label for="sobrenome" class="form-label"> Sobrenome </label>
            <input type="text" class="form-control" id="sobrenome" name="sobrenome" value="${conta.sobrenome}"><br>

            <label for="cpf" class="form-label"> CPF </label>
            <input type="text" class="form-control" id="cpf" name="cpf" value="${conta.cpf}"><br>

            <label for="genero" class="form-label"> Genero </label><br>
            <select name="genero" id="genero" class="field">
                <option value="${conta.genero}" selected>${conta.genero}</option>

                <%
                    Conta conta = (Conta) request.getAttribute("conta");

                    if (conta.getGenero().equalsIgnoreCase("masculino")) {
                %>
                <option value="Feminino">Feminino</option>
                <%} else {%>
                <option value="Masculino">Masculino</option>
                <%}%>
            </select><br><br>

            <% ArrayList<Instituicao> instituicoes = new InstituicaoService().getInstituicaoAll(50, 0); %>

            <label for="datanascimento" class="form-label"> Data de nascimento </label><br>
            <input type="date" name="data_nascimento" id="datanascimento" class="field" max="2005-12-31"
                   value="${conta.data_nascimento}"><br>

            <br><label for="instituicao" class="form-label"> Instituição </label><br>
            <select name="instituicao" id="instituicao" class="fiegfld">
                <% Instituicao instituicao1 = new InstituicaoService().getInstituicaoById(conta.getInstituiacao_id());%>
                <option value="<%=instituicao1.getId()%>" selected><%=instituicao1.getNome()%>
                </option>
                <%
                    for (Instituicao instituicao : instituicoes) {
                        if (instituicao.getNome() != instituicao1.getNome()) {
                %>
                <option value="<%=instituicao.getId()%>"><%=instituicao.getNome()%>
                </option>
                <%
                        }
                    }
                %>

                <%
                    Turma turma = new TurmaDao().findById(conta.getTurma_id());
                    ArrayList<Turma> turmas = new TurmaDao().findAllPageable(50, 0);
                %>

            </select>



                <%String instituicaoid = request.getParameter("instituicao");%>
            <br><label for="curso" class="form-label"> Curso </label><br>
            <select name="curso" id="curso" class="fiegfld">
<%--                <option value="<%=instituicao1.getId()%>" selected><%=instituicao1.getNome()%>--%>
                </option>
                <%if (instituicaoid != null){
                    ArrayList<Curso> cursosByInstituicaoId = new CursoDao().getCursosByInstituicaoId(Integer.parseInt(instituicaoid));
                    for (Curso curso:cursosByInstituicaoId) {
                        %>
                <option value="<%=curso.getId()%>" selected><%=curso.getNome()%>
                <%
                    }
                }%>

<%--                <%System.out.println(instituicaoid);%>--%>


            </select>

            <input type="text" name="nome" id="nome" style="display: none;" value="<>"><br><br>

            <label for="turma" class="form-label"> Turma </label><br>
            <select name="turma" id="turma">
                <option value="<%=turma.getId()%>" selected><%=turma.getLetra()%>
                </option>
                <% for (Turma t : turmas) {
                    if (t.getLetra() != turma.getLetra()) {
                %>
                <option value="<%=t.getId()%>"><%=t.getLetra()%></option>
                <%
                        }
                    }
                %>
            </select>

        </div>

        <div class="mb-3">
            <input type="text" name="id" class="form-control d-none" id="exampleFormControlInput1"
                   placeholder="name@example.com" value="${conta.id}">
        </div>

        <div class="mb-3">
            <button type="submit" class="btn btn-primary mb-3"> Confirmar</button>
            <button type="button" class="btn btn-danger mb-3" onclick="cancelar()"> Cancelar</button>
        </div>
    </form>


    <script>
        // Captura o campo select pelo ID
        var campoSelect = document.getElementById("instituicao");
        var result = document.getElementById("resultteste");
        var opcaoselecionada = campoSelect.value;

        result.textContent = "Testando uns negocio: "+opcaoselecionada;

    </script>

    <p id="resultteste"></p>

</div>
</div>

<script>
    function cancelar() {
        window.location.href = "/admin?acao=ExibirTelaConta";
    }
</script>
<%@ include file="footer.jsp" %>