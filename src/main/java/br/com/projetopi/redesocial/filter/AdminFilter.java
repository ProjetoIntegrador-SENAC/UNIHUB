package br.com.projetopi.redesocial.filter;

import br.com.projetopi.redesocial.service.AuthService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/admin")
public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String acao = req.getParameter("acao");

        AuthService authService = new AuthService();
        boolean sessaoAtivo = authService.userSessionIsActive((HttpServletRequest) servletRequest);

        if (sessaoAtivo){
            if(authService.getLoggedUser(req).getPapel().equalsIgnoreCase("Admin")){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.sendRedirect("login?acao=ExibirTelaLogin");
        }
        long fim = System.currentTimeMillis();
    }

    @Override
    public void destroy() {

    }
}
