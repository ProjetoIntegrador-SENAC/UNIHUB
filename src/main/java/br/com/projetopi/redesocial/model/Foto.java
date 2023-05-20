package br.com.projetopi.redesocial.model;

import java.util.Objects;

public class Foto {
    private int id;
    private String cd_foto;

    public Foto(int id, String name){
        this.id = id;
        this.cd_foto = name;
    }

    public Foto(String name){
        this.cd_foto = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCd_foto() {
        return cd_foto;
    }

    public void setCd_foto(String cd_foto) {
        this.cd_foto = cd_foto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Foto foto = (Foto) o;
        return id == foto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
