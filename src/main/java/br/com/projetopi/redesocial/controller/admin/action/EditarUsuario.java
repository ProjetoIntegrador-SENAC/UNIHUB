package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditarUsuario implements Action {

    private UsuarioService usuarioService;

    public EditarUsuario() {
        this.usuarioService = new UsuarioService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(papel);

        boolean sucesso = usuarioService.update(usuario);

        if (sucesso) {
            return ("sucesso.jsp");
        } else {
            return ("erro.jsp");
        }


    }
}
