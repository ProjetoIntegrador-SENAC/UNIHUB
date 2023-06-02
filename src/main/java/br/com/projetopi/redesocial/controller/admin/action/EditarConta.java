package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditarConta implements Action {


    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String genero = request.getParameter("genero");
        String dataNascimento = request.getParameter("data_nascimento");
        String instituicao = request.getParameter("instituicao");
        String turma = request.getParameter("turma");

//        new ContaService().update()

        System.out.println(nome+"\n"+sobrenome+"\n"+genero+"\n"+dataNascimento+"\n"+instituicao+"\n"+turma);

        return "forward:admin?acao=ExibirTelaConta";
    }
}
