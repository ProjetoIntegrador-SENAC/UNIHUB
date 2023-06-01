package br.com.projetopi.redesocial.model.dto;

import java.sql.Date;

public class QtdPostagemByDate {
    private Date data_postagem;
    private int qtd;

    public Date getData_postagem() {
        return data_postagem;
    }

    public void setData_postagem(Date data_postagem) {
        this.data_postagem = data_postagem;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
