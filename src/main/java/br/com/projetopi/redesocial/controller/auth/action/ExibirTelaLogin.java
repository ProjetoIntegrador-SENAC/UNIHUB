package br.com.projetopi.redesocial.controller.auth.action;

import br.com.projetopi.redesocial.interfaces.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExibirTelaLogin implements Action {
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:login.jsp";
    }
}
