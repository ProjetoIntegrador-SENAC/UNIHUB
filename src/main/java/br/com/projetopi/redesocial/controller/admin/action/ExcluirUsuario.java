package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExcluirUsuario implements Action {

    private UsuarioService usuarioService;
    public ExcluirUsuario(){this.usuarioService = new UsuarioService();}

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        if(this.usuarioService.remove(id)){
            request.setAttribute("message", "Usuário excluído com sucesso!");
            return "forward:admin?acao=ExibirTelaUsuario";
        }else{
            request.setAttribute("message", "erro ao excluir o usuário!");
            return "forward:admin?acao=ExibirTelaUsuario";
        }
    }
}
