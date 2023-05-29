package br.com.projetopi.redesocial.chat;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.util.HashMap;
import java.util.Map;

public class SessionManager {
    private static Map<String, RemoteEndpoint.Basic> sessoes = new HashMap<>();

    public static Map<String, RemoteEndpoint.Basic> getSessoes() {
        return sessoes;
    }

    public static void setSessoes(Map<String, RemoteEndpoint.Basic> sessoes) {
        SessionManager.sessoes = sessoes;
    }

    public static void setSessoes(int conta_id, Session session) {
        String id = String.valueOf(conta_id);
        sessoes.put(id, session.getBasicRemote());
    }

    public static void showSession(){
        sessoes.forEach((k, v) -> System.out.println("chave: " + k + " valor: " + v));
    }

    public static RemoteEndpoint.Basic get(int chave){
        return null;
    }
}
