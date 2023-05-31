package br.com.projetopi.redesocial.model;

import java.util.Objects;

public class CurtidaPostagem {

    private int id;
    private int postagem_id;
    private int conta_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurtidaPostagem that = (CurtidaPostagem) o;
        return postagem_id == that.postagem_id && conta_id == that.conta_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, postagem_id, conta_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostagem_id() {
        return postagem_id;
    }

    public void setPostagem_id(int postagem_id) {
        this.postagem_id = postagem_id;
    }

    public int getConta_id() {
        return conta_id;
    }

    public void setConta_id(int conta_id) {
        this.conta_id = conta_id;
    }
}
