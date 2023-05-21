package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Turma;
import br.com.projetopi.redesocial.service.InstituicaoService;
import br.com.projetopi.redesocial.service.TurmaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirTelaTurma implements Action {

    private InstituicaoService instituicaoService;
    private TurmaService turmaService;

    public ExibirTelaTurma(){

        this.instituicaoService = new InstituicaoService();
        this.turmaService = new TurmaService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Instituicao> instituicoes = this.instituicaoService.getInstituicaoAll(50, 0);
        request.setAttribute("instituicoes", instituicoes);

        if (request.getParameter("curso_id") != null){
            int id = Integer.valueOf(request.getParameter("curso_id"));
            ArrayList<Turma> turmas = this.turmaService.getAllByCursoId(id);
            request.setAttribute("turmas", turmas);
        }

        return "forward:turma.jsp";
    }
}
