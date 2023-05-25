package br.com.projetopi.redesocial.filter;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.AuthService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/")
public class HomeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        AuthService authService = new AuthService();

        boolean userLogged = authService.userSessionIsActive(req);

        if (!userLogged) {
            resp.sendRedirect("/login?acao=ExibirTelaLogin");
            return;
        }

        Usuario usuario = authService.getLoggedUser(req);

        if(usuario.getPapel().equals("Aluno")){
            resp.sendRedirect("conta?acao=ExibirFeed");
        } else if (usuario.getPapel().equals("Admin")) {
            resp.sendRedirect("admin?acao=ExibirPainel");
        }
        return;
    }

    @Override
    public void destroy() {

    }
}
