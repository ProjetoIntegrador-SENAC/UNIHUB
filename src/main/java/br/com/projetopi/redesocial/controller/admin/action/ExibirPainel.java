package br.com.projetopi.redesocial.controller.admin.action;

import br.com.projetopi.redesocial.controller.conta.action.ExibirFeed;
import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ExibirPainel implements Action {

    private ContaService contaService;
    private InstituicaoService instituicaoService;
    private CursoService cursoService;
    private TurmaService turmaService;
    private PostagemService postagemService;

    public ExibirPainel(){
        this.contaService = new ContaService();
        this.postagemService = new PostagemService();
        this.cursoService = new CursoService();
        this.turmaService = new TurmaService();
        this.instituicaoService = new InstituicaoService();
    }

    @Override
    public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Conta> contas = contaService.getContaAll(10, 0);
        request.setAttribute("contas", contas);

        int instituicoesQtd = this.instituicaoService.getCount();
        int cursoQtd = this.cursoService.getCount();
        int turmaQtd = this.turmaService.getCount();
        int contaQtd = this.contaService.getCount();
        int postagemQtd = this.postagemService.getCount();

        request.setAttribute("instituicoesQtd", instituicoesQtd);
        request.setAttribute("turmaQtd", turmaQtd);
        request.setAttribute("contaQtd", contaQtd);
        request.setAttribute("cursoQtd", cursoQtd);
        request.setAttribute("postagemQtd", postagemQtd);

        return "forward:painel.jsp";
    }
}
