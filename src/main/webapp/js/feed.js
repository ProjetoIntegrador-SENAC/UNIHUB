// Amplia legenda
const legends = document.querySelectorAll('.legend')
legends.forEach(legend => {    
    legend.addEventListener('click', () => {
        const arrow = legend.querySelector('.arrow')
        const text = legend.querySelector('.textLegend')
        if(arrow.dataset.arrow == 'down-arrow') {
            arrow.innerText = 'arrow_drop_up'
            arrow.dataset.arrow  = 'up-arrow'
            text.style.height = `${text.scrollHeight}px`
            text.classList.add('expanded')
        } else {
            arrow.innerText = 'arrow_drop_down'
            arrow.dataset.arrow  = 'down-arrow'
            text.style.height = '2.7em'
            text.classList.remove('expanded')
        }
    })
})

const btnFavorites = document.querySelectorAll('.btnFavorite')
btnFavorites.forEach(btnFavorite => {
    const postId = btnFavorite.dataset.postagemId;
    const userId = btnFavorite.dataset.usuarioLogadoId;
    const fav = btnFavorite.querySelector('.favorite')
    const outlined = getComputedStyle(document.querySelector('.material-symbols-outlined'))
    function getCurtidas(){
        return fetch(`http://localhost:8080/api_curtida_postagem?postagem_id=${postId}&conta_id=${userId}`)
        .then(response => response.json())
        .then(data => {
            fav.dataset.like = data['isLike']
            if (fav.dataset.like == 'like') {
                fav.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 1'
                fav.style.color = 'red'
            } else {
                fav.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 0'
                fav.style.color = 'var(--black)'
            }
            return data
        })
    }   
    window.addEventListener('load', getCurtidas)
    fav.addEventListener('click', () => {
            location.href=`conta?acao=CurtirPostagem&postagem_id=${postId}&conta_id=${userId}`
    })
})

// Exibir Perfil
const imageProfile = document.getElementById('imageProfile')

imageProfile.addEventListener('click', onPress);

function onPress() {
    location.href = './conta?acao=ExibirPerfil'
}

// Exibir All Friends
const btnFriendsAll = document.getElementById('btnFriendsAll')
btnFriendsAll.addEventListener('click', viewAllFriends)
function viewAllFriends() {
    location.href = './conta?acao=ExibirFriends'
}

// Buscar amigo
const searchInput = document.querySelector('input[type="search"]');
searchInput.addEventListener('input', filterFriends);
const friends = document.querySelectorAll('.friend');

function filterFriends() {
    const searchTerm = searchInput.value.toLowerCase();

    friends.forEach((friend) => {
        const name = friend.querySelector('h5').textContent.toLowerCase();
    if (name.includes(searchTerm)) {
        friend.style.display = 'flex';
    } else {
        friend.style.display = 'none';
    }
    });
}