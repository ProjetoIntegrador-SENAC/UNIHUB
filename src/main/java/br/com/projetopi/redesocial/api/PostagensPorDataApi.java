package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.dao.PostagemDao;
import br.com.projetopi.redesocial.model.dto.QtdPostagemByDate;
import br.com.projetopi.redesocial.model.dto.QtdPostagemInstituicao;
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

@WebServlet("/api_postagens_data")
public class PostagensPorDataApi extends HttpServlet {
    private PostagemDao postagemDao;

    public PostagensPorDataApi(){
        this.postagemDao = new PostagemDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<QtdPostagemByDate> qtdPostagemByDate = postagemDao.getQtPostsByDate();
        String json = ApiUtils.ObjectToJsonString(qtdPostagemByDate);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
