const btnSingUp = document.getElementById('singUp')
const formLogin = document.getElementById('form-login')

const desc = document.getElementById("desc");
const toast = document.getElementById("toast");

btnSingUp.addEventListener('click', onPress);

function onPress(){
    location.href = './conta?acao=ExibirCadastroConta'
}

window.addEventListener('load',() => {
    if(desc.innerHTML !== '') {
        launch_toast()
    }
})

function launch_toast() {
    toast.className = "show";

    setTimeout(function () {
      desc.style.opacity = "1";
    }, 600);

    setTimeout(function () {
      desc.style.opacity = "0";
    }, 4200);

    setTimeout(function () {
      toast.className = toast.className.replace("show", "");
    }, 5000);
}

const passwordInput = document.getElementById("password");
const toggleIcon = document.querySelector(".toggle-password");

toggleIcon.addEventListener('click', togglePasswordVisibility)

function togglePasswordVisibility() {
    if (passwordInput.type === "password") {
        passwordInput.type = "text";
        toggleIcon.classList.add("password-visible");
        toggleIcon.textContent = "visibility";
    } else {
        passwordInput.type = "password";
        toggleIcon.classList.remove("password-visible");
        toggleIcon.textContent = "visibility_off";
    }
}