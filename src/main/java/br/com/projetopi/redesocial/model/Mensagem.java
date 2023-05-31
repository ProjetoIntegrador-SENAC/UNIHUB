package br.com.projetopi.redesocial.model;

import java.sql.Date;
import java.util.Objects;

public class Mensagem {
    private int id;
    private String conteudo;
    private Date data_mensagem;
    private int conta_remente_id;
    private int conta_destinatario_id;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mensagem mensagem = (Mensagem) o;
        return id == mensagem.id && conta_remente_id == mensagem.conta_remente_id && conta_destinatario_id == mensagem.conta_destinatario_id && Objects.equals(conteudo, mensagem.conteudo) && Objects.equals(data_mensagem, mensagem.data_mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, conteudo, data_mensagem, conta_remente_id, conta_destinatario_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getData_mensagem() {
        return data_mensagem;
    }

    public void setData_mensagem(Date data_mensagem) {
        this.data_mensagem = data_mensagem;
    }

    public int getConta_remente_id() {
        return conta_remente_id;
    }

    public void setConta_remente_id(int conta_remente_id) {
        this.conta_remente_id = conta_remente_id;
    }

    public int getConta_destinatario_id() {
        return conta_destinatario_id;
    }

    public void setConta_destinatario_id(int conta_destinatario_id) {
        this.conta_destinatario_id = conta_destinatario_id;
    }
}
