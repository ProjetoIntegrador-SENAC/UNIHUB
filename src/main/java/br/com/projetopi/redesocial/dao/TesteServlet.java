package br.com.projetopi.redesocial.dao;

import br.com.projetopi.redesocial.model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/teste")
    public class TesteServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            Usuario usuario = new Usuario();
            usuario.setId(2);
            usuario.setEmail("teste@gmail.com");
            usuario.setSenha("123");
            usuario.setPapel("teste");
            new UsuarioDao().add(usuario);


            UsuarioDao usuarioDao = new UsuarioDao();
            boolean sucesso = usuarioDao.update(usuario);
            if (sucesso) {
                System.out.println("Atualização bem-sucedida!");
            } else {
                System.out.println("Falha na atualização!");
            }

        }


    }

