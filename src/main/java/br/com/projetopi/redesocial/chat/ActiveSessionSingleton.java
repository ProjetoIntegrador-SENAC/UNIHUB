package br.com.projetopi.redesocial.chat;

public class ActiveSessionSingleton {
    private static int conta_id;
    public static int getContaId() {
        return conta_id;
    }
    public static void setContaId(int id) {
        conta_id = id;
    }
}
