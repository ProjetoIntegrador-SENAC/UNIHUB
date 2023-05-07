package br.com.projetopi.redesocial.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/conta")
public class ContaFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long inicio = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long fim = System.currentTimeMillis();
        System.out.println(inicio - fim);
    }
    @Override
    public void destroy() {

    }
}
