// Obtém o elemento do botão de adicionar
const addButton = document.querySelector('nav');

// Obtém o elemento do modal
const modalOverlay = document.getElementById('modal-overlay');

// Obtém o formulário do modal
const form = document.getElementById('modal-form');

// Obtém o botão cancelar do modal
const btnCancelar = document.getElementById('btnCancelar');

// Obtém o input da imagem
const inputImg = document.getElementById('img');

// Obtém o elemento do input de imagem e o elemento da imagem de pré-visualização
const imageInput = document.getElementById('file');
const previewImage = document.getElementById('preview-image');

// Adiciona um ouvinte de evento de clique ao botão de adicionar
addButton.addEventListener('click', () => {
    // Exibe o modal
    modalOverlay.style.display = 'flex';
});

// Limpe o formulário
function limpar() {
    // Feche o modal
    modalOverlay.style.display = 'none';
    form.reset();
    inputImg.style.display = 'block';
    previewImage.src = '';
    previewImage.display = 'none';
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
        modalOverlay.style.display = 'none';
    }
});


// Adiciona um ouvinte de evento de alteração ao input de imagem
imageInput.addEventListener('change', e => {
    const selectedImage = e.target.files[0]; // Obtém o arquivo de imagem selecionado

    if (selectedImage) {
        const reader = new FileReader(); // Cria um objeto FileReader

        // Define uma função de retorno de chamada para ler o conteúdo do arquivo
        reader.onload = function() {
            previewImage.src = reader.result; // Define o atributo src da imagem de pré-visualização
        }

        reader.readAsDataURL(selectedImage); // Lê o conteúdo do arquivo como uma URL de dados
    }
    
    previewImage.style.display = 'block';
    inputImg.style.display = 'none';
});