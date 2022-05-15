const nav = document.getElementById("nav-bar");
const icon = document.getElementsByClassName("icon");

/* Toggle between showing and hiding the navigation menu links when the user clicks on the hamburger menu / bar icon */
const toggleMenuBar = () => {
    if (nav.style.display === "flex") {
        nav.style.display = "none";
        icon[0].style.marginLeft = "26px";
    } else {
        nav.style.display = "flex";
        icon[0].style.marginLeft = "-29.86px";
    }
}

const menuButton = document.getElementById('menu');
menuButton.addEventListener('click', toggleMenuBar);

window.addEventListener('resize', function(event) {
    const newWidth = window.innerWidth;
    if (newWidth >= 850) {
        nav.style.display = "flex";
        icon[0].style.marginLeft = "-29.86px";
    } else {
        nav.style.display = "none";
        icon[0].style.marginLeft = "26px";
    }
});