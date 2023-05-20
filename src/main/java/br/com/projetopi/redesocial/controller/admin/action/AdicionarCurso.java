package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.service.CursoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdicionarCurso implements Action {

    private CursoService cursoService;

    public AdicionarCurso(){
        this.cursoService = new CursoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String area = request.getParameter("area");
        String tipo = request.getParameter("tipo");
        int inst_id = Integer.valueOf(request.getParameter("instituicao_id"));

        Curso curso = new Curso();
        curso.setNome(nome);
        curso.setTipo(tipo);
        curso.setArea(area);
        curso.setInstituicao_id(inst_id);

        if (this.cursoService.add(curso)){
            request.setAttribute("message", "curso adicionada com sucesso!");
            request.setAttribute("id", inst_id);
        }else {
            request.setAttribute("message", "curso adicionada com sucesso!");
            request.setAttribute("id", inst_id);
        }

        return "forward:admin?acao=ExibirTelaCurso";
    }
}
