package br.com.projetopi.redesocial.controller.auth.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logar implements Action {

    private UsuarioService usuarioService;

    public Logar(){
        this.usuarioService = new UsuarioService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = this.usuarioService.getByEmail(email);

        if (this.usuarioService.exists(email)) {
            boolean validaSenha = usuario.getSenha().equals(senha);
            if (usuario != null && validaSenha) {
                HttpSession session = request.getSession();
                session.setAttribute("usuarioLogado", usuario);
                return "forward:conta?acao=ExibirFeed";
            }
        }
        return "redirect:login?acao=ExibirTelaLogin";
    }
}
