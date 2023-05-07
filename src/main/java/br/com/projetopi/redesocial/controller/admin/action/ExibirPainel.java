package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExibirPainel implements Action {

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "forward:admin_painel.html";
    }
}
