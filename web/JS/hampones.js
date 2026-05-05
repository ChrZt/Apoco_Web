function mostrarLista() {
    let div = document.querySelector("#miLista");
    if (div.style.display === "none" || div.style.display === "") {
        div.style.display = "block";
    } else {
        div.style.display = "none";
    }
}

function imprimirResultado(){
    window.print();
}