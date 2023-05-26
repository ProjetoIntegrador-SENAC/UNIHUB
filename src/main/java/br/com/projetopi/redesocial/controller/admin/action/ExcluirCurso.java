package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.CursoService;
import br.com.projetopi.redesocial.service.InstituicaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirCurso implements Action {
    private CursoService cursoService;

    public ExcluirCurso(){
        this.cursoService = new CursoService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));
        if(this.cursoService.remove(id)){
            request.setAttribute("message", "Curso excluído com sucesso!");
        }else {
            request.setAttribute("message", "erro ao excluir curso");
        }
        return "forward:admin?acao=ExibirTelaCurso";
    }
}
