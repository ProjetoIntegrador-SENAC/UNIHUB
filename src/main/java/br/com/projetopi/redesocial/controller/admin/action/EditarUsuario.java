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
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        int usuario_id = Integer.valueOf(request.getParameter("id"));

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(papel);
        usuario.setId(usuario_id);

        if (this.usuarioService.update(usuario)) {
            request.setAttribute("message", "Usuário atualizado com sucesso");
        } else {
            request.setAttribute("message", "Erro ao atualizar o Usuário");

        }
        return "forward:admin?acao=ExibirTelaUsuario";

    }
}
