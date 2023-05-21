package br.com.projetopi.redesocial.util;

import br.com.projetopi.redesocial.model.Conta;
import br.com.projetopi.redesocial.service.ContaService;
import br.com.projetopi.redesocial.service.PostagemService;

public class PostagemUtils {

    private ContaService contaService;

    public PostagemUtils(){
        this.contaService = new ContaService();
    }

    public Conta findPostCriator(int conta_id){
        return contaService.getContaById(conta_id);
    }
}
