package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.model.dto.AreaCursoChat;
import br.com.projetopi.redesocial.model.dto.QtdPostagemInstituicao;
import br.com.projetopi.redesocial.service.CursoService;
import br.com.projetopi.redesocial.service.PostagemService;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/api_post_by_inst")
public class QtdPostByInstApi extends HttpServlet {
    private PostagemService postagemService;

    public QtdPostByInstApi(){
        this.postagemService = new PostagemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<QtdPostagemInstituicao> qtdPostagemInstituicaos = postagemService.getQtdPostagens();
        String json = ApiUtils.ObjectToJsonString(qtdPostagemInstituicaos);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
