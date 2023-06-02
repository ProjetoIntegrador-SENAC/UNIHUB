package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class ExibirTelaEditarConta implements Action {

ContaService contaService;
    public ExibirTelaEditarConta() {
        contaService = new ContaService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Conta conta = contaService
                .getContaById(
                        Integer.parseInt(request.getParameter("id")));

        request.setAttribute("conta",conta);

        return "forward:editarConta.jsp";
    }
}
