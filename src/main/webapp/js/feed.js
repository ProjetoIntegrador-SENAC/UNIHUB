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
    btnFavorite.addEventListener('click', () => {
        const fav = btnFavorite.querySelector('.favorite')
        const outlined = getComputedStyle(document.querySelector('.material-symbols-outlined'))
        if (fav.dataset.like == 'dislike') {
            fav.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 1'
            fav.style.color = 'red'
            fav.dataset.like = 'like'
        } else {
            fav.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 0'
            fav.style.color = 'var(--black)'
            fav.dataset.like = 'dislike'
        }
    })
})

const btnComments = document.querySelectorAll('.btnComment')
btnComments.forEach(btnComment => {
    btnComment.addEventListener('click', () => {
        const comment = btnComment.querySelector('.comment')
        const outlined = getComputedStyle(document.querySelector('.material-symbols-outlined'))
        if (comment.dataset.comment == 'closed') {
            comment.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 1'
            comment.dataset.comment = 'open'
        } else {
            comment.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 0'
            comment.dataset.comment = 'closed'
        }
    })
})

const btnShares = document.querySelectorAll('.btnShare')
btnShares.forEach(btnShare => {
    btnShare.addEventListener('click', () => {
        const share = btnShare.querySelector('.share')
        const outlined = getComputedStyle(document.querySelector('.material-symbols-outlined'))
        if (share.dataset.share == 'closed') {
            share.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 1'
            share.style.color = 'blue'
            share.dataset.share = 'open'
        } else {
            share.style.fontVariationSettings = outlined.getPropertyValue('font-variation-settings') + ', "FILL" 0'
            share.style.color = 'var(--black)'
            share.dataset.share = 'closed'
        }
    })
})

const imageProfile = document.getElementById('imageProfile')

imageProfile.addEventListener('click', onPress);

function onPress(){
    location.href = './conta?acao=ExibirPerfil'
}

const btnTheme = document.getElementById('btnTheme')
const root = document.querySelector(':root')

btnTheme.addEventListener('click', () => {

    if (btnTheme.dataset.theme === 'dark') {
            btnTheme.innerText = 'light_mode'
            root.style.setProperty('--white', '#282729')
            root.style.setProperty('--offWhite', '#363537')
            root.style.setProperty('--black', '#FFF')

            btnTheme.dataset.theme = 'light'
    } else {
        btnTheme.innerText = 'dark_mode'
        root.style.setProperty('--white', '#FFF')
        root.style.setProperty('--offWhite', '#EEE')
        root.style.setProperty('--black', '#282729')
        btnTheme.dataset.theme = 'dark'
    }

})