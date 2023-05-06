package br.com.projetopi.redesocial.controller.conta.action;

import br.com.projetopi.redesocial.interfaces.Action;
import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.model.Usuario;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.UsuarioService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CadastrarConta implements Action {

    UsuarioService usuarioService;
    ContaService contaService;

    public CadastrarConta(){
        this.contaService = new ContaService();
        this.usuarioService = new UsuarioService();
    }
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id;
        try{
            // dados usuario

            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            String papel = "Aluno";
            Usuario usuario = new Usuario(email, senha, papel);

            if (usuarioService.exists(email)){
                req.setAttribute("cadastro", "erro");
                req.setAttribute("mensagem", "usuário já existe");
                return "forward:register.html";
            }else{
                usuarioService.add(usuario);
            }

            id = usuarioService.getIdByEmail(email);

            // dados conta

            String cpf = req.getParameter("cpf");
            String nome = req.getParameter("nome");
            String sobrenome = req.getParameter("sobrenome");
            String data_nascimento = req.getParameter("data_nascimento");
            String sobre = req.getParameter("sobre");
            String instituicao_id = req.getParameter("instituicao");
            String curso_id = req.getParameter("curso");
            String foto_id = null; //req.getParameter("foto_id");
            String turma_id = req.getParameter("turma_id");
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
            //conta.setFoto_id(Integer.valueOf(foto_id));
            conta.setTurma_id(Integer.valueOf(turma_id));
            ContaService contaService = new ContaService();

            if (contaService.exists(cpf)){
                req.setAttribute("cadastro", "erro");
                req.setAttribute("mensagem", "a conta já existe");
                return "forward:register.html";
            }
            contaService.add(conta);
            req.setAttribute("cadastro", "sucesso");
        }
        catch (Exception e){
            System.out.println("Erro: " + e.getMessage());
            req.setAttribute("cadastro", "fracasso");
        }

        return "forward:login.html";

    }
}
