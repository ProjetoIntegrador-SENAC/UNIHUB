package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.service.CursoService;
import br.com.projetopi.redesocial.service.InstituicaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExibirTelaEditarCurso implements Action {

    private CursoService cursoService;
    public ExibirTelaEditarCurso(){
        this.cursoService = new CursoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int curso_id = Integer.valueOf(request.getParameter("id"));
        Curso curso = this.cursoService.getCursoById(curso_id);
        request.setAttribute("curso", curso);
        return "forward:editarCurso.jsp";

    }
}
