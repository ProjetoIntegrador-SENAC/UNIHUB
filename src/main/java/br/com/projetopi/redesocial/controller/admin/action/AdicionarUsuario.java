package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.dao.UsuarioDao;
import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdicionarUsuario implements Action {
    private UsuarioService usuarioService;
    public AdicionarUsuario(){this.usuarioService = new UsuarioService();}

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");

        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPapel(papel);

        UsuarioDao usuarioDAO = new UsuarioDao();
        try {
            usuarioDAO.add(usuario);
            request.setAttribute("message", "Usuário adicionado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Erro ao adicionar usuário: " + e.getMessage());
        }
        return "forward:admin?acao=ExibirTelaUsuario";
    }

}
