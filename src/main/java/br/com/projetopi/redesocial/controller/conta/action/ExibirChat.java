package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ExibirChat implements Action {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        int idContaOrigem = usuario.getId();
        int idContaDestino = Integer.valueOf(request.getParameter("id_conta_destino"));
        request.setAttribute("id_conta_origem", idContaOrigem);
        request.setAttribute("id_conta_destino", idContaDestino);



        return "forward:chat.jsp";
    }
}
