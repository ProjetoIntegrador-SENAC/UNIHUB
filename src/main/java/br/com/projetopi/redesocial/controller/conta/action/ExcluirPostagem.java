package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirPostagem implements Action {
    private ContaService contaService;

    ExcluirPostagem(){
        this.contaService = new ContaService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        this.contaService.removePost(id);
        return "redrect:conta?acao=ExibirPerfil";
    }
}
