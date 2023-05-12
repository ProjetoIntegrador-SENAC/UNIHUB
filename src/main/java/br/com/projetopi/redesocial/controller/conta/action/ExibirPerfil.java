package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExibirPerfil implements Action {

    private ContaService contaService;
    public ExibirPerfil(){
        this.contaService = new ContaService();
    }
    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
        Conta conta = this.contaService.getContaByUsuarioId(usuario.getId());
        return null;
    }
}
