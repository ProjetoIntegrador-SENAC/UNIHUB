package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.service.CursoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditarCurso implements Action {

    private CursoService cursoService;

    public EditarCurso(){
        this.cursoService = new CursoService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String tipo = request.getParameter("tipo");
        String area = request.getParameter("area");
        int id = Integer.valueOf(request.getParameter("id"));

        Curso curso = new Curso();
        curso.setArea(area);
        curso.setNome(nome);
        curso.setTipo(tipo);
        curso.setId(id);

        if(this.cursoService.update(curso)){
            request.setAttribute("message", "Curso atualizado com sucesso");
            request.setAttribute("id", id);
        }else {
            request.setAttribute("message", "Erro ao atualizar curso");
            request.setAttribute("id", id);
        }

        return "forward:admin?acao=ExibirTelaCurso";
    }
}
