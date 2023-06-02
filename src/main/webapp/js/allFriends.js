const btnFriendsAll = document.getElementById('btnFriendsAll')
btnFriendsAll.addEventListener('click', viewAllFriends)
function viewAllFriends() {
    location.href = './conta?acao=ExibirFriends'
}

const searchInput = document.querySelector('input[type="search"]');
searchInput.addEventListener('input', filterFriends);
const friends = document.querySelectorAll('.friend');

function filterFriends() {
    const searchTerm = searchInput.value.toLowerCase();

    friends.forEach((friend) => {
        const name = friend.querySelector('p').textContent.toLowerCase();
    if (name.includes(searchTerm)) {
        friend.style.display = 'block';
    } else {
        friend.style.display = 'none';
    }
    });
}

friends.addEventListener('click', openPerfil)

function openPerfil() {
    friends.forEach((friend) => {
        const idFriend = friend.currentTarget.getAttribute('data-set');
        location.href = './conta?acaoExibirPerfil&${idFriend}'
    });
}