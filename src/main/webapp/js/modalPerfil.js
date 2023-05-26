// Obtém o elemento do botão de adicionar
const editButton = document.querySelector('#edit-img');
const deletPhotoButtons = document.querySelectorAll('.btnDelet')

// Obtém o elemento do modal
const modals = document.querySelectorAll('.modal-overlay');
const modalEditPhoto = document.getElementById('editPhoto');
const modalDeletPost = document.getElementById('deletPost');

// Obtém o botão cancelar do modal
const btnCancelar = document.getElementById('btnCancelar');
const noDelet = document.getElementById('noDelet');
const yesDelet = document.getElementById('yesDelet');

// Obtém o input da imagem
const inputImg = document.getElementById('img');

// Obtém o elemento do input de imagem e o elemento da imagem de pré-visualização
const imageInput = document.getElementById('filePerfil');
const previewImage = document.getElementById('preview-image');



// Adiciona um ouvinte de evento de clique ao botão de adicionar
editButton.addEventListener('click', () => {
    // Exibe o modal
    modalEditPhoto.style.display = 'flex';
});


deletPhotoButtons.forEach((deletPhotoButton, index) => {
  deletPhotoButton.addEventListener('click', () => {
    // Open the modal
    modalDeletPost.style.display = 'flex';

    const yesDeletButton = document.getElementById('yesDelet');
    const noDeletButton = document.getElementById('noDelet');

    yesDeletButton.addEventListener('click', () => {
      // Perform the deletion action
      location.href = '/conta?acao=ExcluirPostagem&id=' + index;
    });

    noDeletButton.addEventListener('click', () => {
      // Close the modal
      modalDeletPost.style.display = 'none';
    });
  });
});

// Limpe o formulário
function limpar() {
    // Fechar o modal de edição de foto de perfil
    modalEditPhoto.style.display = 'none';
    inputImg.style.display = 'block';
    previewImage.src = '';
    previewImage.display = 'none';

    // Fechar o modal de exclusão de postagem
    modalDeletPost.style.display = 'none';
}

// Adiciona um ouvinte de evento de cancelar o envio ao formulário do modal
btnCancelar.addEventListener('click', e => {
    e.preventDefault();
    limpar()
});


// Adiciona um ouvinte de evento de clique a cada objeto modalOverlay
modals.forEach((modalOverlay) => {
    modalOverlay.addEventListener('click', e => {
        // Verifica se o clique foi fora do modal
        if (e.target === modalOverlay) {
            // Fecha o modal
            modalOverlay.style.display = 'none';
        }
    });
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