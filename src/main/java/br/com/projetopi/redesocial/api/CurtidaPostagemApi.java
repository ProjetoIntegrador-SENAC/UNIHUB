package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.dao.CurtidaPostagemDao;
import br.com.projetopi.redesocial.model.dto.CurtidaPostagemDto;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api_curtida_postagem")
public class CurtidaPostagemApi extends HttpServlet {
    private CurtidaPostagemDao postagemDao;

    public CurtidaPostagemApi(){
        this.postagemDao = new CurtidaPostagemDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int contaId = Integer.valueOf(req.getParameter("conta_id"));
        int postagemId = Integer.valueOf(req.getParameter("postagem_id"));
        CurtidaPostagemDto curtidaPostagemDto = postagemDao.like(postagemId, contaId);
        String json = ApiUtils.ObjectToJsonString(curtidaPostagemDto);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
