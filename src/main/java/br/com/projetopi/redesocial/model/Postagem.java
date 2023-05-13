package br.com.projetopi.redesocial.model;

import java.util.Date;
import java.util.Objects;

public class Postagem {
    private Integer id;
    private String conteudo;
    private Integer foto_id;

    private Date data_postagem;
    private Integer conta_id;
    private Foto foto;

    public Postagem(String conteudo, Integer foto_id, Foto foto) {
        this.conteudo = conteudo;
        this.foto_id = foto_id;
        this.foto = foto;
    }

    public Date getData_postagem() {
        return data_postagem;
    }

    public void setData_postagem(Date data_postagem) {
        this.data_postagem = data_postagem;
    }

    public Postagem(){}

    public Integer getConta_id() {
        return conta_id;
    }

    public void setConta_id(Integer conta_id) {
        this.conta_id = conta_id;
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

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
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
