package br.com.projetopi.redesocial.controller.conta;

import br.com.projetopi.redesocial.interfaces.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/conta")
public class ContaController extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String acao = req.getParameter("acao");
        String className = "br.com.projetopi.redesocial.controller.conta.action." + acao;
        Action action;
        Class absClassString;
        try {
            absClassString = Class.forName(className);
            action = (Action) absClassString.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException a) {
            throw new RuntimeException(a);
        }

        String result = action.executa(req, resp);

        String[] metodo = result.split(":");
        if (metodo[0].equals("forward")){
            RequestDispatcher rd = req.getRequestDispatcher(metodo[1]);
        }else{
            resp.sendRedirect(metodo[1]);
        }
    }
}
