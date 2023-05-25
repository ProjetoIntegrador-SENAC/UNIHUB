const btnTheme = document.getElementById('btnTheme')
const root = document.querySelector(':root')

btnTheme.addEventListener('click', () => {
    if (btnTheme.dataset.theme === 'dark') {
        btnTheme.innerText = 'light_mode'
        root.style.setProperty('--white', '#282729')
        root.style.setProperty('--offWhite', '#363537')
        root.style.setProperty('--black', '#FFF')
        root.style.setProperty('--black-mono', '#000')
        btnTheme.dataset.theme = 'light'
        localStorage.setItem('theme', btnTheme.dataset.theme)
            window.theme = btnTheme.dataset.theme
    } else {
        btnTheme.innerText = 'dark_mode';
        root.style.setProperty('--white', '#FFF')
        root.style.setProperty('--offWhite', '#EEE')
        root.style.setProperty('--black', '#282729')
        root.style.setProperty('--black-mono', '#191528CF')
        btnTheme.dataset.theme = 'dark'
        localStorage.setItem('theme', btnTheme.dataset.theme)
        window.theme = btnTheme.dataset.theme
    }
});

document.addEventListener('DOMContentLoaded', () => {
    const savedTheme = localStorage.getItem('theme')
    window.theme = savedTheme
    if (savedTheme === 'light') {
        btnTheme.innerText = 'light_mode'
        root.style.setProperty('--white', '#282729')
        root.style.setProperty('--offWhite', '#363537')
        root.style.setProperty('--black', '#FFF')
        root.style.setProperty('--black-mono', '#191528CF')
        btnTheme.dataset.theme = 'light';
    } else {
        btnTheme.innerText = 'dark_mode'
        root.style.setProperty('--white', '#FFF')
        root.style.setProperty('--offWhite', '#EEE')
        root.style.setProperty('--black', '#282729')
        root.style.setProperty('--black-mono', '#000')
        btnTheme.dataset.theme = 'dark'
    }
});