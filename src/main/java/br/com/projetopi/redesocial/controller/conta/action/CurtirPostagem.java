package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.dao.CurtidaPostagemDao;
import br.com.projetopi.redesocial.interfaces.Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CurtirPostagem implements Action{

    private CurtidaPostagemDao curtidaPostagemDao;

    public CurtirPostagem(){
        this.curtidaPostagemDao = new CurtidaPostagemDao();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postagem_id = Integer.valueOf(request.getParameter("postagem_id"));

        int conta_id = Integer.valueOf(request.getParameter("conta_id"));
        this.curtidaPostagemDao.add(postagem_id, conta_id);

        return "forward:conta?acao=ExibirFeed";

    }
}
