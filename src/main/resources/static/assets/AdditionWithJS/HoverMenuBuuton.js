const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

if(signUpButton)
{
    signUpButton.addEventListener('click', () =>
        container.classList.add('right-panel-active'));
}
if(signInButton) {
    signInButton.addEventListener('click', () =>
        container.classList.remove('right-panel-active'));
}

function setupHistoryClicks() {
    addClicker(signInButton);
    addClicker(signUpButton);
}

function addClicker(link) {
    link.addEventListener("click", function(e) {
        swapPhoto(link.href);
        history.pushState(null, null, link.href);
        e.preventDefault();
    }, false);
}

function swapPhoto(href) {
    var req = new XMLHttpRequest();
    req.open("GET",
        "login" +
        href.split("/").pop(),
        false);
    req.send(null);
}