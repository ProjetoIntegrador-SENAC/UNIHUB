<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
</head>
<body>

  <input type="text" style="display: none;" value="${id_conta_origem}" id="id_origem">
  <input type="text" style="display: none;" value="${id_conta_destino}" id="id_destino">

  <div>
  <div id="chat-display" style="height: 300px;  overflow-y: scroll; ">
  <c:forEach items="${mensagens}" var="mensagem">
    <c:choose>
      <c:when test="${mensagem.conta_remente_id == id_conta_origem}">
        <p> origem:  ${mensagem.conteudo} </p>
      </c:when>
      <c:otherwise>
        <p> destino: ${mensagem.conteudo}</p>
      </c:otherwise>
    </c:choose>
  </c:forEach>
  </div>

  <input type="text" placeholder="mensagem para servidor" id="message-input">
  <button onclick="sendMessage()"> Enviar mensagem para o servidor  </button> 
  </div>

  <script>
  
  const socket = new WebSocket('ws://localhost:8080/chat')
  
  
  socket.onopen = function(){
      console.log('Conexão Estabelecida')
  }
  
  
  // Evento disparado quando uma mensagem é recebida do servidor
  
  socket.onmessage = function(e){
      const message = e.data;
      console.log('Mensagem recebida: ', message);
      // Exiba a mensagem na interface do usuário do chat
      // Exemplo: adicione a mensagem a uma área de exibição na página HTML
      const chatDisplay = document.getElementById('chat-display')
      const newMessage = document.createElement('p');
      newMessage.textContent = message
      chatDisplay.appendChild(newMessage)
      chatDisplay.scrollTop = 2 ^ 10000;
  
  }
  
  // Evento disparado quando a conexão é fechada
  socket.onclose = function(event) {
    console.log('Conexão fechada:', event.code, event.reason);
  };
  
  
  // Evento disparado quando ocorre um erro na conexão
  socket.onerror = function(error) {
    console.error('Erro na conexão:', error);
  };
  
  
  function sendMessage() {
  
    const idOrigem = document.getElementById('id_origem').value;
    const idDestino = document.getElementById('id_destino').value;
  
  
    const messageInput = document.getElementById('message-input');
    const message = messageInput.value;
  
  
    payload = {
      "id": null,
      "conteudo": message,
      "data_mensagem": new Date().toISOString().substring(0, 10),
      "conta_remente_id": idOrigem,
      "conta_destinatario_id": idDestino,
    }
  
  
  
    // Envia a mensagem para o servidor
    socket.send(JSON.stringify(payload));
  
    // Limpa o campo de entrada de mensagem
    messageInput.value = '';
  }
    
  </script>

</body>
</html>

