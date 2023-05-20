package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.service.InstituicaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExibirTelaEditarInstituicao implements Action {

    private InstituicaoService instituicaoService;

    public ExibirTelaEditarInstituicao(){
        this.instituicaoService = new InstituicaoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int instituicao_id = Integer.valueOf(request.getParameter("id"));
        Instituicao instituicao = this.instituicaoService.getInstituicaoById(instituicao_id);
        request.setAttribute("instituicao", instituicao);
        return "forward:editarInstituicao.jsp";
    }
}
