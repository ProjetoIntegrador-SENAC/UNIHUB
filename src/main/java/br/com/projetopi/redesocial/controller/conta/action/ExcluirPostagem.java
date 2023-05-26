package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.FotoService;
import br.com.projetopi.redesocial.service.PostagemService;
import br.com.projetopi.redesocial.model.Postagem;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirPostagem implements Action {
    private PostagemService postagemService;
    private FotoService fotoService;

    public ExcluirPostagem(){
        this.postagemService = new PostagemService();
        this.fotoService = new FotoService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Postagem postagem = this.postagemService.findById(id);

        this.fotoService.remove(postagem.getFoto_id());

        this.postagemService.remove(id);

        return "redirect:conta?acao=ExibirPerfil";
    }
}
