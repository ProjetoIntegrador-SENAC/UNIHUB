package br.com.projetopi.redesocial.api;

import br.com.projetopi.redesocial.model.Instituicao;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.InstituicaoService;
import br.com.projetopi.redesocial.service.UsuarioService;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/api_email")
public class EmailApi extends HttpServlet {

    private UsuarioService usuarioService;
    public EmailApi(){
        this.usuarioService = new UsuarioService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> emails = this.usuarioService.getUsuarioAll()
                .stream()
                .map(usuario -> usuario.getEmail())
                .toList();

        String json = ApiUtils.ObjectToJsonString(emails);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter out = resp.getWriter();

        out.print(json);
        out.flush();
    }
}
