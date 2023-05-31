package br.com.projetopi.redesocial.chat;

import br.com.projetopi.redesocial.dao.MensagemDao;
import br.com.projetopi.redesocial.model.Mensagem;
import br.com.projetopi.redesocial.util.ApiUtils;

import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@ServerEndpoint("/chat")
public class Chat extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }

    @OnMessage
    public void onMessage(String message, Session session) throws IOException {

        // CONVERTER STRING TO OBJETIC

        Mensagem mensagem = (Mensagem) ApiUtils.StringJsonToObject(message, new Mensagem());

        //TODO PEGAR ORIGEM E DESTINO E SALVAR NO BANCO DE DADOS A MENSAGEM

        MensagemDao mensagemDao = new MensagemDao();
        mensagemDao.addMensagem(mensagem);

        // TODO OBTER A SESSAO DOS USUARIOS E VERIFICAR SE ESTÃO ATIVAS PARA REALIZAR O MAPEAMENTO DO WS, OU SOMENTE SALVAR AS INFORMAÇÕES NO BANCO DE DADOS

        ArrayList<RemoteEndpoint.Basic> activeSessionsToSendMessage = new ArrayList<>();

        RemoteEndpoint.Basic origem = SessionManager.getSessoes().get(String.valueOf(mensagem.getConta_remente_id()));
        RemoteEndpoint.Basic destinatario = SessionManager.getSessoes().get(String.valueOf(mensagem.getConta_destinatario_id()));

        activeSessionsToSendMessage.add(origem);
        activeSessionsToSendMessage.add(destinatario);

        for(Session client : session.getOpenSessions()){
            if(client.isOpen()){
                if(client.getBasicRemote() == origem || client.getBasicRemote() == destinatario){
                    client.getBasicRemote().sendText(mensagem.getConteudo());
                }
                SessionManager.showSession();
            }
        }

//        for(RemoteEndpoint.Basic s : activeSessionsToSendMessage){
//            if (s != null){
//                s.sendText(mensagem.getConteudo());
//            }
//        }

//        session.getUserProperties().put("conta_id", 1);
//
//        String sessionId = session.getId();
//        Map<String, Object> sessionAttributes = session.getUserProperties();
//
//        System.out.println("Mensagem recebida da sessão: " + sessionId);
//        System.out.println("Atributos da sessão: " + sessionAttributes);

        // processa a mensagem recebida
        // envia mensagem para todos os clientes conectados

    }
    @OnOpen
    public void onOpen(Session session) {
        // Armazenar a sessão atual em uma variável
        int conta_id = ActiveSessionSingleton.getContaId();
        SessionManager.setSessoes(conta_id, session);
        SessionManager.showSession();
    }


}
