package br.com.projetopi.redesocial.controller.auth.action;

import br.com.projetopi.redesocial.interfaces.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Deslogar implements Action {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        return "forward:login?acao=ExibirTelaLogin";
    }
}
