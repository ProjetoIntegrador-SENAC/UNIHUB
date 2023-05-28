package br.com.projetopi.redesocial.chat;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/chat")
public class Chat extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        // processa a mensagem recebida

        // envia mensagem para todos os clientes conectados

        for(Session client : session.getOpenSessions()){
            if(client.isOpen()){
                client.getBasicRemote().sendText(message);
                System.out.println("chegou na mensagem");
            }
        }

    }
}
