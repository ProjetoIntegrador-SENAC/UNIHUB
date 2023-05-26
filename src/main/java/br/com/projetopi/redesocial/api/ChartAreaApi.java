package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.model.Curso;
import br.com.projetopi.redesocial.model.dto.AreaCursoChat;
import br.com.projetopi.redesocial.service.CursoService;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/api_chart_area_curso")
public class ChartAreaApi extends HttpServlet {
    private CursoService cursoService;

    public ChartAreaApi(){
        this.cursoService = new CursoService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<AreaCursoChat> areaCursoGroup = cursoService.getAreaCursoGroupQtd();
        String json = ApiUtils.ObjectToJsonString(areaCursoGroup);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();

    }
}
