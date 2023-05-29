package br.com.projetopi.redesocial.controller.auth.action;

import br.com.projetopi.redesocial.chat.ActiveSessionSingleton;
import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.AuthService;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.io.IOException;

public class Logar implements Action {

    private UsuarioService usuarioService;
    private AuthService authService;
    private ContaService contaService;

    public Logar(){
        this.usuarioService = new UsuarioService();
        this.authService = new AuthService();
        this.contaService = new ContaService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        Usuario usuario = this.usuarioService.getByEmail(email);
        Conta conta = contaService.getContaByUsuarioId(usuario.getId());

        if (this.usuarioService.exists(email)) {
            boolean validaSenha = this.authService.checkPassword(senha, usuario.getSenha());
            if (usuario != null && validaSenha) {
                HttpSession session = request.getSession();
                if (usuario.getPapel().toUpperCase().equals("ALUNO")) {
                    session.setAttribute("usuarioLogado", usuario);
                    session.setAttribute("contaLogado", conta);
                    ActiveSessionSingleton.setContaId(conta.getId());
                    return "forward:conta?acao=ExibirFeed";
                } else if (usuario.getPapel().toUpperCase().equals("ADMIN")) {
                    session.setAttribute("usuarioLogado", usuario);
                    ActiveSessionSingleton.setContaId(conta.getId());
                    return "forward:admin?acao=ExibirPainel";
                }
            }
        }
        request.setAttribute("message","E-mail e/ou senha inválidos!");
        return "forward:login?acao=ExibirTelaLogin";
    }
}
