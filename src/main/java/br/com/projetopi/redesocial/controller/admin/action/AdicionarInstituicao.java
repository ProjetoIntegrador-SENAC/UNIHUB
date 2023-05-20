package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.InstituicaoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdicionarInstituicao implements Action {

    private InstituicaoService instituicaoService;

    public AdicionarInstituicao(){
        this.instituicaoService = new InstituicaoService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nome = request.getParameter("nome");

        if(this.instituicaoService.add(nome)){
            request.setAttribute("message", "Instituição adicionada com sucesso!");
        }else{
            request.setAttribute("message", "Erro ao adicionar Instituição!");
        }
        return "forward:admin?acao=ExibirTelaInstituicao";
    }
}
