package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExibirTelaEditarUsuario implements Action {

    private UsuarioService usuarioService;
    public ExibirTelaEditarUsuario(){this.usuarioService = new UsuarioService();}

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int usuarioId = Integer.valueOf(request.getParameter("id"));
        Usuario usuario = this.usuarioService.getUsuarioById(usuarioId);
        request.setAttribute("usuario", usuario);
        return "forward:editarUsuario.jsp";    }
}
