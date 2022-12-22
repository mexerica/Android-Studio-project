function change() { 
    let x = 1;
    while (x < 4) {
        const image = document.getElementById('image' + x);
        const subtitle = document.getElementById('subtitle' + x);
        const font = document.getElementById('font' + x);
        if (x === 1) {
            const title = document.getElementById('title' + x);
            if (image.src.match("./img/NFR.PNG")) {
                image.src = "./img/Github.PNG";
                title.textContent = "Github: Conheça 10 vantagens da ferramenta";
                subtitle.textContent = "GitHub é uma plataforma de hospedagem de código-fonte e arquivos com controle de versão usando o Git."
                font.textContent = "Fonte: WIKIPÉDIA";
            } else {
                image.src = "./img/NFR.PNG";
                title.textContent = "NRF 2020: Conheça os top 5 assuntos do evento.";
                subtitle.textContent = "O maior evento sobre varejo do mundo mostrando ás tendências, oportunidades e inovações para o setor."
                font.textContent = "Fonte: CMO ADOBE";
            }
        } else if (x === 2) {
            if (image.src.match("./img/Kobe.PNG")) {
                image.src = "./img/Ace.PNG";
                subtitle.textContent = "Conheça os melhores jogos de investigação."
                font.textContent = "Fonte: EU";
            } else {
                image.src = "./img/Kobe.PNG";
                subtitle.textContent = "Petição para colocar Kobe Bryan na logo do NBA."
                font.textContent = "Fonte: Daily Meal";
            }
        } else {
            if (image.src.match("./img/Zap.PNG")) {
                image.src = "./img/Spotify.PNG";
                subtitle.textContent = "Veja ás mais musícas mais tocadas do ano."
                font.textContent = "Fonte: Spotify";
            } else {
                image.src = "./img/Zap.PNG";
                subtitle.textContent = "WhattsApp terá função de pagamento em 2020."
                font.textContent = "Fonte: Proxima";
            }
        }
        x++;
    } 
}


document.body.addEventListener("keydown", (e) => {
    var element = document.body;
    element.classList.toggle("dark-mode");
});

window.onload = function () {
    setInterval(change, 5000);
};