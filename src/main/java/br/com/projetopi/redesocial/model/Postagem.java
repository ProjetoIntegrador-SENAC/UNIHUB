package br.com.projetopi.redesocial.model;

import br.com.projetopi.redesocial.util.PostagemUtils;

import java.sql.Date;
import java.util.Objects;

public class Postagem {
    private Integer id;
    private String conteudo;
    private Integer foto_id;

    private Date data_postagem;
    private Integer conta_id;
    private String foto;

    private Conta conta;

    public Postagem(){}

    public Postagem(String conteudo, Integer foto_id, String foto, Integer conta_id, Date data_postagem) {
        this.conteudo = conteudo;
        this.foto_id = foto_id;
        this.foto = foto;
        this.conta_id = conta_id;
        this.data_postagem = data_postagem;
    }

    public Date getData_postagem() {
        return data_postagem;
    }

    public void setData_postagem(Date data_postagem) {
        this.data_postagem = data_postagem;
    }


    public Integer getConta_id() {
        return conta_id;
    }

    public void setConta_id(Integer conta_id) {
        this.conta_id = conta_id;
        PostagemUtils postagemUtils = new PostagemUtils();
        setConta(postagemUtils.findPostCriator(conta_id));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Integer getFoto_id() {
        return foto_id;
    }

    public void setFoto_id(Integer foto_id) {
        this.foto_id = foto_id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return id.equals(postagem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Postagem{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", foto_id=" + foto_id +
                ", foto=" + foto +
                '}';
    }
}
