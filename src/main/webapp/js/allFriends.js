const btnFriendsAll = document.getElementById('btnFriendsAll')
btnFriendsAll.addEventListener('click', viewAllFriends)
function viewAllFriends() {
    location.href = './conta?acao=ExibirFriends'
}