package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirTelaConta implements Action {

    private ContaService contaService;

    public ExibirTelaConta(){
        this.contaService = new ContaService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Conta> contas = contaService.getContaAll(10, 0);
        request.setAttribute("contas", contas);
        return "forward:conta.jsp";
    }
}
