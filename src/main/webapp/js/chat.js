const socket = new WebSocket('ws://localhost:8080/chat')
const chatDisplay = document.getElementById('chat-display')

socket.onopen = function () {
    console.log('Conexão Estabelecida')
    chatDisplay.scrollTop = chatDisplay.scrollHeight
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
    const serverScheme = chatDisplay.dataset.parametro1
    const serverName = chatDisplay.dataset.parametro2
    const serverPort = chatDisplay.dataset.parametro3
    const contaOrigemFoto = chatDisplay.dataset.origem
    const contaDestinoFoto = chatDisplay.dataset.destino
    const newMessage = document.createElement('p');
    const imgElement = document.createElement('img')

    if(id_origem == jsonObject.conta_remente_id){
        newMessage.classList.add('message')
        newMessage.classList.add('recipient')
        newMessage.textContent = jsonObject.conteudo
        imgElement.src = serverScheme + '://' + serverName + ':' + serverPort + '/' + contaDestinoFoto
        imgElement.classList.add('photoRecipient')
        newMessage.appendChild(imgElement)
        chatDisplay.appendChild(newMessage)
        chatDisplay.scrollTop = chatDisplay.scrollHeight;
    }else{
        const chatDisplay = document.getElementById('chat-display')
        newMessage.classList.add('message')
        newMessage.classList.add('sender')
        newMessage.textContent = jsonObject.conteudo
        imgElement.src = serverScheme + '://' + serverName + ':' + serverPort + '/' + contaOrigemFoto
        imgElement.classList.add('photoSender')
        newMessage.appendChild(imgElement)
        chatDisplay.appendChild(newMessage)
        chatDisplay.scrollTop = chatDisplay.scrollHeight;
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