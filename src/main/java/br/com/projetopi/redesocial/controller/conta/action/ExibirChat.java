package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.dao.MensagemDao;
import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Mensagem;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.ContaService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirChat implements Action {

    private MensagemDao mensagemDao;
    private ContaService contaService;
    public ExibirChat(){
        this.mensagemDao = new MensagemDao();
        this.contaService = new ContaService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");
        Conta conta = contaService.getContaByUsuarioId(usuario.getId());


        int idContaOrigem = conta.getId();
        int idContaDestino = Integer.valueOf(request.getParameter("id_conta_destino"));
        Conta contaDestino = contaService.getContaById(idContaDestino);
//        request.setAttribute("id_conta_origem", idContaOrigem);
//        request.setAttribute("id_conta_destino", idContaDestino);
//        ArrayList<Mensagem> mensagens = this.mensagemDao.getMessages(idContaOrigem, idContaDestino);
        request.setAttribute("id_conta_origem", idContaOrigem);
        request.setAttribute("id_conta_destino", idContaDestino);

        ArrayList<Mensagem> mensagens = this.mensagemDao.getMessages(idContaOrigem, idContaDestino);

        request.setAttribute("mensagens", mensagens);
        request.setAttribute("contaOrigem", conta);
        request.setAttribute("contaDestino", contaDestino);

        return "forward:chat.jsp";
    }
}
