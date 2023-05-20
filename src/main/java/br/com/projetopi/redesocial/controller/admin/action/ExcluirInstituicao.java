package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.InstituicaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirInstituicao implements Action {

    private InstituicaoService instituicaoService;

    public ExcluirInstituicao(){
        this.instituicaoService = new InstituicaoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        if(this.instituicaoService.remove(id)){
            request.setAttribute("message", "instituição excluída com sucesso!");
            return "forward:admin?acao=ExibirTelaInstituicao";
        }else{
            request.setAttribute("message", "erro ao excluir instituição!");
            return "forward:admin?acao=ExibirTelaInstituicao";
        }
    }
}
