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
import java.util.ArrayList;

public class ExibirTelaCurso implements Action {

    private InstituicaoService instituicaoService;
    private CursoService cursoService;
    public ExibirTelaCurso(){

        this.instituicaoService = new InstituicaoService();
        this.cursoService = new CursoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Instituicao> instituicoes = this.instituicaoService.getInstituicaoAll(50, 0);
        request.setAttribute("instituicoes", instituicoes);


        if(request.getParameter("id") != null){
            int id = Integer.valueOf(request.getParameter("id"));
            ArrayList<Curso> cursos = this.cursoService.getCursosByInstituicaoId(id);
            request.setAttribute("cursos", cursos);

            Instituicao instituicao = this.instituicaoService.getInstituicaoById(id);
            request.setAttribute("instituicao_atual", instituicao);
        }

        return "forward:curso.jsp";
    }
}
