package br.com.projetopi.redesocial.model.dto;

public class AreaCursoChat {
    private String area;
    private int qtd;

    public AreaCursoChat(String area, int qtd) {
        this.area = area;
        this.qtd = qtd;
    }

    public AreaCursoChat() {
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
