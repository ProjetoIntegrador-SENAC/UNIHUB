const socket = new WebSocket('ws://localhost:8080/chat')

socket.onopen = function () {
    console.log('Conexão Estabelecida')
}

// Evento disparado quando uma mensagem é recebida do servidor

socket.onmessage = function (e) {
    const message = e.data;
    console.log('Mensagem recebidass: ', message);
    const jsonObject = JSON.parse(message);
    console.log(jsonObject.conta_remente_id)
    // Exiba a mensagem na interface do usuário do chat
    // Exemplo: adicione a mensagem a uma área de exibição na página HTML
    
    id_origem = document.querySelector('#id_origem')

    if(id_origem == jsonObject.conta_remente_id){
        const chatDisplay = document.getElementById('chat-display')
        const newMessage = document.createElement('p');
        newMessage.classList.add('message sender')
        newMessage.textContent = jsonObject.conteudo
        chatDisplay.appendChild(newMessage)
        chatDisplay.scrollTop = 2 ^ 10000;
    }else{
        const chatDisplay = document.getElementById('chat-display')
        const newMessage = document.createElement('p');
        newMessage.classList.add('message recipient')
        newMessage.textContent = jsonObject.conteudo
        chatDisplay.appendChild(newMessage)
        chatDisplay.scrollTop = 2 ^ 10000;
    }
}

// Evento disparado quando a conexão é fechada
socket.onclose = function (event) {
    console.log('Conexão fechada:', event.code, event.reason);
};


// Evento disparado quando ocorre um erro na conexão
socket.onerror = function (error) {
    console.error('Erro na conexão:', error);
};

function sendMessage() {

    const idOrigem = document.getElementById('id_origem').value;
    const idDestino = document.getElementById('id_destino').value;

    const messageInput = document.getElementById('message-input');
    const message = messageInput.value.trim();

    if (message !== '') {

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
}

// Contador de caracteres restante
function updateCharCount() {
    const input = document.getElementById('message-input');
    const charCount = document.getElementById('char-count');
    const remainingChars = 400 - input.value.length;
    charCount.textContent = remainingChars + ' caracteres restantes';
}