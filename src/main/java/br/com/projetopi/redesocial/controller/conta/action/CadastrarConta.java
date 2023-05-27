package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Turma;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.repository.ConnectionFactory;
import br.com.projetopi.redesocial.service.AuthService;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.TurmaService;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;

public class CadastrarConta implements Action {

    private UsuarioService usuarioService;
    private ContaService contaService;
    private AuthService authService;
    private TurmaService turmaService;

    public CadastrarConta(){
        this.contaService = new ContaService();
        this.usuarioService = new UsuarioService();
        this.authService = new AuthService();
        this.turmaService = new TurmaService();
    }
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        try{
            // dados usuario

            String email = req.getParameter("email");
            String senha = this.authService.hashPassword(req.getParameter("senha"));
            String papel = "Aluno";
            Usuario usuario = new Usuario(email, senha, papel);

            if (usuarioService.exists(email)){
                req.setAttribute("message", "Conta já existe!");
                return "forward:login?acao=ExibirTelaLogin";
            }else{
                usuarioService.add(usuario);
            }

            id = usuarioService.getIdByEmail(email);

            // cria uma turma
            String turno = req.getParameter("shift");
            String semestre = req.getParameter("semester");
            String letra = req.getParameter("turma_id");
            String dataInicio = req.getParameter("year");
            String curso_id = req.getParameter("curso");

            Calendar calendar = Calendar.getInstance();
            calendar.set(Integer.parseInt(dataInicio), 0, 1);

            Date date = new Date(calendar.getTimeInMillis());

            if (!this.turmaService.exists(date, turno, semestre, letra, Integer.valueOf(curso_id))){
                Turma novaTurma = new Turma(
                        Integer.parseInt(curso_id), date, turno, semestre, letra);
                this.turmaService.add(novaTurma);
            }

            Turma turma = this.turmaService.findTurmaByDataIdCursoSemestre(Integer.valueOf(dataInicio),
                    Integer.valueOf(curso_id),
                    semestre,
                    turno,
                    letra
                    );

            // dados conta
            String cpf = req.getParameter("cpf");
            String nome = req.getParameter("nome");
            String sobrenome = req.getParameter("sobrenome");
            String data_nascimento = req.getParameter("data_nascimento");
            String sobre = req.getParameter("sobre");
            String instituicao_id = req.getParameter("instituicao");
            String foto_id = "1";
            int turma_id = turma.getId();
            String genero = req.getParameter("genero");

            Conta conta = new Conta();
            conta.setCpf(cpf);
            conta.setNome(nome);
            conta.setSobrenome(sobrenome);
            conta.setGenero(genero);
            conta.setData_nascimento(Date.valueOf(data_nascimento));
            conta.setSobre(sobre);
            conta.setUsuario_id(Integer.valueOf(id));
            conta.setInstituiacao_id(Integer.valueOf(instituicao_id));
            conta.setCurso_id(Integer.valueOf(curso_id));
            conta.setFoto_id(Integer.valueOf(foto_id));
            conta.setTurma_id(Integer.valueOf(turma_id));

            ContaService contaService = new ContaService();

            if (contaService.exists(cpf)){
                req.setAttribute("message", "Conta já existe!");
                usuarioService.remove(id);
                return "forward:login?acao=ExibirTelaLogin";
            }
            contaService.add(conta);
            req.setAttribute("cadastro", "sucesso");
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            req.setAttribute("cadastro", "fracasso");
            return "forward:conta?acao=ExibirCadastroConta";
        }
        return "forward:login?acao=ExibirTelaLogin";

    }
}
