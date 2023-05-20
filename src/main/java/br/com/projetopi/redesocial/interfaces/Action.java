package br.com.projetopi.redesocial.interfaces;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Action {
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
