package br.com.projetopi.redesocial.util;

public enum RecuperarSenhaUtils {
    EMAIL("unihub.ltda@outlook.com"),

    SENHA("unihubSenac");

    private String info;
    RecuperarSenhaUtils(String info){
        this.info = info;
    }
    public String getInfo(){
        return this.info;
    }
}
