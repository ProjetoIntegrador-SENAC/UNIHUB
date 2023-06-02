<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="head.jsp" %>
<%@ include file="menu.jsp" %>
<div class="col-10">


    <input type="text" style="display: none;" value="1" id="id_origem">
    <input type="text" style="display: none;" value="2" id="id_destino">

<div id="chat-display">

</div>
<input type="text" placeholder="mensagem para servidor" id="message-input">
<a class="btn btn-primary" onclick="sendMessage()"> Enviar mensagem para o servidor </a>

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
</div>
</div>
<%@ include file="footer.jsp" %>