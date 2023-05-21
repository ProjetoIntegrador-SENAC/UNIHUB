package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.service.InstituicaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditarInstituicao implements Action {

    private InstituicaoService instituicaoService;

    public EditarInstituicao(){
        this.instituicaoService = new InstituicaoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        int instituicao_id = Integer.valueOf(request.getParameter("id"));
        Instituicao instituicao = new Instituicao();
        instituicao.setId(instituicao_id);
        instituicao.setNome(nome);
        ;

        if(this.instituicaoService.update(instituicao)){
            request.setAttribute("message", "Instituição atualizada com sucesso");
        }else {
            request.setAttribute("message", "Erro ao atualizar Instituição");
        }

        return "forward:admin?acao=ExibirTelaInstituicao";

    }
}
