// Obtém o elemento do botão de adicionar
const actButton = document.getElementById('recuperar')

// Obtém o elemento do modal
const modalOverlay = document.getElementById('modal-overlay')

// Obtém o formulário do modal
const form = document.getElementById('modal-form')

// Obtem a mensagem de erro
const msgError = document.getElementById('msgError')

// Obtém o botão cancelar do modal
const btnCancelar = document.getElementById('btnCancelar')

// Obtém o elemento do input de imagem e o elemento da imagem de pré-visualização
const nameUser = document.getElementById('nomeUser')
const emailUser = document.getElementById('emailUser')

// Adiciona um ouvinte de evento de clique ao botão de adicionar
actButton.addEventListener('click', () => {
    // Exibe o modal
    modalOverlay.style.display = 'flex';
});

// Adiciona um ouvinte de evento de clique ao botão submit
form.addEventListener('submit', e => {
    getEmails().then(data => {
      if (!data.includes(emailUser.value)) {
        alert("O dado não está presente na lista.");
        msgError.style.display = 'block'
        e.preventDefault();
        location.href = '/login?acao=ExibirTelaLogin';
      }
      else {
        alert("O dado está presente na lista");
      }

      alert(data)
      alert(emailUser.value)
    }).catch(error => {
      alert("Ocorreu um erro ao obter os dados: " + error);
    });

})


// Limpe o formulário
function limpar() {
    // Feche o modal
    msgError.style.display = 'none'
    modalOverlay.style.display = 'none';
    form.reset();
}

// Adiciona um ouvinte de evento de cancelar o envio ao formulário do modal
btnCancelar.addEventListener('click', e => {
    e.preventDefault();
    limpar()
});

// Adiciona um ouvinte de evento de clique ao objeto modalOverlay
modalOverlay.addEventListener('click', e => {
    // Verifica se o clique foi fora do modal
    if (e.target === modalOverlay) {
        // Fecha o modal
        msgError.style.display = 'none'
        modalOverlay.style.display = 'none'
        limpar()
    }
});

// Traz emails cadastrados do banco
function getEmails() {
    return fetch("http://localhost:8080/api_email")
        .then(response => response.json())
        .then(data => {
            return data
        })
}