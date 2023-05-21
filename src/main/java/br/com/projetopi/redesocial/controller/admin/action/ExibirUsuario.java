package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirUsuario implements Action {

    private UsuarioService usuarioService;

    public ExibirUsuario(){
        this.usuarioService = new UsuarioService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Usuario> usuarios = usuarioService.getUsuarioAll("admin",10,0);
        request.setAttribute("usuarios", usuarios);
        return "forward:usuarios.jsp";
    }
}
