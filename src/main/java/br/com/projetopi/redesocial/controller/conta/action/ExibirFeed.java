package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Postagem;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.PostagemService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirFeed implements Action {

    private PostagemService postagemService;
    private ContaService contaService;

    public ExibirFeed(){
        this.postagemService = new PostagemService();
        this.contaService = new ContaService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        var session = request.getSession();
        Conta conta = (Conta) session.getAttribute("contaLogado");

        int instituicao_id = 1; // Integer.valueOf(request.getParameter("instituicao_id"));
        int qtd_elementos = 10; // Integer.valueOf(request.getParameter("qtd_elementos"));
        int num_inicio = 0; //Integer.valueOf(request.getParameter("num_inicio"));

        ArrayList<Postagem> postagens = this.postagemService.findAllPageable();
        ArrayList<Conta> contas = contaService.findAllPageableByTurmaId(conta.getTurma_id(), 50, 0, conta.getUsuario_id());

        request.setAttribute("postagens", postagens);
        request.setAttribute("contas", contas);
        request.setAttribute("usuariologado",  contaService.getContaById(conta.getId()));

        return "forward:feed.jsp";
    }
}
